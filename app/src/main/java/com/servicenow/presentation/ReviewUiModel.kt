package com.servicenow.presentation

import androidx.annotation.DrawableRes

/**
 * Created by Matt Ng on 2/4/21.
 */
data class ReviewUiModel(
    val name: String,
    val review: String,
    val rating: Int,
    val location: String,
    @DrawableRes val logo: Int
)