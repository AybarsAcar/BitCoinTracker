package com.aybarsacar.cryptocurrencytracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aybarsacar.cryptocurrencytracker.view.Screen
import com.aybarsacar.cryptocurrencytracker.view.coindetail.CoinDetailScreen
import com.aybarsacar.cryptocurrencytracker.view.coinlist.CoinListScreen
import com.aybarsacar.cryptocurrencytracker.view.ui.theme.CryptoCurrencyTrackerTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      CryptoCurrencyTrackerTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {

          val navController = rememberNavController()

          NavHost(navController = navController, startDestination = Screen.CoinListScreen.route) {

            composable(
              route = Screen.CoinListScreen.route
            ) {
              CoinListScreen(navController = navController)
            }

            composable(
              route = Screen.CoinDetailScreen.route + "/{coinId}"
            ) {
              CoinDetailScreen()
            }
          }
        }
      }
    }
  }
}