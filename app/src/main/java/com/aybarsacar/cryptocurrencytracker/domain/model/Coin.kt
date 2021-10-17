package com.aybarsacar.cryptocurrencytracker.domain.model

import com.aybarsacar.cryptocurrencytracker.data.remote.dto.CoinDto


/**
 * the Coin Object we use in our project ui
 * Mapped from CoinDto
 */
data class Coin(
  val id: String,
  val isActive: Boolean,
  val name: String,
  val rank: Int,
  val symbol: String,
)


