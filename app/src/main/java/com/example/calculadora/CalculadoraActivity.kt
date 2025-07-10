package com.example.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculadoraActivity : AppCompatActivity() {

    private lateinit var lblUsuario: TextView
    private lateinit var txtNum1: EditText
    private lateinit var txtNum2: EditText
    private lateinit var lblResultado: TextView
    private lateinit var btnSuma: Button
    private lateinit var btnResta: Button
    private lateinit var btnMult: Button
    private lateinit var btnDiv: Button
    private lateinit var btnLimpiar: Button
    private lateinit var btnRegresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        lblUsuario = findViewById(R.id.lblUsuario)
        txtNum1 = findViewById(R.id.txtNum1)
        txtNum2 = findViewById(R.id.txtNum2)
        lblResultado = findViewById(R.id.lblResultado)
        btnSuma = findViewById(R.id.btnSuma)
        btnResta = findViewById(R.id.btnResta)
        btnMult = findViewById(R.id.btnMult)
        btnDiv = findViewById(R.id.btnDiv)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnRegresar = findViewById(R.id.btnRegresar)

        val usuario = intent.getStringExtra("usuario")
        lblUsuario.text = usuario

        btnSuma.setOnClickListener { operar("+") }
        btnResta.setOnClickListener { operar("-") }
        btnMult.setOnClickListener { operar("*") }
        btnDiv.setOnClickListener { operar("/") }

        btnLimpiar.setOnClickListener {
            txtNum1.text.clear()
            txtNum2.text.clear()
            lblResultado.text = "Resultado"
        }

        btnRegresar.setOnClickListener {
            finish()
        }
    }

    private fun operar(op: String) {
        val num1 = txtNum1.text.toString().toFloatOrNull()
        val num2 = txtNum2.text.toString().toFloatOrNull()

        if (num1 == null || num2 == null) {
            lblResultado.text = "Ingresa números"
            return
        }

        val res = when (op) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> if (num2 != 0f) num1 / num2 else "Error"
            else -> "?"
        }

        lblResultado.text = "Resultado: $res"
    }
}
