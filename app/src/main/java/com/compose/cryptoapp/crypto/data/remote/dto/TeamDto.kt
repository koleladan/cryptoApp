package com.compose.cryptoapp.crypto.data.remote.dto


import com.compose.cryptoapp.crypto.domain.model.TeamMember

data class TeamMemberDto(
    val id: String,
    val name: String,
    val position: String
)
fun TeamMemberDto.toTeam(): TeamMember {
    return TeamMember(
        id = id,
        name = name,
        position = position
    )
}