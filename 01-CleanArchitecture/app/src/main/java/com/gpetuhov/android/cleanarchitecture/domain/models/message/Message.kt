package com.gpetuhov.android.cleanarchitecture.domain.models.message

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Message(val text: String) : Parcelable