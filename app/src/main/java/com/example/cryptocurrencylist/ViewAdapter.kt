package com.example.cryptocurrencylist

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cryptocurrencylist.databinding.CryptoListItemBinding

class ViewAdapter(val currencies: List<CryptoCurrency>) :
    RecyclerView.Adapter<ViewAdapter.CurrencyViewHolder>() {

    class CurrencyViewHolder(val binding: CryptoListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount() = currencies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CryptoListItemBinding.inflate(layoutInflater, parent, false)


        return CurrencyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {

        val currentCurrency = currencies[position]
        holder.binding.apply {
            name = currentCurrency.name.substring(0, 1).uppercase()+ currentCurrency.name.substring(1)
            symbol = currentCurrency.symbol.uppercase()
            iconUrl = currentCurrency.image
            currentPrice = "Price: ${currentCurrency.current_price} USD"
        }

        holder.itemView.setOnClickListener {
            val argsBundle = Bundle()


            val name = currentCurrency.name
            name.substring(0, 1).uppercase()+ name.substring(1)
            argsBundle.putString("name", name)

            val symbol = currentCurrency.symbol
            symbol.uppercase()
            argsBundle.putString("symbol", symbol)

            argsBundle.putString("icon_url", currentCurrency.image)
            argsBundle.putString("current_price", currentCurrency.current_price.toString())
            argsBundle.putString("market_cap", currentCurrency.market_cap.toString())
            argsBundle.putString("high_24h", currentCurrency.high_24h.toString())
            argsBundle.putString("price_change_24h", currentCurrency.price_change_24h.toString())
            argsBundle.putString("market_cap_change_percentage_24h", currentCurrency.market_cap_change_percentage_24h.toString())
            argsBundle.putString("low_24h", currentCurrency.low_24h.toString())

            val intent = Intent(it.context, CurrencyDetails::class.java)
            intent.putExtra("args", argsBundle)
            startActivity(it.context, intent, null)

        }

        Glide
            // context to use for requesting the image
            .with(holder.binding.root.context)
            .load(currentCurrency.image) // URL to load the asset from
            .centerCrop()
            // image to be shown until online asset is downloaded
            .placeholder(R.drawable.ic_launcher_foreground)
            // ImageView to load the online asset into when ready
            .into(holder.binding.currencyIcon)



    }


}