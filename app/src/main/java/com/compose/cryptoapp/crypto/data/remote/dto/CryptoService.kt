package com.compose.cryptoapp.crypto.data.remote.dto

import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoService {
    @GET("coins")
    suspend fun getCoins(): List<CoinsDto>

    @GET("coins/{id}")
    suspend fun getCoinInfo(@Path("id") id: String): CoinInfoDto

    companion object {
        const val BASE_URL = "https://api.coinpaprika.com/v1/"
        const val COIN_ID = "coinId"
    }
}