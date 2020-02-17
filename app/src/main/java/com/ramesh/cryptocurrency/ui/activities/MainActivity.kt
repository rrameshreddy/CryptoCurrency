package com.ramesh.cryptocurrency.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.ProgressBar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ramesh.cryptocurrency.R
import com.ramesh.cryptocurrency.databinding.ActivityMainBinding
import com.ramesh.cryptocurrency.model.CryptoCurrencyData
import com.ramesh.cryptocurrency.ui.adapters.CryptoCurrencyAdapter
import com.ramesh.cryptocurrency.viewmodel.CryptoCurrencyViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    //private lateinit var mProgressBar: ProgressBar
    private var mCryptoCurrencyList:ArrayList<CryptoCurrencyData> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.viewmodel = CryptoCurrencyViewModel()

        val viewModel = ViewModelProviders.of(this).get(CryptoCurrencyViewModel::class.java)
        viewModel.launchActivity.observe(this, Observer {


        })

        //mProgressBar = findViewById(R.id.progress_bar)
        recyclerView = findViewById(R.id.recyclerView) as RecyclerView // Add this

        var cryptoCurrencyData= CryptoCurrencyData("Bitcoin","$10","45","54")
        mCryptoCurrencyList.add(cryptoCurrencyData)
        setAdapter()

    }

    private fun setAdapter() {
        recyclerView?.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
            adapter = CryptoCurrencyAdapter(this@MainActivity, mCryptoCurrencyList)
        }
    }
}

