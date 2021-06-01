package com.gpetuhov.android.cleanarchitecture.presentation.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gpetuhov.android.cleanarchitecture.R
import com.gpetuhov.android.cleanarchitecture.domain.models.message.Message
import kotlinx.android.synthetic.main.fragment_message.*

class MessageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_message, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        message.text = getMessage().text
    }

    private fun getMessage(): Message {
        val args = MessageFragmentArgs.fromBundle(requireArguments())
        return args.message
    }
}