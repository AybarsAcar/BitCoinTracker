package com.aybarsacar.cryptocurrencytracker.view.coindetail

import com.aybarsacar.cryptocurrencytracker.domain.model.CoinDetail


data class CoinDetailState(
  val isLoading: Boolean = false,
  val coin: CoinDetail? = null,
  val error: String = ""
)