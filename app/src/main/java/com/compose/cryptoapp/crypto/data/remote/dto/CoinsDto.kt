package com.compose.cryptoapp.crypto.data.remote.dto

import com.compose.cryptoapp.crypto.domain.model.Coins

data class CoinsDto(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)
fun CoinsDto.toCoins(): Coins {
    return Coins(
        id = id,
        is_active = is_active,
        name = name,
        rank = rank,
        symbol = symbol
    )
}