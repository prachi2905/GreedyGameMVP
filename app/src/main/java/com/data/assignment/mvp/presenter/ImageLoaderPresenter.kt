package com.data.assignment.mvp.presenter

import android.util.Log
import com.data.assignment.Model.Children
import com.data.assignment.Model.ImageUpload
import com.data.assignment.mvp.contract.ImageLoaderContract
import com.retrofit1.Clients.APIClient
import com.retrofit1.Interfaces.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImageLoaderPresenter(private  val view: ImageLoaderContract.View) : ImageLoaderContract.Presenter {
    var imageUploadList: List<Children> = ArrayList()


    override fun fetchDataForShowingImage() {
        val apiService = APIClient.client.create(ApiInterface::class.java)
        val call = apiService.getProjectList()

        call.enqueue(object : Callback<ImageUpload> {
            override fun onResponse(call: Call<ImageUpload>, response: Response<ImageUpload>) {
                Log.e("Response", response.message())
                val jsonResponse = response.body()?.data?.children
                if (jsonResponse != null) {

                    imageUploadList = jsonResponse as ArrayList<Children>
                    view.fetchImageList(imageUploadList)
                }
            }

            override fun onFailure(call: Call<ImageUpload>?, t: Throwable?) {
                Log.d("ERROR : ", " ")
            }
        })
    }

}