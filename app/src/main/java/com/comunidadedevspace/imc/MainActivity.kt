package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtPeso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edtAlt = findViewById<TextInputEditText>(R.id.edt_altura)

        val btnCalcular = findViewById<Button>(R.id.btn_calcular)

        btnCalcular.setOnClickListener {
            val pesoStr: String = edtPeso.text.toString() //pego o texto digitado
            val altStr: String = edtAlt.text.toString() // pego a altura

            if (pesoStr == "" || altStr == "") {
                Snackbar.make(
                    edtPeso,
                    "Preencher todos os campos",
                    Snackbar.LENGTH_LONG
                ).show()

            } else {

                val peso = pesoStr.toFloat()
                val altura = altStr.toFloat()

                val alturaq2 = altura * altura
                val resultado = peso / alturaq2

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_RESULT_IMC, resultado) // chave para ligar as activity
                startActivity(intent)

            }
        }
    }
}