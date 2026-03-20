package mungarro.carlos.gameshop.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import mungarro.carlos.gameshop.R
import mungarro.carlos.gameshop.data.models.Games
import kotlin.random.Random


class GamesViewModel: ViewModel(){

    private val games = listOf(
        Games("FIFA 24", 999.99f, R.drawable.fifa),
        Games("Call of Duty", 1299.50f, R.drawable.cod),
        Games("Minecraft", 499.99f, R.drawable.minecraft),
        Games("GTA V", 699.00f, R.drawable.gta),
        Games("Fortnite", 0.0f, R.drawable.fortnite),
        Games("Resident Evil 4", 899.99f, R.drawable.re4)
    )

    fun getGames(): List<Games> = games

    private val _selectedGame = MutableStateFlow<Games?>(null)
    val selectedGame: StateFlow<Games?> = _selectedGame.asStateFlow()

    private val _discount = MutableStateFlow(0)
    val discount: StateFlow<Int> = _discount.asStateFlow()

    fun selectGame(game: Games){
        _selectedGame.value = game
        _discount.value = Random.nextInt(0, 101)
    }
}