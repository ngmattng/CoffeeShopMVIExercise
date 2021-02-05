package com.servicenow.data.models

import com.servicenow.domain.Review
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Matt Ng on 2/4/21.
 */
@Serializable
data class ReviewEntity(
    @SerialName("Name")
    val name: String,
    @SerialName("Review")
    val review: String,
    @SerialName("Rating")
    val rating: Int,
    @SerialName("Location")
    val location: String
)

fun ReviewEntity.toDomainModel() = Review(
    name = name,
    review = review,
    rating = rating,
    location = location
)