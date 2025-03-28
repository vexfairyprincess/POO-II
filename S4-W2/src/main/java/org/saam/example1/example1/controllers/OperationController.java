package org.saam.example1.example1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController

public class OperationController {

    @GetMapping("/hola")
    public Map<String, String>holaMundo(){
        Map<String, String > json = new HashMap<>();
        json.put("mensaje", "Hola Mundo");
        return json;
    }

    @PostMapping("/add")
    public Map<String,Integer> add(@RequestBody Map<String,Integer> request){
        Map<String, Integer> result = new HashMap<>();
        int num1 = request.get("num1");
        int num2 = request.get("num2");
        result.put("suma", num1 + num2);
        return result;
    }

    @PostMapping("/getIVA")
    public Map<String, Double> getIVA(@RequestBody Map<String, Double> request){
        Map<String, Double> result = new HashMap<>();
        double precio = request.get("precio");
        double iva = precio * 0.15;
        result.put("iva", iva);
        result.put("total", precio + iva);
        return result;
    }
}
