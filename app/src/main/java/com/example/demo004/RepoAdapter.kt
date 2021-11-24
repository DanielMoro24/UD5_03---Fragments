package com.example.demo004

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.demo004.databinding.ItemRepoBinding
import com.example.demo004.extensions.imageUrl
import com.example.demo004.model.Repo
import com.example.demo004.model.Repos

class RepoAdapter(private val onRepoClicked: (Repo)-> Unit): ListAdapter<Repo, RepoAdapter.ViewHolder>(RepoItemCallback()) {
    inner class ViewHolder(val binding: ItemRepoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemRepoBinding = ItemRepoBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val repo = getItem(position)
        holder.binding.tvRepoName.text = repo.name.title+" "+repo.name.first+" "+repo.name.last
        holder.binding.tvRepoAvb.text = repo.location.country
        holder.binding.ivRepoImage.imageUrl(repo.picture.medium)
        holder.binding.root.setOnClickListener { onRepoClicked(repo)
        }

    }

}

class RepoItemCallback: DiffUtil.ItemCallback<Repo>(){
    override fun areItemsTheSame(oldItem: Repo, newItem: Repo): Boolean {
       return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Repo, newItem: Repo): Boolean {
        return oldItem.id == newItem.id
    }
}