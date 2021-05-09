package com.ewadus.katoon

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ewadus.katoon.databinding.ListItemGridviewBinding
import com.ewadus.katoon.network.VideoModel

class VdoGridAdapter: androidx.recyclerview.widget.ListAdapter<VideoModel,VdoGridAdapter.VDOPropertyViewHolder>(DiffCallback) {

    class VDOPropertyViewHolder(private var binding: ListItemGridviewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(vdoProperty: VideoModel) {
            binding.vdoNetwork = vdoProperty
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VdoGridAdapter.VDOPropertyViewHolder {
        return VDOPropertyViewHolder(ListItemGridviewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: VdoGridAdapter.VDOPropertyViewHolder, position: Int) {
        val vdosProperty = getItem(position)
        holder.bind(vdosProperty)
    }

    companion object DiffCallback: DiffUtil.ItemCallback<VideoModel>() {
        override fun areItemsTheSame(oldItem: VideoModel, newItem: VideoModel): Boolean {
            return  oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: VideoModel, newItem: VideoModel): Boolean {
            return oldItem.url == newItem.url
        }
    }


}