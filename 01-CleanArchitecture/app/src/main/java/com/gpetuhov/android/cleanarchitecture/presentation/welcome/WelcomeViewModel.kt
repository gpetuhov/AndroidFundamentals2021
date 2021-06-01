package com.gpetuhov.android.cleanarchitecture.presentation.welcome

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gpetuhov.android.cleanarchitecture.App
import com.gpetuhov.android.cleanarchitecture.R
import com.gpetuhov.android.cleanarchitecture.domain.usecase.message.InputValidationException
import com.gpetuhov.android.cleanarchitecture.domain.usecase.message.MessageUseCase
import kotlinx.coroutines.*
import javax.inject.Inject

class WelcomeViewModel : ViewModel() {

    @Inject lateinit var messageUseCase: MessageUseCase

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
        App.appComponent.inject(this)

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
            try {
                val message = messageUseCase.getMessage { postGetMessageStarted() }
                postMessageResult(message)
            } catch (e: InputValidationException) {
                postMessageError(R.string.input_validation_error)
            }
        }
    }

    private fun resetEvents() {
        _isMessageLoading.postValue(false)
        _messageResult.postValue(null)
        _messageError.postValue(null)
    }

    private suspend fun postGetMessageStarted() {
        withContext(Dispatchers.Main) {
            _isMessageLoading.postValue(true)
        }
    }

    private suspend fun postMessageResult(message: String) {
        withContext(Dispatchers.Main) {
            _isMessageLoading.postValue(false)
            _messageResult.postValue(message)
        }
    }

    private suspend fun postMessageError(@StringRes errorMessageId: Int) {
        withContext(Dispatchers.Main) {
            _isMessageLoading.postValue(false)
            _messageError.postValue(errorMessageId)
        }
    }
}