package com.servicenow.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.servicenow.exercise.R
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Matt Ng on 2/3/21.
 *
 * This project is set up following Clean Architecture guidelines.  I broke up
 * this codebase into data, domain, and presentation layers for clear separation of concerns
 * and to abstract out implementation details from the outer layers.
 *
 * For this project I opted for a "Single Activity-Multiple Fragment" approach
 * as per Android guidelines.
 *
 * For screen-to-screen navigation I elected to use the Jetpack Navigation Component to
 * manage Fragment navigation.
 * The Navigation Component makes it much easier to manage navigating between Fragments.
 */
@AndroidEntryPoint
class ReviewListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_list)
    }
}