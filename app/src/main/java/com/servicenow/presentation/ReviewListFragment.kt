package com.servicenow.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.servicenow.exercise.databinding.FragmentReviewListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

/**
 * Created by Matt Ng on 2/6/21.
 */
@AndroidEntryPoint
class ReviewListFragment : Fragment() {

    private var _binding: FragmentReviewListBinding? = null
    private val binding: FragmentReviewListBinding
        get() = _binding!!

    private val viewModel: ReviewViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReviewListBinding.inflate(layoutInflater, container, false)
        setUpStateObserver()
        viewModel.handleAction(ReviewListContract.Action.ViewCreated)
        return binding.root
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
        Toast.makeText(requireContext(), "There was an error, please try again.", Toast.LENGTH_LONG)
            .show()
    }
}