package com.servicenow.presentation

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.servicenow.exercise.databinding.ActivityReviewListBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Matt Ng on 2/3/21.
 */
@AndroidEntryPoint
class ReviewListActivityNew : Activity() {

    private var _binding: ActivityReviewListBinding? = null
    private val binding: ActivityReviewListBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityReviewListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpViews()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private fun setUpViews() {
        with(binding.rvCoffeeShopReviews) {
            layoutManager = LinearLayoutManager(context)
            adapter = ReviewAdapter(items = TODO())
        }
    }
}