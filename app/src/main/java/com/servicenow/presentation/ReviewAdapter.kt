package com.servicenow.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.servicenow.exercise.databinding.ItemReviewBinding

/**
 * Created by Matt Ng on 2/4/21.
 */
class ReviewAdapter(private val items: List<ReviewUiModel>) :
    RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        return ReviewViewHolder(
            binding = ItemReviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.bind(item = items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ReviewViewHolder(private val binding: ItemReviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ReviewUiModel) {
            with(binding) {
                ivReviewLogo.setImageResource(item.logo)
                tvName.text = item.name
                tvReview.text = item.review
            }
        }
    }
}