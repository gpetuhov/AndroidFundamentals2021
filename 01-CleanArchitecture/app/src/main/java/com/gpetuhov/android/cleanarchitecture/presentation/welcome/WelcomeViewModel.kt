package com.gpetuhov.android.cleanarchitecture.presentation.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class WelcomeViewModel : ViewModel() {

    // Public properties should NOT be MutableLiveData,
    // so that outer classes cannot modify their values.
    val isMessageLoading: LiveData<Boolean>
    val messageResult: LiveData<String?>
    val messageError: LiveData<Int?>

    private val _isMessageLoading = MutableLiveData<Boolean>()
    private val _messageResult = MutableLiveData<String?>()
    private val _messageError = MutableLiveData<Int>()

    private var getMessageJob: Job? = null

    init {
        isMessageLoading = _isMessageLoading
        messageResult = _messageResult
        messageError = _messageError

        resetEvents()
    }

    override fun onCleared() {
        super.onCleared()
        getMessageJob?.cancel()
    }

    fun getMessage() {
        getMessageJob = viewModelScope.launch(Dispatchers.IO) {
            // TODO
        }
    }

    fun resetEvents() {
        _isMessageLoading.postValue(false)
        _messageResult.postValue(null)
        _messageError.postValue(null)
    }
}