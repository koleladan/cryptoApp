package com.compose.cryptoapp.crypto.domain.model

import com.compose.cryptoapp.crypto.data.remote.dto.*

data class CoinInfo(
    val description: String,
    val development_status: String,
    val first_data_at: String,
    val hardware_wallet: Boolean,
    val hash_algorithm: String,
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val last_data_at: String,
    val links: LinksDto,
    val links_extended: List<LinksExtendedDto>,
    val logo: String,
    val message: String,
    val name: String,
    val open_source: Boolean,
    val org_structure: String,
    val proof_type: String,
    val rank: Int,
    val started_at: String,
    val symbol: String,
    val tags: List<TagDto>,
    val team: List<TeamDto>,
    val type: String,
    val whitepaper: WhitepaperDto
)
