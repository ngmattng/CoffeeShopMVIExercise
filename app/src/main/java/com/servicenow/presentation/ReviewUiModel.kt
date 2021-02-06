package com.servicenow.presentation

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

/**
 * Created by Matt Ng on 2/4/21.
 */
@Parcelize
data class ReviewUiModel(
    val name: String,
    val review: String,
    val rating: Int,
    val location: String,
    @DrawableRes val logo: Int
) : Parcelable