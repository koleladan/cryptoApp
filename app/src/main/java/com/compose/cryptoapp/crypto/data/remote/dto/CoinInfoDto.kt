package com.compose.cryptoapp.crypto.data.remote.dto

import com.compose.cryptoapp.crypto.domain.model.CoinInfo

data class CoinInfoDto(
    val description: String?,
    val development_status: String?,
    val first_data_at: String?,
    val hardware_wallet: Boolean?,
    val hash_algorithm: String?,
    val id: String?,
    val is_active: Boolean,
    val is_new: Boolean?,
    val last_data_at: String?,
    val links: LinksDto?,
    val links_extended: List<LinksExtendedDto>?,
    val logo: String?,
    val message: String?,
    val name: String?,
    val open_source: Boolean?,
    val org_structure: String?,
    val proof_type: String?,
    val rank: Int?,
    val started_at: String?,
    val symbol: String?,
    val tags: List<TagDto>?,
    val team: List<TeamMemberDto>,
    val type: String?,
    val whitepaper: WhitepaperDto?
)
fun CoinInfoDto.toCoinInfo(): CoinInfo {
    return CoinInfo(
        description = description,
        development_status = development_status,
        first_data_at = first_data_at,
        hardware_wallet = hardware_wallet,
        hash_algorithm = hash_algorithm,
        id = id,
        is_active = is_active,
        is_new = is_new,
        last_data_at = last_data_at,
        links = links,
        links_extended = links_extended?.map { it.toLinksExtended() },
        logo = logo,
        message = message,
        name = name,
        open_source = open_source,
        org_structure = org_structure,
        proof_type = proof_type,
        rank = rank,
        started_at = started_at,
        symbol = symbol,
        tags = tags?.map { it.toTag() },
        team = team.map { it.toTeam() },
        type = type,
        whitepaper = whitepaper
    )
}