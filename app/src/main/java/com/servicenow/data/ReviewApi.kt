package com.servicenow.data

import com.servicenow.data.models.ReviewResponse
import retrofit2.http.GET

/**
 * Created by Matt Ng on 2/4/21.
 */
interface ReviewApi {
    @GET("api/jsonblob/7d05a226-0f30-11eb-9726-59197e19feb3")
    suspend fun getReviews(): ReviewResponse
}