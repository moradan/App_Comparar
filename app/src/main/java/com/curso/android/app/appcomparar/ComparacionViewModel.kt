package com.curso.android.app.appcomparar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ComparacionViewModel: ViewModel() {

    private var _mensaje = MutableLiveData(TextoComparacion.VACIO)
    val mensaje: LiveData<TextoComparacion> get() = _mensaje

    fun compararTextos(texto1: String, texto2: String) {
        if (texto1.equals(texto2, true)) {
            _mensaje.value = TextoComparacion.IGUALES
        } else {
            _mensaje.value = TextoComparacion.DISTINTOS
        }
    }
}
