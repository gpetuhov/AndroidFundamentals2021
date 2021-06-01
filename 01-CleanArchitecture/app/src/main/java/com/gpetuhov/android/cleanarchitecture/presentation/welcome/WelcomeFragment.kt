package com.gpetuhov.android.cleanarchitecture.presentation.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.gpetuhov.android.cleanarchitecture.R
import com.gpetuhov.android.cleanarchitecture.utils.Logger
import com.gpetuhov.android.cleanarchitecture.utils.extensions.setVisible
import com.gpetuhov.android.cleanarchitecture.utils.extensions.toast
import kotlinx.android.synthetic.main.fragment_welcome.*

class WelcomeFragment : Fragment() {

    private val viewModel by viewModels<WelcomeViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        get_message_button.setOnClickListener { onGetMessageButtonClick() }

        subscribeViewModel()
    }

    private fun onGetMessageButtonClick() {
        Logger.log("Message", "Get message click")
        viewModel.getMessage()
    }

    private fun subscribeViewModel() {
        viewModel.isMessageLoading.observe(viewLifecycleOwner, { isLoading -> onMessageLoading(isLoading) })
        viewModel.messageResult.observe(viewLifecycleOwner, { message -> onMessageResult(message) })
        viewModel.messageError.observe(viewLifecycleOwner, { errorMessageId -> onMessageError(errorMessageId) })
    }

    private fun onMessageLoading(isLoading: Boolean) {
        enableControls(!isLoading)
        showProgress(isLoading)
    }

    private fun enableControls(isEnabled: Boolean) {
        get_message_button.isEnabled = isEnabled
    }

    private fun showProgress(isVisible: Boolean) {
        get_message_progress.setVisible(isVisible)
    }

    private fun onMessageResult(message: String?) {
        message?.let {
            // TODO
            toast(it)

            // Needed to prevent message from showing again after screen rotation
            viewModel.resetEvents()
        }
    }

    private fun onMessageError(errorMessageId: Int?) {
        errorMessageId?.let {
            toast(it)

            // Needed to prevent error from showing again after screen rotation
            viewModel.resetEvents()
        }
    }
}