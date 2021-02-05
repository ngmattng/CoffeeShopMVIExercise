package com.servicenow.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Matt Ng on 2/4/21.
 */
@Serializable
data class ReviewResponse(
    @SerialName("Reviews")
    val reviews: List<ReviewEntity>
)