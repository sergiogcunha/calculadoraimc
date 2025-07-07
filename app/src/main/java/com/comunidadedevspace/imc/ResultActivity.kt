package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)

        tvResult.text = result.toString()

        val (classificacao: String, colorRes) = if (result <= 18.5f) {
            "MAGREZA" to R.color.imc_magreza
        } else if (result > 18.5f && result <= 24.9f) {
            "NORMAL" to R.color.imc_normal
        } else if (result > 25f && result <= 29.9f) {
            "SOBREPESO" to R.color.imc_sobrepeso
        } else if (result > 30 && result <= 39.9f) {
            "OBESIDADE" to R.color.imc_obesidade
        } else {
            "OBESIDADE GRAVE" to R.color.imc_obesidade_grave
        }

        tvClassificacao.text = classificacao
        tvClassificacao.setTextColor(ContextCompat.getColor(this, colorRes))


    }
}