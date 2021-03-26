package com.servicenow.presentation

/**
 * Created by Matt Ng on 2/4/21.
 */
interface ReviewListContract {

    sealed class Action{
        object ViewCreated: Action()
        data class ReviewClicked(val review: ReviewUiModel): Action()
    }

    sealed class State {
        object Init : State()
        data class Loaded(val reviews: List<ReviewUiModel>) : State()
        object Error: State()
    }

    sealed class SideEffect{
        data class NavigateToReviewDetail(val model: ReviewUiModel): SideEffect()
    }
}