package com.example.cryptocurrencylist

import retrofit2.Call
import retrofit2.http.GET

interface CryptoService {
    @GET("/api/v3/coins/markets?vs_currency=usd")
    fun getCryptoCurrencies(): Call<List<CryptoCurrency>>

}