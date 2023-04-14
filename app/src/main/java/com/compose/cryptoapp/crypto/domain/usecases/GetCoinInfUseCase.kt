package com.compose.cryptoapp.crypto.domain.usecases

import com.compose.cryptoapp.core.Resource
import com.compose.cryptoapp.crypto.data.remote.dto.toCoinInfo
import com.compose.cryptoapp.crypto.domain.model.CoinInfo
import com.compose.cryptoapp.crypto.domain.repositoryInterface.CoinsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinInfUseCase @Inject constructor(
    private val repository: CoinsRepository
) {
    operator fun invoke(id:String): Flow<Resource<CoinInfo>> = flow {
        try {
            emit(Resource.Loading<CoinInfo>())
            val coinInfo = repository.GetCoinInfo(id).toCoinInfo()
            emit(Resource.Success<CoinInfo>(coinInfo))

        } catch (e: HttpException) {
            emit(Resource.Error<CoinInfo>(e.localizedMessage ?: "Oops! An error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinInfo>("Couldn't reach the server. Check your connection"))
        }
    }
}