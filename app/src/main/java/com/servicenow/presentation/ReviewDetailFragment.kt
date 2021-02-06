package com.servicenow.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.servicenow.exercise.databinding.FragmentReviewDetailBinding

/**
 * Created by Matt Ng on 2/6/21.
 */
class ReviewDetailFragment : Fragment() {

    private var _binding: FragmentReviewDetailBinding? = null
    private val binding: FragmentReviewDetailBinding
        get() = _binding!!

    private val safeArgs: ReviewDetailFragmentArgs by lazy {
        ReviewDetailFragmentArgs.fromBundle(
            requireArguments()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentReviewDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private fun setUpViews() {
        with(binding) {
            ivBack.setOnClickListener {
                findNavController().navigateUp()
            }

            ivReviewLogo.setImageResource(safeArgs.reviewUiModel.logo)
            tvName.text = safeArgs.reviewUiModel.name
            tvReview.text = safeArgs.reviewUiModel.review
            tvLocation.text = safeArgs.reviewUiModel.location
            tvRating.text = safeArgs.reviewUiModel.rating.toString()
        }
    }
}