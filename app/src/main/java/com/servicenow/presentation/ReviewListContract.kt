package com.servicenow.presentation

/**
 * Created by Matt Ng on 2/4/21.
 */
interface ReviewListContract {

    sealed class State {
        object Init : State()
        data class Loaded(val reviews: List<ReviewUiModel>) : State()
    }
}