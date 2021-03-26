package com.servicenow.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.servicenow.domain.CoffeeShopRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Matt Ng on 2/4/21.
 */
@HiltViewModel
class ReviewViewModel @Inject constructor(
    private val repository: CoffeeShopRepository,
    private val reviewUiModelFactory: ReviewUiModelFactory
) : ViewModel() {

    private val _effect = MutableSharedFlow<ReviewListContract.SideEffect>(
        extraBufferCapacity = 20,
        onBufferOverflow = BufferOverflow.DROP_OLDEST // gotta use this in order to be able to use tryEmit function
    )
    val effect: SharedFlow<ReviewListContract.SideEffect> = _effect

    private val _state = MutableStateFlow<ReviewListContract.State>(ReviewListContract.State.Init)
    val state: StateFlow<ReviewListContract.State>
        get() = _state


    fun handleAction(action: ReviewListContract.Action) {
        when (action) {
            ReviewListContract.Action.ViewCreated -> handleViewCreated()
            is ReviewListContract.Action.ReviewClicked -> handleReviewClicked(action.review)
        }
    }

    private fun handleViewCreated() {
        viewModelScope.launch {
            repository.getCoffeeShopReviews()
                .onSuccess { result ->
                    val uiModels = result.map { reviewUiModelFactory.createUiModel(it) }
                    _state.value = ReviewListContract.State.Loaded(reviews = uiModels)
                }
                .onFailure {
                    _state.value = ReviewListContract.State.Error
                }

        }
    }

    private fun handleReviewClicked(review: ReviewUiModel) {
        _effect.tryEmit(ReviewListContract.SideEffect.NavigateToReviewDetail(model = review))
    }
}