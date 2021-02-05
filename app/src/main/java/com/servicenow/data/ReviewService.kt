package com.servicenow.data

/**
 * Created by Matt Ng on 2/4/21.
 */
interface ReviewService {
    fun getReviews(): List<ReviewEntity>
}