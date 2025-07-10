package com.example.calculadora

class Calculadora(
    private var num1: Float = 0f,
    private var num2: Float = 0f
) {

    fun suma(): Float {
        return num1 + num2
    }

    fun resta(): Float {
        return num1 - num2
    }

    fun multiplicacion(): Float {
        return num1 * num2
    }

    fun division(): Float {
        return if (num2 != 0f) num1 / num2 else 0f
    }

    fun setNumeros(n1: Float, n2: Float) {
        num1 = n1
        num2 = n2
    }
}
