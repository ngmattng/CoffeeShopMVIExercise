package com.servicenow.presentation

import android.app.Activity
import android.os.Bundle
import com.servicenow.exercise.databinding.ActivityReviewListBinding

/**
 * Created by Matt Ng on 2/3/21.
 */
class ReviewListActivityNew : Activity() {

    private var _binding: ActivityReviewListBinding? = null
    private val binding: ActivityReviewListBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityReviewListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}