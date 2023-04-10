package com.compose.cryptoapp.crypto.domain.model

import com.compose.cryptoapp.crypto.data.remote.dto.StatsDto

data class LinksExtended(
    val stats: StatsDto,
    val type: String,
    val url: String
)
