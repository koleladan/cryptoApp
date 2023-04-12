package com.compose.cryptoapp.crypto.pressentation.coins

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.cryptoapp.core.Resource
import com.compose.cryptoapp.crypto.domain.usecases.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinsViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
): ViewModel() {
    private val _state = mutableStateOf(CoinsState())
    val state: State<CoinsState> = _state


    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { results ->
            when(results){
                is Resource.Success -> {
                    _state.value = CoinsState(coins = results.data ?: emptyList())

                }
                is Resource.Error -> {
                    _state.value =CoinsState(
                        error = results.message ?: "An unexpected error occurred"
                    )

                }
                is Resource.Loading -> {
                    _state.value = CoinsState(isLoading = true)

                }
            }
        }
            .launchIn(viewModelScope)
    }
}