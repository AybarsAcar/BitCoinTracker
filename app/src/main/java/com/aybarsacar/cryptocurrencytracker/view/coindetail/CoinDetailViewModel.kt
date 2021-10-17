package com.aybarsacar.cryptocurrencytracker.view.coindetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aybarsacar.cryptocurrencytracker.common.Constants
import com.aybarsacar.cryptocurrencytracker.common.Resource
import com.aybarsacar.cryptocurrencytracker.domain.usecase.getcoin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CoinDetailViewModel @Inject constructor(
  private val _getCoinUseCase: GetCoinUseCase,
  _savedStateHandle: SavedStateHandle
) : ViewModel() {

  private val _state = mutableStateOf(CoinDetailState())
  val state: State<CoinDetailState> = _state

  init {
    _savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let {

      getCoin(it)

    }
  }

  private fun getCoin(coinId: String) {
    _getCoinUseCase(coinId).onEach { result ->

      when (result) {
        is Resource.Success -> {
          _state.value = CoinDetailState(coin = result.data)
        }

        is Resource.Error -> {
          _state.value = CoinDetailState(error = result.message ?: "An unexpected error ocurred")

        }

        is Resource.Loading -> {
          _state.value = CoinDetailState(isLoading = true)
        }
      }

    }.launchIn(viewModelScope)
  }

}