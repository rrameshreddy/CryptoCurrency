package com.ramesh.cryptocurrency.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ramesh.cryptocurrency.BR
import com.ramesh.cryptocurrency.R
import com.ramesh.cryptocurrency.databinding.AdapterCryptoCurrencyBinding
import com.ramesh.cryptocurrency.model.CryptoCurrencyData
import com.ramesh.cryptocurrency.viewmodel.CryptoCurrencyViewModel


class CryptoCurrencyAdapter(var context: Context, var list: ArrayList<CryptoCurrencyData>) :
    RecyclerView.Adapter<CryptoCurrencyAdapter.ViewHolder>() {

    // Inflating Layout and ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: AdapterCryptoCurrencyBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.adapter_crypto_currency,
            parent,
            false
        )

        val presenter = CryptoCurrencyViewModel(context.applicationContext)
        binding.setVariable(BR.handlers, presenter)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    // Bind data
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list.get(position))
    }

    // Creating ViewHolder
    class ViewHolder(val binding: AdapterCryptoCurrencyBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Any) {
            binding.setVariable(
                BR.cryptoCurrencyData,
                data
            ) //BR - generated class; BR.user - 'cryptoCurrencyData' is variable name declared in layout
            binding.executePendingBindings()
        }
    }

}