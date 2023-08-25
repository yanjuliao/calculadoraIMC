package com.example.calcularimc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var txtResultado : TextView
    private lateinit var edtPeso :  EditText
    private lateinit var edtAltura: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtResultado = findViewById(R.id.txtResultado)
        edtAltura    = findViewById(R.id.edtAltura)
        edtPeso      = findViewById(R.id.edtPeso)
    }

    @SuppressLint("SetTextI18n")
    fun calcularImc(view: View) {
        val peso = edtPeso.text.toString().toDoubleOrNull()
        val altura = edtAltura.text.toString().toDoubleOrNull()

        if (peso != null && altura != null) {
            val imc = peso / (altura * altura)

            if (imc < 19){
                txtResultado.text = "Você está abaixo do peso"
            }else if (imc >= 19 && imc < 25){
                txtResultado.text = "Seu peso está normal"
            }else if (imc >= 25 && imc < 30){
                txtResultado.text = "Você está com sobrepeso"
            }else if(imc >= 30 && imc < 40){
                txtResultado.text = "Obesidade tipo 1"
            }else if(imc >= 40){
                txtResultado.text = "Obesidade tipo 2"
            }
        } else {
            txtResultado.text = "Por favor, insira valores válidos para peso e altura."
        }
    }

    fun limparCampos(view:View){
        edtPeso.text.clear()
        edtAltura.text.clear()
        txtResultado.text = "Resultado:"


    }
}