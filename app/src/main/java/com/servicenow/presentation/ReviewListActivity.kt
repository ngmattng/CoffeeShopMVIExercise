package com.servicenow.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.servicenow.exercise.databinding.ActivityReviewListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

/**
 * Created by Matt Ng on 2/3/21.
 */
@AndroidEntryPoint
class ReviewListActivity : AppCompatActivity() {

    private val viewModel: ReviewViewModel by viewModels()

    private var _binding: ActivityReviewListBinding? = null
    private val binding: ActivityReviewListBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityReviewListBinding.inflate(layoutInflater)
        setUpStateObserver()
        setContentView(binding.root)
        viewModel.handleAction(ReviewListContract.Action.ViewCreated)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private fun setUpStateObserver() {
        lifecycleScope.launchWhenStarted {
            viewModel.state.collectLatest { handleStateUpdated(it) }
        }
    }

    private fun handleStateUpdated(state: ReviewListContract.State) {
        when (state) {
            ReviewListContract.State.Init -> handleInitState()
            is ReviewListContract.State.Loaded -> handleLoadedState(state)
            ReviewListContract.State.Error -> handleErrorState()
        }
    }

    private fun handleInitState() {
        binding.pbLoading.isVisible = true
    }

    private fun handleLoadedState(state: ReviewListContract.State.Loaded) {
        binding.pbLoading.isVisible = false
        with(binding.rvCoffeeShopReviews) {
            layoutManager = LinearLayoutManager(context)
            adapter = ReviewAdapter(items = state.reviews)
        }
    }

    private fun handleErrorState() {
        binding.pbLoading.isVisible = false
        Toast.makeText(baseContext, "There was an error, please try again.", Toast.LENGTH_LONG)
            .show()
    }
}