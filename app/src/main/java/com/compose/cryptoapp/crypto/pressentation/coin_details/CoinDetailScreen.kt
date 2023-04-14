package com.compose.cryptoapp.crypto.pressentation.coin_details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.compose.cryptoapp.crypto.domain.model.CoinInfo
import com.google.gson.Gson
import com.ramcosta.composedestinations.annotation.Destination


@OptIn(ExperimentalLayoutApi::class)
@Composable
@Destination
fun CoinDetailScreen(id: String) {
    val viewModel: CoinDetailsViewModel = hiltViewModel()
    val info = Gson().fromJson(id, CoinInfo::class.java)
    viewModel.updateCoinInfo(coinInfo = info)
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
       // val coinInfo = state.coinInfo
     //   if (coinInfo != null) {

      //  }
            state.coinInfo?.let { coinInfo ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                            Text(
                                text = "${coinInfo.rank}. (${coinInfo.symbol})",
                                style = MaterialTheme.typography.h2,
                                modifier = Modifier.weight(8f)
                            )
                            Text(
                                text = if (coinInfo.is_active) "active" else "inactive",
                                color = if (coinInfo.is_active) Color.Green else Color.Red,
                                fontStyle = FontStyle.Italic,
                                textAlign = TextAlign.End,
                                modifier = Modifier
                                    .align(CenterVertically)
                                    .weight(2f)
                            )

                    }
                    Spacer(modifier = Modifier.height(15.dp))
                        coinInfo.description?.let { it1 ->
                            Text(
                                text = it1,
                                style = MaterialTheme.typography.body2

                            )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Tags",
                        style = MaterialTheme.typography.h3
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    //flowRow wraps the components incase they exceeds the bounds
                    FlowRow(
                        modifier = Modifier.fillMaxWidth()

                    ) {
                            coinInfo.tags?.forEach { tag ->
                                CoinTag(tag = tag.toString())
                            }

                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Team members",
                        style = MaterialTheme.typography.h3
                    )
                    Spacer(modifier = Modifier.height(15.dp))


                }
                    items(coinInfo.team) { teamMember ->
                        TeamListItem(
                            teamMember = teamMember,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                        )
                        Divider()

                }

            }


    }
        if (state.error.isNotBlank() == true) {
            state.error.let {
                Text(
                    text = it,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                )

            }
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

    }

}