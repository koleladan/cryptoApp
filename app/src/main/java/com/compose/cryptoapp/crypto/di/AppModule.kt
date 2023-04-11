package com.compose.cryptoapp.crypto.di

import com.compose.cryptoapp.crypto.data.remote.dto.CryptoService
import com.compose.cryptoapp.crypto.data.repositoryImp.CoinsRepositoryImp
import com.compose.cryptoapp.crypto.domain.repositoryInterface.CoinsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoinsRepository(cryptoService: CryptoService): CoinsRepository{
        return CoinsRepositoryImp(cryptoService)
    }

    @Provides
    @Singleton
    fun provideCryptoService(): CryptoService {
        return Retrofit.Builder()
            .baseUrl(CryptoService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoService::class.java)
    }
}