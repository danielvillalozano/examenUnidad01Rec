package com.example.calculadora

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var txtUsuario: EditText
    private lateinit var txtContrasena: EditText
    private lateinit var btnIngresar: Button
    private lateinit var btnSalir: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtUsuario = findViewById(R.id.txtUsuario)
        txtContrasena = findViewById(R.id.txtContrasena)
        btnIngresar = findViewById(R.id.btnIngresar)
        btnSalir = findViewById(R.id.btnSalir)

        btnIngresar.setOnClickListener {
            val usuario = txtUsuario.text.toString().trim().lowercase()
            val contrasena = txtContrasena.text.toString().trim()

            if (usuario == "daniel" && contrasena == "1234") {
                val intent = Intent(this, CalculadoraActivity::class.java)
                intent.putExtra("daniel", usuario)
                startActivity(intent)
            } else {
                txtUsuario.error = "Datos incorrectos"
                txtContrasena.error = "Datos incorrectos"
            }
        }

        btnSalir.setOnClickListener {
            finish()
        }
    }
}
