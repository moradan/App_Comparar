package com.curso.android.app.appcomparar

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.curso.android.app.appcomparar.databinding.ActividadCompararLayoutBinding

class ActividadComparar: AppCompatActivity() {

    private lateinit var bindings: ActividadCompararLayoutBinding
    private val comparacionModelView: ComparacionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindings = ActividadCompararLayoutBinding.inflate(layoutInflater)

        setContentView(bindings.root)

        comparacionModelView.mensaje.observe(this) {
            bindings.campoResultado.text = it.mensaje
        }

        bindings.botonComparar.setOnClickListener {
            comparacionModelView.compararTextos(bindings.campoTexto1.text.toString(), bindings.campoTexto2.text.toString())
        }
    }
}