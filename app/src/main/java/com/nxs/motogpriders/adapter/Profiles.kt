package com.nxs.motogpriders.adapter

import java.io.Serializable

data class Profiles (
    val name: String,
    val description: String,
    val image: Int,
    val team: String
) : Serializable