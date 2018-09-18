package com.github.gibbrich.arrowgithub.view.repositories

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.github.gibbrich.arrowgithub.R
import com.github.gibbrich.arrowgithub.adapter.RepositoriesAdapter
import com.github.gibbrich.arrowgithub.model.Repository
import com.github.gibbrich.arrowgithub.presenter.RepositoryListPresenter
import com.github.gibbrich.arrowgithub.view.repository.RepositoryDetailActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.yesButton

class MainActivity : AppCompatActivity(), RepositoriesView {

    companion object {
        private const val TAG = "MainActivity"
    }

    private val repoList: MutableList<Repository> = mutableListOf()

    private lateinit var presenter: RepositoryListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = RepositoryListPresenter(this)

        setupList(repoList)

        presenter.getRepositories()
    }

    override fun showNotFoundError() {
        runOnUiThread {
            alert("Not found!") {
                yesButton {  }
            }.show()
        }
    }

    override fun showGenericError() {
        runOnUiThread {
            alert("Generic error!") {
                yesButton {  }
            }.show()
        }
    }

    override fun showAuthenticationError() {
        runOnUiThread {
            alert("Auth error") {
                yesButton {  }
            }.show()
        }
    }

    override fun drawRepositories(repositories: List<Repository>) {
        runOnUiThread {
            repoList.addAll(repositories)
            repositoryListRV.adapter?.notifyDataSetChanged()
        }
    }

    override fun switchToRepositoryDetailScreen(repositoryId: Long) {
        val intent = RepositoryDetailActivity.getIntent(this, repositoryId)
        startActivity(intent)
    }

    private fun setupList(listItems: List<Repository>) {
        repositoryListRV.layoutManager = LinearLayoutManager(this)
        repositoryListRV.adapter = RepositoriesAdapter(listItems, presenter::onRepositoryListItemClick)
    }
}
