package ru.tech_reliab.githubrepos.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.tech_reliab.githubrepos.R
import ru.tech_reliab.githubrepos.databinding.ActivityMainBinding
import ru.tech_reliab.githubrepos.databinding.ListItemRepositoryBinding
import ru.tech_reliab.githubrepos.model.UserRepository

class RepositoryAdapter {
}
class ReposAdapter(repos: List<UserRepository>) :
    RecyclerView.Adapter<ReposAdapter.ReposViewHolder>() {
    var repos: List<UserRepository> = listOf()

    fun refresh(repos: List<UserRepository>) {
        this.repos = repos
        notifyDataSetChanged()
    }
    class ReposViewHolder(val binding: ListItemRepositoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(repos: UserRepository){
            binding.repoName.text = repos.name
            binding.repoDescription.text = repos.description
            binding.repoLanguage.text = repos.language
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReposViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding = ListItemRepositoryBinding.inflate(view, parent, false)
        return ReposViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReposViewHolder, position: Int) {
        holder.bind(repos[position])
    }

    override fun getItemCount(): Int {
        return repos.size
    }
}