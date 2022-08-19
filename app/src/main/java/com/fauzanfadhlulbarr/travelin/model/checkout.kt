package com.fauzanfadhlulbarr.travelin.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class checkout (
    var seat: String ?="",
    var harga: String ?="",

) : Parcelable