package ru.efremov.factorialtest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _state = MutableLiveData<State>()
    val state: LiveData<State>
        get() = _state

//    private val _error = MutableLiveData<Boolean>()
//    val error: LiveData<Boolean>
//        get() = _error
//
//    private val _factorial = MutableLiveData<String>()
//    val factorial: LiveData<String>
//        get() = _factorial
//
//    private val _progress = MutableLiveData<Boolean>()
//    val progress: LiveData<Boolean>
//        get() = _progress

    fun calculate(value: String?) {
        _state.value = Progress

        if (value.isNullOrBlank()) {
            _state.value = Error
            return
        }
        viewModelScope.launch {
            val number = value.toLong()
            // calculate
            delay(1000)
            _state.value = Result(factorial = number.toString())
        }
    }
}