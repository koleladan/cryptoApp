package com.compose.cryptoapp.crypto.pressentation.coin_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.cryptoapp.core.Resource
import com.compose.cryptoapp.crypto.data.remote.dto.CryptoService
import com.compose.cryptoapp.crypto.domain.usecases.GetCoinInfUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
   private val getCoinInfUseCase: GetCoinInfUseCase,
   savedStateHandle: SavedStateHandle
): ViewModel() {
    private val _state = mutableStateOf(CoinDetailsState())
    val state: State<CoinDetailsState> get() =  _state


    init {
        savedStateHandle.get<String>(CryptoService.COIN_ID)?.let { coinId ->
            getCoinDetails(coinId)
        }
    }



    fun getCoinDetails(id:String){
        viewModelScope.launch {
            getCoinInfUseCase(id)
                .collect{result ->
                    when(result) {
                        is Resource.Success -> {
                            _state.value = CoinDetailsState(coinInfo = result.data)
                        }
                        is Resource.Loading -> {
                            _state.value = CoinDetailsState(isLoading = true)

                        }
                        is Resource.Error -> {
                            _state.value = CoinDetailsState(error = result.message ?: "An unexpected error occurred" )
                        }
                    }
                }
        }
    }
}