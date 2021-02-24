package com.dio.pimpmyfood

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Receita (
        val id: Int,
        val titulo: String,
        val ingredientes: String,
        val preparo: String,
        val autor: String,
        val foto: Int
): Parcelable {
}