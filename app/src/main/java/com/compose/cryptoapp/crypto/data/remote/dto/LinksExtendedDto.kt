package com.compose.cryptoapp.crypto.data.remote.dto

import com.compose.cryptoapp.crypto.domain.model.LinksExtended

data class LinksExtendedDto(
    val stats: StatsDto,
    val type: String,
    val url: String
)
fun LinksExtendedDto.toLinksExtended(): LinksExtended {
    return LinksExtended(
        stats = stats,
        type = type,
        url = url
    )
}