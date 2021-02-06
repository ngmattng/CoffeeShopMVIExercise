package com.servicenow.domain

import com.servicenow.data.ReviewApi
import com.servicenow.data.models.toDomainModel
import java.lang.Exception

/**
 * Created by Matt Ng on 2/4/21.
 *
 * I am a big fan of the "Either" or "Result" pattern.  This way your request calls will
 * always return an object. The call site will then handle the result of the request
 * based on "success" or "failure.
 *
 */
class CoffeeShopRepositoryImpl(private val reviewApi: ReviewApi) : CoffeeShopRepository {

    override suspend fun getCoffeeShopReviews(): Result<List<Review>> {
        return try {
            Result.success(reviewApi.getReviews().reviews.map { it.toDomainModel() })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}