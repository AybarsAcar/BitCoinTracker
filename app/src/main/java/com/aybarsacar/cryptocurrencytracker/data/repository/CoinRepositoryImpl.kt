package com.aybarsacar.cryptocurrencytracker.data.repository

import com.aybarsacar.cryptocurrencytracker.data.remote.CoinPaprikaApi
import com.aybarsacar.cryptocurrencytracker.data.remote.dto.CoinDetailDto
import com.aybarsacar.cryptocurrencytracker.data.remote.dto.CoinDto
import com.aybarsacar.cryptocurrencytracker.domain.repository.CoinRepository
import javax.inject.Inject


class CoinRepositoryImpl @Inject constructor(private val _api: CoinPaprikaApi) : CoinRepository {

  override suspend fun getCoins(): List<CoinDto> {
    return _api.getCoins()
  }


  override suspend fun getCoinById(coinId: String): CoinDetailDto {
    return _api.getCoinById(coinId)
  }
}