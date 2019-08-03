package com.nxs.motogpriders.adapter

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
@Parcelize
data class Profiles (
    val name: String,
    val description: String,
    val image: Int,
    val team: String
) : Parcelable