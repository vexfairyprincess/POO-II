package org.samm.s6w3.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

// Indica que esta clase manejará excepciones a nivel global en todos los controladores REST
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Manejador para errores de validación generados por @Valid (por ejemplo, campos nulos, strings muy cortos, etc.)
    @ExceptionHandler(MethodArgumentNotValidException.class) // Captura excepciones de validación
    public Map<String, String> handleValidationErrors(MethodArgumentNotValidException ex) {
        // Creamos un mapa para almacenar los errores con el nombre del campo y su mensaje
        Map<String, String> errors = new HashMap<>();

        // Iteramos por cada error encontrado en el binding (asignación de datos)
        ex.getBindingResult().getAllErrors().forEach(error -> {
            // Obtenemos el nombre del campo que falló
            String fieldName = ((FieldError) error).getField();

            // Obtenemos el mensaje de error definido en la anotación de validación
            String msg = error.getDefaultMessage();

            // Guardamos el campo y su mensaje en el mapa
            errors.put(fieldName, msg);
        });

        // Devolvemos el mapa de errores como respuesta en formato JSON
        return errors;
    }

    // Manejador para errores al deserializar JSON (por ejemplo: se manda texto donde se espera un número)
    @ExceptionHandler(HttpMessageNotReadableException.class) // Captura excepciones al leer el cuerpo de la solicitud
    @ResponseStatus(HttpStatus.BAD_REQUEST) // Devuelve un estado 400 (Bad Request)
    public Map<String, String> handleJsonParseError(HttpMessageNotReadableException ex) {
        // Creamos un mapa para devolver un error personalizado
        Map<String, String> error = new HashMap<>();

        // Obtenemos la causa real del error (puede ser por tipo de dato incorrecto, por ejemplo)
        Throwable cause = ex.getCause();

        // Si la causa es un formato inválido (ej. intentar convertir "kenaroooo" a Double)
        if (cause instanceof InvalidFormatException formatEx) {
            // Obtenemos el nombre del campo con el error (ej. "price")
            String field = formatEx.getPath().get(0).getFieldName();

            // Obtenemos el valor que no pudo convertirse (ej. "kenaroooo")
            String value = formatEx.getValue().toString();

            // Creamos un mensaje más claro sobre qué tipo de dato se esperaba
            error.put(field, "Invalid value: '" + value + "'. Please enter a valid " +
                    formatEx.getTargetType().getSimpleName().toLowerCase() + ".");
        } else {
            // Si no es un error de tipo específico, mandamos un mensaje genérico
            error.put("error", "Malformed JSON request.");
        }

        // Devolvemos el error como respuesta JSON
        return error;
    }
}