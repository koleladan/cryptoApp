package com.compose.cryptoapp.crypto.data.remote.dto

import com.compose.cryptoapp.crypto.domain.model.Stats

data class StatsDto(
    val contributors: Int,
    val followers: Int,
    val stars: Int,
    val subscribers: Int
)
fun StatsDto.toStats(): Stats {
    return Stats(
        contributors = contributors,
        followers = followers,
        stars = stars,
        subscribers = subscribers
    )
}