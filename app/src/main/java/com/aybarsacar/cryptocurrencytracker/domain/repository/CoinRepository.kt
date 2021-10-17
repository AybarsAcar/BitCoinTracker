package com.aybarsacar.cryptocurrencytracker.domain.repository

import com.aybarsacar.cryptocurrencytracker.data.remote.dto.CoinDetailDto
import com.aybarsacar.cryptocurrencytracker.data.remote.dto.CoinDto


interface CoinRepository {

  suspend fun getCoins(): List<CoinDto>

  suspend fun getCoinById(id: String): CoinDetailDto

}