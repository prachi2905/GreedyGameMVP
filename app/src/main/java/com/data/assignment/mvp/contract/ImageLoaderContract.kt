package com.data.assignment.mvp.contract

import com.data.assignment.Model.Children

interface ImageLoaderContract {
    interface View {
        fun fetchImageList(response: List<Children>)
        fun apiFailure(failureMessage: String)
    }

    interface Presenter {
        fun fetchDataForShowingImage()
    }

}