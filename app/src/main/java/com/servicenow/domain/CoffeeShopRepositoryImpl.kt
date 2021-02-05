package com.servicenow.domain

import com.servicenow.data.ReviewApi
import com.servicenow.data.models.toDomainModel

/**
 * Created by Matt Ng on 2/4/21.
 */
class CoffeeShopRepositoryImpl(private val reviewApi: ReviewApi) : CoffeeShopRepository {

    override suspend fun getCoffeeShopReviews(): List<Review> {
        return reviewApi.getReviews().reviews.map { it.toDomainModel() }
    }
}