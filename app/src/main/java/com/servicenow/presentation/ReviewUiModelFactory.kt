package com.servicenow.presentation

import androidx.annotation.DrawableRes
import com.servicenow.domain.Review
import com.servicenow.exercise.R
import java.lang.IllegalArgumentException

/**
 * Created by Matt Ng on 2/4/21.
 */
class ReviewUiModelFactory {

    fun createUiModel(model: Review): ReviewUiModel {
        return with(model) {
            ReviewUiModel(
                name = name,
                review = review,
                rating = rating,
                location = location,
                logo = getIconResourceFromReviewName(name)
            )
        }
    }

    @DrawableRes
    private fun getIconResourceFromReviewName(name: String): Int {
        return when (name) {
            "Lofty" -> R.drawable.bean_bag
            "Zumbar" -> R.drawable.coffee_cup
            "Blue Bottle" -> R.drawable.coffee_grinder
            "Bird Rock" -> R.drawable.coffee_maker
            "Better Buzz Coffee" -> R.drawable.coffee_shop
            else -> throw IllegalArgumentException("Review name $name is not supported.")
        }
    }
}