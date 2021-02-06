package com.servicenow.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.servicenow.data.ReviewApi
import com.servicenow.domain.CoffeeShopRepository
import com.servicenow.domain.CoffeeShopRepositoryImpl
import com.servicenow.presentation.ReviewUiModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

/**
 * Created by Matt Ng on 2/4/21.
 *
 * I like to use HILT for handling dependency injection. HILT still uses
 * Dagger under the hood but they offer additional annotations for generating
 * the boiler plate code to account for your desired effects relating to the Android Life Cycle.
 */
@Module
@InstallIn(ViewModelComponent::class)
class CoffeeReviewModule {

    @Provides
    fun provideRetrofitClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonblob.com")
            .addConverterFactory(Json { ignoreUnknownKeys = true }
                .asConverterFactory("application/json".toMediaType()))
            .build()
    }

    @Provides
    fun provideReviewService(retrofit: Retrofit): ReviewApi {
        return retrofit.create(ReviewApi::class.java)
    }

    @Provides
    fun provideCoffeeShopRepository(reviewApi: ReviewApi): CoffeeShopRepository {
        return CoffeeShopRepositoryImpl(reviewApi = reviewApi)
    }

    @Provides
    fun provideReviewUiModelFactory(): ReviewUiModelFactory {
        return ReviewUiModelFactory()
    }
}