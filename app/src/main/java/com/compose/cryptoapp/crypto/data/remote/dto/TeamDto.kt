package com.compose.cryptoapp.crypto.data.remote.dto

import com.compose.cryptoapp.crypto.domain.model.Team

data class TeamDto(
    val id: String,
    val name: String,
    val position: String
)
fun TeamDto.toTeam(): Team {
    return Team(
        id = id,
        name = name,
        position = position
    )
}