package com.aybarsacar.cryptocurrencytracker.domain.usecase.getcoins

import com.aybarsacar.cryptocurrencytracker.common.Resource
import com.aybarsacar.cryptocurrencytracker.data.remote.dto.toCoin
import com.aybarsacar.cryptocurrencytracker.domain.model.Coin
import com.aybarsacar.cryptocurrencytracker.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetCoinsUseCase @Inject constructor(private val _repository: CoinRepository) {

  operator fun invoke(): Flow<Resource<List<Coin>>> = flow {

    try {

      // emit the loading status
      emit(Resource.Loading<List<Coin>>())

      val coins = _repository.getCoins().map {
        it.toCoin()
      }

      emit(Resource.Success<List<Coin>>(coins))

    } catch (e: HttpException) {
      // response code that does not start with 2
      emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occurred"))
    } catch (e: IOException) {
      // i.e. the user doesn't have internet permit connection, or server is offline
      emit(Resource.Error<List<Coin>>("Could not reach server. Check your internet connection"))
    }
  }
}