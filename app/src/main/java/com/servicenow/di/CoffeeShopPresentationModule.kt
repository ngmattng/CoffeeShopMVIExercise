package com.servicenow.di

import com.servicenow.presentation.ReviewUiModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by Matt Ng on 2/4/21.
 */
@Module
@InstallIn(SingletonComponent::class)
object CoffeeShopPresentationModule {

    @Provides
    fun provideReviewUiModelFactory(): ReviewUiModelFactory {
        return ReviewUiModelFactory()
    }
}