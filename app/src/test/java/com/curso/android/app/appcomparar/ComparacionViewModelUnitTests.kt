package com.curso.android.app.appcomparar

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(ExperimentalCoroutinesApi::class)
class ComparacionViewModelUnitTests {

    private lateinit var viewModel: ComparacionViewModel

    @get: Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = ComparacionViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun campoResultado_InicializaVacio() = runTest {
        val campoResultado = viewModel.mensaje.value
        assertEquals(TextoComparacion.VACIO, campoResultado)
    }

    @Test
    fun metodoComparar_Igual() = runTest {
        launch {
            viewModel.compararTextos("","")
        }

        advanceUntilIdle()

        val resultado = viewModel.mensaje.value

        assertEquals(TextoComparacion.IGUALES, resultado)
    }

    @Test
    fun metodoComparar_Distinto() = runTest {
        launch {
            viewModel.compararTextos("H", "")
        }

        advanceUntilIdle()

        val resultado = viewModel.mensaje.value

        assertEquals(TextoComparacion.DISTINTOS, resultado)
    }
}