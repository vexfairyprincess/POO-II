package com.example.s7_w5


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Capital Contable
        val activosInput = findViewById<EditText>(R.id.activosInput)
        val pasivosInput = findViewById<EditText>(R.id.pasivosInput)
        val btnCapital = findViewById<Button>(R.id.btnCapital)
        val resultCapital = findViewById<TextView>(R.id.resultCapital)


        btnCapital.setOnClickListener {
            val activos = activosInput.text.toString().toDoubleOrNull() ?: 0.0
            val pasivos = pasivosInput.text.toString().toDoubleOrNull() ?: 0.0
            resultCapital.text = "Resultado: ${activos - pasivos}"
        }


        // Nota Final
        val corte1 = findViewById<EditText>(R.id.corte1Input)
        val corte2 = findViewById<EditText>(R.id.corte2Input)
        val corte3 = findViewById<EditText>(R.id.corte3Input)
        val btnNota = findViewById<Button>(R.id.btnNotaFinal)
        val resultNota = findViewById<TextView>(R.id.resultNotaFinal)


        btnNota.setOnClickListener {
            val n1 = corte1.text.toString().toDoubleOrNull() ?: 0.0
            val n2 = corte2.text.toString().toDoubleOrNull() ?: 0.0
            val n3 = corte3.text.toString().toDoubleOrNull() ?: 0.0
            resultNota.text = "Resultado: ${(n1 + n2 + n3) / 3}"
        }


        // IVA
        val precioInput = findViewById<EditText>(R.id.precioInput)
        val btnIVA = findViewById<Button>(R.id.btnIVA)
        val resultIVA = findViewById<TextView>(R.id.resultIVA)


        btnIVA.setOnClickListener {
            val precio = precioInput.text.toString().toDoubleOrNull() ?: 0.0
            resultIVA.text = "Resultado: ${precio * 0.15}"
        }


        // INSS
        val salarioInput = findViewById<EditText>(R.id.salarioInput)
        val btnINSS = findViewById<Button>(R.id.btnINSS)
        val resultINSS = findViewById<TextView>(R.id.resultINSS)


        btnINSS.setOnClickListener {
            val salario = salarioInput.text.toString().toDoubleOrNull() ?: 0.0
            resultINSS.text = "Resultado: ${salario * 0.07}"
        }


        // Contar Letras
        val fraseInput = findViewById<EditText>(R.id.fraseInput)
        val btnLetras = findViewById<Button>(R.id.btnLetras)
        val resultLetras = findViewById<TextView>(R.id.resultLetras)


        btnLetras.setOnClickListener {
            val frase = fraseInput.text.toString()
            val letras = frase.replace("[^\\p{L}]".toRegex(), "")
            resultLetras.text = "Resultado: ${letras.length} letras"
        }
    }
}