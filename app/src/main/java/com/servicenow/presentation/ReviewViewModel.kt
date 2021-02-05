package com.servicenow.presentation

import androidx.lifecycle.ViewModel
import com.servicenow.domain.CoffeeShopRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
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

    @ExperimentalCoroutinesApi
    private val _state = MutableStateFlow(ReviewListContract.State.Init)

    @ExperimentalCoroutinesApi
    val state: StateFlow<ReviewListContract.State>
        get() = _state


}