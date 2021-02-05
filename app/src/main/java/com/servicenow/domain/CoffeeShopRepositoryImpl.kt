package com.servicenow.domain

import com.servicenow.data.ReviewService
import com.servicenow.data.toDomainModel

/**
 * Created by Matt Ng on 2/4/21.
 */
class CoffeeShopRepositoryImpl(private val reviewService: ReviewService) : CoffeeShopRepository {

    override fun getCoffeeShopReviews(): List<Review> {
        return reviewService.getReviews().map { it.toDomainModel() }
    }
}