package com.ramesh.cryptocurrency.viewmodel

import android.app.Application
import android.content.Intent
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ramesh.cryptocurrency.ui.activities.CryptoCurrencyDetailsActivity

class CryptoCurrencyViewModel() : ViewModel() {

    val launchActivity = MutableLiveData<String>()

    fun onItemClick(view: View) {
        launchActivity.postValue("");
    }
}