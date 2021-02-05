package com.servicenow.domain

/**
 * Created by Matt Ng on 2/4/21.
 */
data class Review(
    val name: String,
    val review: String,
    val rating: Int,
    val location: String
)
