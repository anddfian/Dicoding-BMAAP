package com.delixha.myuniversity

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.delixha.myuniversity.databinding.ItemUniversityBinding

class ListUniversityAdapter(private val listUniversity: ArrayList<University>) :
    RecyclerView.Adapter<ListUniversityAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        return ListViewHolder(ItemUniversityBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val university = listUniversity[position]
        holder.bind(university)
    }

    override fun getItemCount(): Int = listUniversity.size

    inner class ListViewHolder (private val binding: ItemUniversityBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(university: University) {
            binding.tvItemName.text = university.name
            binding.tvItemType.text = university.type
            binding.tvItemLocation.text = university.location
            Glide.with(binding.root)
                .load(university.logo)
                .listener(object : RequestListener<Drawable> {
                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
//                        MainActivity.binding.shimmerFrameLayout.stopShimmer()
//                        MainActivity.binding.shimmerFrameLayout.visibility = View.GONE
//                        MainActivity.binding.rvUniversity.visibility = View.VISIBLE
                        binding.shimmerFrameLayout.stopShimmer()
                        binding.shimmerFrameLayout.visibility = View.GONE
                        binding.clItem.visibility = View.VISIBLE
                        return false
                    }

                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        Toast.makeText(binding.root.context, "Error: $e", Toast.LENGTH_SHORT).show()
                        return false
                    }
                })
                .into(binding.imgItemLogo)
            binding.root.setOnClickListener { onItemClickCallback.onItemClicked(listUniversity[adapterPosition]) }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(university: University)
    }
}