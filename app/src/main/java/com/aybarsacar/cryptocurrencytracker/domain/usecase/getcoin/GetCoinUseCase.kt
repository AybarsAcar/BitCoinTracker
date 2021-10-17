package com.aybarsacar.cryptocurrencytracker.domain.usecase.getcoin

import com.aybarsacar.cryptocurrencytracker.common.Resource
import com.aybarsacar.cryptocurrencytracker.data.remote.dto.toCoinDetail
import com.aybarsacar.cryptocurrencytracker.domain.model.CoinDetail
import com.aybarsacar.cryptocurrencytracker.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetCoinUseCase @Inject constructor(private val _repository: CoinRepository) {

  operator fun invoke(id: String): Flow<Resource<CoinDetail>> = flow {

    try {

      // emit the loading status
      emit(Resource.Loading<CoinDetail>())

      val coinDetail = _repository.getCoinById(id).toCoinDetail()

      emit(Resource.Success<CoinDetail>(coinDetail))

    } catch (e: HttpException) {
      // response code that does not start with 2
      emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred"))
    } catch (e: IOException) {
      // i.e. the user doesn't have internet permit connection, or server is offline
      emit(Resource.Error<CoinDetail>("Could not reach server. Check your internet connection"))
    }
  }
}