package com.compose.cryptoapp.crypto.pressentation.coins

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.compose.cryptoapp.crypto.domain.model.Coins
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination(start = true)
fun CoinsScreen(
    navigator: DestinationsNavigator,
    viewModel: CoinsViewModel = hiltViewModel()

){
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(state.coins) { coin ->
               CoinsItem(
                   navigator,
                   coins = coin)

            }
        }
        
    }

}