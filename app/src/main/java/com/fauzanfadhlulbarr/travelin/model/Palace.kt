package com.fauzanfadhlulbarr.travelin.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Palace (
    var city: String ?="",
    var desc: String ?="",
    var imageUrl: String ?="",
    var namakota: String ?="",
    var harga: String ?="",
    var rating: String ?=""
) : Parcelable