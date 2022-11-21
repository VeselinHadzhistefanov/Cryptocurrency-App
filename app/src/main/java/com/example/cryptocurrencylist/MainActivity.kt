package com.example.cryptocurrencylist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cryptocurrencylist.databinding.ActivityMainBinding
import okhttp3.OkHttpClient
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    var data = "sdf"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView((binding.root))

        val globalSharedPrefs = getSharedPreferences("prefs", Context.MODE_PRIVATE)


        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.coingecko.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()

        val currencyService = retrofit.create(CryptoService::class.java)
        val currencyRepository = CryptoRepository(currencyService)

        currencyRepository.getCryptoCurrencies()?.enqueue(object: Callback<List<CryptoCurrency>> {
            override fun onResponse(call: Call<List<CryptoCurrency>>, response: Response<List<CryptoCurrency>>) {
                val currencies = response.body() ?: return

                data = response.body().toString()
                with (globalSharedPrefs.edit()) {
                    putString("data", data)
                    apply() }


                val sortedCurrencies = currencies.sortedBy { it.current_price }

                val adapter = ViewAdapter(sortedCurrencies)
                binding.cryptoCurrenciesList.adapter = adapter
                binding.cryptoCurrenciesCount.text = "Number of currencies shown: ${adapter.itemCount.toString()}"
            }

            override fun onFailure(call: Call<List<CryptoCurrency>>, t: Throwable) {

            }


        })


    }


}