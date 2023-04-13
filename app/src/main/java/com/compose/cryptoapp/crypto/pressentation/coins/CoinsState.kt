package com.compose.cryptoapp.crypto.pressentation.coins

import com.compose.cryptoapp.crypto.domain.model.Coins

data class CoinsState(
    val coins: List<Coins> = emptyList(),
    val error: String = "",
    val isLoading: Boolean = false
)
