package com.joaovictor.firebaseauthgoogle.model

import com.google.firebase.database.IgnoreExtraProperties
import java.util.*

@IgnoreExtraProperties
data class Ride (
    val client: String? = "",
    val date: String? = "",
    val value: Float? = null
) {
}