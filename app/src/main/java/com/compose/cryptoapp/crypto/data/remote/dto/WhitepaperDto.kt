package com.compose.cryptoapp.crypto.data.remote.dto

import com.compose.cryptoapp.crypto.domain.model.Whitepaper

data class WhitepaperDto(
    val link: String,
    val thumbnail: String
)
fun WhitepaperDto.toWhitepaper(): Whitepaper {
    return Whitepaper(
        link = link,
        thumbnail = thumbnail
    )
}