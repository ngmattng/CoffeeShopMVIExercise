package com.servicenow.domain

/**
 * Created by Matt Ng on 2/4/21.
 */
interface CoffeeShopRepository {
    suspend fun getCoffeeShopReviews(): List<Review>
}