package com.servicenow.presentation

import androidx.lifecycle.ViewModel
import com.servicenow.domain.CoffeeShopRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * Created by Matt Ng on 2/4/21.
 */
@HiltViewModel
class ReviewViewModel @Inject constructor(
    private val repository: CoffeeShopRepository,
    private val reviewUiModelFactory: ReviewUiModelFactory
) : ViewModel() {

    private val _state = MutableStateFlow<ReviewListContract.State>(ReviewListContract.State.Init)
    val state: StateFlow<ReviewListContract.State>
        get() = _state


    fun handleAction(action: ReviewListContract.Action) {
        when (action) {
            ReviewListContract.Action.ViewCreated -> handleViewCreated()
        }
    }

    private fun handleViewCreated() {
        val uiModels =
            repository.getCoffeeShopReviews().map { reviewUiModelFactory.createUiModel(it) }
        _state.value = ReviewListContract.State.Loaded(reviews = uiModels)
    }
}