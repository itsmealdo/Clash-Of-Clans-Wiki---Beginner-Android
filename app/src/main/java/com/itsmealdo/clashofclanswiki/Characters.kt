package com.itsmealdo.clashofclanswiki

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Characters (
    val nameCharacter: String,
    val descCharacter: String,
    val photoCharacter: Int
) : Parcelable