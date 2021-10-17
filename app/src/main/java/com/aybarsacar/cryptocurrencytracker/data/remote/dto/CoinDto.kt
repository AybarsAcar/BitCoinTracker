package com.aybarsacar.cryptocurrencytracker.data.remote.dto

import com.aybarsacar.cryptocurrencytracker.domain.model.Coin
import com.google.gson.annotations.SerializedName


/**
 * Coin DTO received from the API
 */
data class CoinDto(

  val id: String,

  @SerializedName("is_active")
  val isActive: Boolean,

  @SerializedName("is_new")
  val isNew: Boolean,

  val name: String,

  val rank: Int,

  val symbol: String,

  val type: String
)


/**
 * extension function on the CoinDto for mapping the CoinDto to Coin
 */
fun CoinDto.toCoin(): Coin {
  return Coin(id, isActive, name, rank, symbol)
}