package com.servicenow.data

import com.servicenow.domain.Review

/**
 * Created by Matt Ng on 2/4/21.
 */
data class ReviewEntity(
    val name: String,
    val review: String,
    val rating: Int,
    val location: String
)

fun ReviewEntity.toDomainModel() = Review(
    name = name,
    review = review,
    rating = rating,
    location = location
)