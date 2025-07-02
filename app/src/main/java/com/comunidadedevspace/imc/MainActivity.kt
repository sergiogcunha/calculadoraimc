package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //recuperar componentes edittext
        //criar variavel e associar componente de UI

        val edtPeso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edtAlt  = findViewById<TextInputEditText>(R.id.edt_altura)

        // recurperar o botão da tela

        val btnCalcular = findViewById<Button>(R.id.btn_calcular)

        // Calcular

        btnCalcular.setOnClickListener {
            val peso = edtPeso.text //pego o texto digitado
            val Alt = edtAlt.text // pego a altura

            println()
        }


    }
}