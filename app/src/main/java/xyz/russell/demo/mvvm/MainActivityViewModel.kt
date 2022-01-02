package xyz.russell.demo.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private val _countLiveData = MutableLiveData(0)
    val countLiveData: LiveData<Int> = _countLiveData

    fun incrementByOne() {
        _countLiveData.value = _countLiveData.value?.plus(1)
    }

    fun minusByOne() {
        _countLiveData.value = _countLiveData.value?.minus(1)
    }
}