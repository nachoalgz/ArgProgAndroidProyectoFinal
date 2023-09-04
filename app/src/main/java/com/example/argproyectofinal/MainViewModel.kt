package com.example.argproyectofinal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.argproyectofinal.model.Cadena
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    val resultado: LiveData<Cadena> get() = _resultado
    val str1: LiveData<Cadena> get() = _str1
    val str2: LiveData<Cadena> get() = _str2

    private var _resultado = MutableLiveData<Cadena>(Cadena(""))
    private var _str1 = MutableLiveData<Cadena>(Cadena(""))
    private var _str2 = MutableLiveData<Cadena>(Cadena(""))



    fun compareStr(strA: String, strB: String){
        _str1.value = Cadena(strA)
        _str2.value = Cadena(strB)
        val resCmp: Boolean = _str1.value == _str2.value
        if (resCmp) {
            updateStr("Son Iguales")
        } else{
            updateStr("Son Distintas")
        }
    }

    fun updateStr(newStr: String){
        viewModelScope.launch {
            _resultado.value = Cadena(newStr)
        }
    }
}