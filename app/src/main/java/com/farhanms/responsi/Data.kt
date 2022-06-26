package com.farhanms.responsi

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Data (
    var nim: String ?="",
    var nama: String ?="",
    var nohp: String ?="",
    var alamat: String ?="",
    var email: String ?="",
    var randomid: String ?=""

): Parcelable