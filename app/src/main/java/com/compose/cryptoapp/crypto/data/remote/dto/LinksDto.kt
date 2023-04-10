package com.compose.cryptoapp.crypto.data.remote.dto

import com.compose.cryptoapp.crypto.domain.model.Links

data class LinksDto(
    val explorer: List<String>,
    val facebook: List<String>,
    val reddit: List<String>,
    val source_code: List<String>,
    val website: List<String>,
    val youtube: List<String>
)
fun LinksDto.toLinks(): Links {
    return Links(
        explorer = explorer,
        facebook = facebook,
        reddit = reddit,
        source_code = source_code,
        website = website,
        youtube = youtube
    )
}