package br.com.igorbag.githubsearch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.githubsearch.R
import br.com.igorbag.githubsearch.domain.Repository
import android.widget.TextView
import android.widget.ImageView

class RepositoryAdapter(private val repositories: List<Repository>) :
    RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>() {

    var itemClickListener: (Repository) -> Unit = {}
    var shareButtonClickListener: (Repository) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return RepositoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        val repository = repositories[position]

        holder.repositoryName.text = repository.name

        holder.itemView.setOnClickListener {
            itemClickListener(repository)
        }

        holder.shareButton.setOnClickListener {
            shareButtonClickListener(repository)
        }
    }

    override fun getItemCount(): Int = repositories.size

    class RepositoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val repositoryName: TextView
        val shareButton: ImageView

        init {
            view.apply {
                repositoryName = findViewById(R.id.tv_preco)
                shareButton = findViewById(R.id.iv_favorite)
            }
        }
    }
}


