package com.compose.cryptoapp.crypto.domain.repositoryInterface

import com.compose.cryptoapp.crypto.data.remote.dto.CoinInfoDto
import com.compose.cryptoapp.crypto.data.remote.dto.CoinsDto

interface CoinsRepository {
    suspend fun GetCoins(): List<CoinsDto>

    suspend fun GetCoinInfo(id:String): CoinInfoDto
}