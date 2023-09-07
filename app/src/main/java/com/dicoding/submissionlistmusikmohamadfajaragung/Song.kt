package com.dicoding.submissionlistmusikmohamadfajaragung

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Song(
    val name: String,
    val genre: String,
    val photo: Int,
    val lyrics: String,
) :Parcelable
