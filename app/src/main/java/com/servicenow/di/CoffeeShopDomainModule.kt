package com.servicenow.di

import com.servicenow.data.ReviewService
import com.servicenow.domain.CoffeeShopRepository
import com.servicenow.domain.CoffeeShopRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by Matt Ng on 2/4/21.
 */
@Module
@InstallIn(SingletonComponent::class)
object CoffeeShopDomainModule {

    @Provides
    fun provideCoffeeShopRepository(reviewService: ReviewService): CoffeeShopRepository{
        return CoffeeShopRepositoryImpl(reviewService = reviewService)
    }
}