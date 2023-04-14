package com.compose.cryptoapp.crypto.domain.usecases

import com.compose.cryptoapp.core.Resource
import com.compose.cryptoapp.crypto.data.remote.dto.toCoins
import com.compose.cryptoapp.crypto.domain.model.Coins
import com.compose.cryptoapp.crypto.domain.repositoryInterface.CoinsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinsRepository
) {
    operator fun invoke(): Flow<Resource<List<Coins>>> = flow {
        try {
            emit(Resource.Loading<List<Coins>>())
            val coins = repository.GetCoins().map { it.toCoins() }
            emit(Resource.Success<List<Coins>>(coins))

        }catch (e: HttpException) {
            emit(Resource.Error<List<Coins>>(e.localizedMessage ?: "An expected error Occurred"))

        }catch (e: IOException) {
            emit(Resource.Error<List<Coins>>("Couldn't reach the server. Check your internet connection"))

        }
    }

}