package com.data.assignment.mvp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.data.assignment.Model.Children
import com.data.assignment.R
import com.data.assignment.databinding.ActivityImageLoaderBinding
import com.data.assignment.mvp.adapter.ImageLoadAdapter
import com.data.assignment.mvp.contract.ImageLoaderContract
import com.data.assignment.mvp.presenter.ImageLoaderPresenter

class ImageLoaderActivity : AppCompatActivity(), ImageLoaderContract.View {

    private var imageLoaderPresenter: ImageLoaderPresenter? = null
    private lateinit var binding: ActivityImageLoaderBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_image_loader)
        presenter?.fetchDataForShowingImage()
    }

    private val presenter: ImageLoaderPresenter?
        get() {
            if (imageLoaderPresenter == null) imageLoaderPresenter = ImageLoaderPresenter(this)
            return imageLoaderPresenter
        }

    override fun fetchImageList(response: List<Children>) {
        val imageLoaderAdapter = ImageLoadAdapter(this, response)
        val mLayoutManager = LinearLayoutManager(this)
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )
        binding.recyclerView.setLayoutManager(mLayoutManager)
        binding.recyclerView.setNestedScrollingEnabled(false)
        binding.recyclerView.setAdapter(imageLoaderAdapter)

    }

    override fun apiFailure(failureMessage: String) {

    }
}
