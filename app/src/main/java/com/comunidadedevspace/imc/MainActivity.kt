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

        //recuperar componentes edittext
        //criar variavel e associar componente de UI

        val edtPeso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edtAlt = findViewById<TextInputEditText>(R.id.edt_altura)

        // recurperar o botão da tela

        val btnCalcular = findViewById<Button>(R.id.btn_calcular)

        // Calcular

        btnCalcular.setOnClickListener {
            val pesoStr: String = edtPeso.text.toString() //pego o texto digitado
            val altStr: String = edtAlt.text.toString() // pego a altura

            if (pesoStr == "" || altStr == "") {
                Snackbar.make(
                    edtAlt,
                    "Preencher todos os campos",
                    Snackbar.LENGTH_LONG
                ).show()
                // mensagem ao usuário
            } else {

                val peso = pesoStr.toFloat()
                val altura = altStr.toFloat()

                val alturaq2 = altura * altura
                val resultado = peso / alturaq2

                // navegar para proxima tela
                // criar o layout da proxma tela
                // passar dados para proxima tela

                //intent  - class do proprio android / implicita e explicita
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_RESULT_IMC,resultado) // chave para ligar as activity
                startActivity(intent)
                println("sergio teste " + resultado)


            }
        }
    }
}