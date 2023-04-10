package com.compose.cryptoapp.crypto.data.remote.dto

import com.compose.cryptoapp.crypto.domain.model.Tag

data class TagDto(
    val coin_counter: Int,
    val ico_counter: Int,
    val id: String,
    val name: String
)
fun TagDto.toTag(): Tag {
    return Tag(
        coin_counter = coin_counter,
        ico_counter = ico_counter,
        id = id,
        name = name
    )
}