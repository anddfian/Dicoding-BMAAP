package com.delixha.myuniversity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class University(
    val name: String,
    val type: String,
    val location: String,
    val logo: String,
    val accreditation: String,
    val description: String,
    val rector: String,
    val rectorPhoto: String,
    val motto: String,
    val established: String,
    val campus: String,
    val color: String,
    val website: String,
    val photo: String
) : Parcelable