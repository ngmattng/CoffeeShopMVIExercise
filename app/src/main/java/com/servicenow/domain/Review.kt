package com.servicenow.domain

/**
 * Created by Matt Ng on 2/4/21.
 *
 * The Domain level model represents what that feature object should look like.
 * The reason for this is because you want to program defensively to protect you from server model
 * changes.
 */
data class Review(
    val name: String,
    val review: String,
    val rating: Int,
    val location: String
)
