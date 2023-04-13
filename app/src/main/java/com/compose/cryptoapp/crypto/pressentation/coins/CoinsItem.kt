package com.compose.cryptoapp.crypto.pressentation.coins

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.compose.cryptoapp.crypto.domain.model.Coins
import com.compose.cryptoapp.crypto.pressentation.destinations.CoinDetailScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Composable
@Destination
fun CoinsItem(
    navigator: DestinationsNavigator,
    coins: Coins,
    modifier: Modifier = Modifier

) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .clickable {
            navigator.navigate(CoinDetailScreenDestination(coins.id)
            )
        }
        .padding(start = 20.dp, top = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "${coins.rank}. ${coins.name}  (${coins.symbol})",
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Ellipsis
            )
        Text(
            text = if (coins.is_active) "active" else "inactive",
            color = if(coins.is_active) Color.Green else Color.Red,
            fontStyle = FontStyle.Italic,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.align(CenterVertically)

        )
            
        }
        
    }

