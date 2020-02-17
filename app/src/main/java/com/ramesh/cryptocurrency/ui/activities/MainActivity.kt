package com.ramesh.cryptocurrency.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.ProgressBar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ramesh.cryptocurrency.R
import com.ramesh.cryptocurrency.model.CryptoCurrencyData
import com.ramesh.cryptocurrency.ui.adapters.CryptoCurrencyAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var mProgressBar: ProgressBar
    private lateinit var mCryptoCurrencyList:ArrayList<CryptoCurrencyData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mProgressBar = findViewById(R.id.progress_bar)
        recyclerView = findViewById(R.id.recyclerView) as RecyclerView // Add this

        mCryptoCurrencyList


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

