package com.curso.android.app.appcomparar

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class ActivdadCompararTest {

    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(ActividadComparar::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun actividadComparar_comparacionInicial() {
        Espresso.onView(
            ViewMatchers.withId(R.id.boton_comparar)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.campo_resultado)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText(TextoComparacion.DISTINTOS.mensaje)
            )
        )
    }
}