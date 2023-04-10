package com.example.wout

import android.os.Parcel
import android.os.Parcelable

class List1(val img:Int,val tx1:String,val tx2:String):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(img)
        parcel.writeString(tx1)
        parcel.writeString(tx2)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<List1> {
        override fun createFromParcel(parcel: Parcel): List1 {
            return List1(parcel)
        }

        override fun newArray(size: Int): Array<List1?> {
            return arrayOfNulls(size)
        }
    }
}