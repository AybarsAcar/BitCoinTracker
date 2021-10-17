package com.aybarsacar.cryptocurrencytracker.view.coinlist

import com.aybarsacar.cryptocurrencytracker.domain.model.Coin


data class CoinListState(
  val isLoading: Boolean = false,
  val coins: List<Coin> = emptyList(),
  val error: String = ""
)