package com.servicenow.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.servicenow.exercise.R
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Matt Ng on 2/3/21.
 */
@AndroidEntryPoint
class ReviewListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_list)
    }
}