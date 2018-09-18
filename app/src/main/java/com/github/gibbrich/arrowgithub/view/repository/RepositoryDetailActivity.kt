package com.github.gibbrich.arrowgithub.view.repository

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.gibbrich.arrowgithub.R
import com.github.gibbrich.arrowgithub.presenter.RepositoryDetailPresenter
import kotlinx.android.synthetic.main.activity_repository_detail.*

class RepositoryDetailActivity : AppCompatActivity(), RepositoryDetailView {
    companion object {

        private const val EXTRA_REPOSITORY_ID = "EXTRA_REPOSITORY_ID"
        fun getIntent(context: Context, repositoryId: Long) = Intent(context, RepositoryDetailActivity::class.java).apply {
            putExtra(EXTRA_REPOSITORY_ID, repositoryId)
        }
    }
    private lateinit var presenter: RepositoryDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository_detail)

        presenter = RepositoryDetailPresenter(
                this,
                intent.getLongExtra(EXTRA_REPOSITORY_ID, 0)
        )

        presenter.initView()
    }

    override fun drawRepository(
            repositoryName: String,
            repositoryDescription: String,
            ownerName: String
    ) {
        repository_name.text = repositoryName
        owner_name.text = ownerName
        repository_description.text = repositoryDescription
    }
}
