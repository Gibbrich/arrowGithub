package com.github.gibbrich.arrowgithub.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.gibbrich.arrowgithub.R
import com.github.gibbrich.arrowgithub.model.Repository
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list_repository.view.*

class RepositoriesAdapter(
        private val characters: List<Repository>,
        private val itemClick: (Long) -> Unit
) : RecyclerView.Adapter<RepositoriesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, pos: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_repository, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
        holder.bind(characters[pos])
    }

    override fun getItemCount() = characters.size

    class ViewHolder(val view: View, private val itemClick: (Long) -> Unit) : RecyclerView.ViewHolder(view) {
        fun bind(repository: Repository) {
            with(repository) {
                Picasso.with(itemView.context).load(this.owner.avatarUrl).into(itemView.repoOwnerImage)
                itemView.setOnClickListener { itemClick(this.id) }

                itemView.repoName.text = this.name
                itemView.repoDescription.text = this.description
                itemView.repoForkCount.text = this.forksCount.toString()
                itemView.repoStarCount.text = this.stargazersCount.toString()
                itemView.repoOwnerName.text = this.owner.login
            }
        }
    }
}