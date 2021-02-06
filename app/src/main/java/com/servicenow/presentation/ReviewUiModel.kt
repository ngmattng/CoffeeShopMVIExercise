package com.servicenow.presentation

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

/**
 * Created by Matt Ng on 2/4/21.
 *
 * The UI model represents values the views should use to set its properties.
 * There should be no further logic required to manipulate these values.
 * The View should stay dumb and just take the property value and set it.
 */
@Parcelize
data class ReviewUiModel(
    val name: String,
    val review: String,
    val rating: Int,
    val location: String,
    @DrawableRes val logo: Int
) : Parcelable