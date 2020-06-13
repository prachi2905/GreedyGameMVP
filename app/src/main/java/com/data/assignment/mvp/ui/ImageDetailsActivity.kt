package com.data.assignment.mvp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.data.assignment.AppConstatnt.AppConstant
import com.data.assignment.R
import com.data.assignment.databinding.ActivityImageDetailsBinding
import com.data.imageloaderlib.ImageLoader.Companion.with
import kotlinx.android.synthetic.main.toolbar_layout.view.*

class ImageDetailsActivity : AppCompatActivity() {
    private var imageUrl: String? = null
    private lateinit var binding: ActivityImageDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_image_details)
        val extras = intent.extras

        if (extras != null) {
            imageUrl = extras.getString(AppConstant.IMAGE_VIEW)

        }
        setDataOnUI()
    }

    fun setDataOnUI() {
        with(this).load(
            binding.imageView,
            imageUrl.toString()
        )
        binding.toolBar.clear_activity.setOnClickListener {
            finish()
        }
    }
}


