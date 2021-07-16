package com.alfaiz.app.newyou.data
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(
        var image: Int,
        var name:String,
        var detail:String
):Parcelable