package com.example.cryptocurrencylist

import retrofit2.Call


class CryptoRepository constructor(
    private val cryptoService: CryptoService
) {
    fun getCryptoCurrencies(): Call<List<CryptoCurrency>>? {
        return try {
            cryptoService.getCryptoCurrencies()
        } catch (e: Exception) {
            // an error occurred
            null
        }
    }
}
