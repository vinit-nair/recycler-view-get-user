package com.example.assessmentrecyclerviewget

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserData(val name: String, val username: String, val email: String) : Parcelable {

}
