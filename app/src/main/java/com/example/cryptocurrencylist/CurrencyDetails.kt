package com.example.cryptocurrencylist

import android.app.Activity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.cryptocurrencylist.databinding.ActivityCurrencyDetailsBinding

class CurrencyDetails : Activity() {

    lateinit var binding: ActivityCurrencyDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCurrencyDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras?.getBundle("args")

        val name = bundle?.getString("name")
        val symbol = bundle?.getString("symbol")
        val icon_url = bundle?.getString("icon_url")
        val current_price = bundle?.getString("current_price")
        val market_cap = bundle?.getString("market_cap")
        val high_24h = bundle?.getString("high_24h")
        val price_change_24h = bundle?.getString("price_change_24h")
        val market_cap_change_percentage_24h = bundle?.getString("market_cap_change_percentage_24h")
        val low_24h = bundle?.getString("low_24h")


        binding.detailsTvName.text = name
        binding.detailsTvSymbol.text = symbol
        binding.detailsTvPrice.text = "Price: \n $current_price"
        binding.detailsMarketCap.text = "Market Cap:\n $market_cap"
        binding.detailsHigh24h.text = "High 24h:\n $high_24h"
        binding.detailsPriceChange24h.text = "Price Change 24h:\n $price_change_24h"
        binding.detailsMarketCapChangePercentage24h.text = "Market Cap Change % 24h:\n $market_cap_change_percentage_24h"
        binding.detailsLow24h.text = "Low 24h:\n $low_24h"


        Glide
            .with(binding.root.context)
            .load(icon_url)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(binding.detailsCurrencyIcon)


    }

}
