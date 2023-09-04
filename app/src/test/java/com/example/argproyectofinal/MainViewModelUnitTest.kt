package com.example.argproyectofinal

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MainViewModelUnitTest {
    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup(){
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
//Verifico que el valor incial de resultado sea "" (cadena vacia)
    @Test
    fun mainViewModelInitialValueCheck() = runTest{
        val value = viewModel.resultado.value?.dataString
        assertEquals("",value)
    }
//Verifico que los valores almacenados en el viewmodel sean igual a los valores ingresados en los EditText
    @Test
    fun mainViewModelSaveValues() = runTest {
        val str1: String = R.id.EditText1.toString()
        val str2: String = R.id.EditText2.toString()
        launch {
            viewModel.compareStr(str1, str2)
        }
        advanceUntilIdle()

        val value1 = viewModel.str1.value?.dataString
        val value2 = viewModel.str2.value?.dataString
        assertEquals(str1, value1)
        assertEquals(str2, value2)
    }
}