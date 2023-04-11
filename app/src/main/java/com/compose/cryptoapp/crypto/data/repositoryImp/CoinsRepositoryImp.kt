package com.compose.cryptoapp.crypto.data.repositoryImp

import com.compose.cryptoapp.crypto.data.remote.dto.CoinInfoDto
import com.compose.cryptoapp.crypto.data.remote.dto.CoinsDto
import com.compose.cryptoapp.crypto.data.remote.dto.CryptoService
import com.compose.cryptoapp.crypto.domain.repositoryInterface.CoinsRepository
import javax.inject.Inject

class CoinsRepositoryImp @Inject constructor(
   private val cryptoService: CryptoService
): CoinsRepository {
    override suspend fun GetCoins(): List<CoinsDto> {
        return cryptoService.getCoins()
    }
    override suspend fun GetCoinInfo(id: String): CoinInfoDto {
        return cryptoService.getCoinInfo(id)

    }
}