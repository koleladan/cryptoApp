package com.compose.cryptoapp.crypto.pressentation.coin_details

import com.compose.cryptoapp.crypto.domain.model.CoinInfo

data class CoinDetailsState(
    val coinInfo: CoinInfo? = null,
    val isLoading: Boolean = false,
    val error: String = ""
)
