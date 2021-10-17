package com.aybarsacar.cryptocurrencytracker.data.remote

import com.aybarsacar.cryptocurrencytracker.data.remote.dto.CoinDetailDto
import com.aybarsacar.cryptocurrencytracker.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * routes we are accessing in our API
 */
interface CoinPaprikaApi {

  @GET("v1/coins")
  suspend fun getCoins(): List<CoinDto>

  @GET("v1/coins/{coinId}")
  suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}