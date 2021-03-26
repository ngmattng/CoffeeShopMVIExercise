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
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.servicenow.exercise.databinding.FragmentReviewListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest

/**
 * Created by Matt Ng on 2/6/21.
 *
 * Architecturally this is set up somewhere between MVI and MVVM.  Ideally, the ViewModel only
 * exposes one public function for the view to interact with and the view would only ever interact
 * with the ViewModel through Actions in order to stay as dumb as possible.  The View would only observe
 * a State object and handle change appropriately when the State object changes.
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
        setUpSideEffectObserver()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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

    private fun setUpSideEffectObserver() {
        lifecycleScope.launchWhenStarted {
            viewModel.effect.collect { handleSideEffect(it) }
        }
    }

    private fun handleStateUpdated(state: ReviewListContract.State) {
        when (state) {
            ReviewListContract.State.Init -> handleInitState()
            is ReviewListContract.State.Loaded -> handleLoadedState(state)
            ReviewListContract.State.Error -> handleErrorState()
        }
    }

    private fun handleSideEffect(effect: ReviewListContract.SideEffect) {
        when (effect) {
            is ReviewListContract.SideEffect.NavigateToReviewDetail -> {
                findNavController().navigate(
                    ReviewListFragmentDirections.actionToReviewDetail(
                        effect.model
                    )
                )
            }
        }
    }

    private fun handleInitState() {
        binding.pbLoading.isVisible = true
    }

    private fun handleLoadedState(state: ReviewListContract.State.Loaded) {
        binding.pbLoading.isVisible = false
        with(binding.rvCoffeeShopReviews) {
            layoutManager = LinearLayoutManager(context)
            adapter = ReviewAdapter(
                items = state.reviews,
                onItemClick = ::onReviewItemClick
            )
        }
    }

    private fun handleErrorState() {
        binding.pbLoading.isVisible = false
        Toast.makeText(requireContext(), "There was an error, please try again.", Toast.LENGTH_LONG)
            .show()
    }

    private fun onReviewItemClick(model: ReviewUiModel) {
        viewModel.handleAction(ReviewListContract.Action.ReviewClicked(review = model))
    }
}