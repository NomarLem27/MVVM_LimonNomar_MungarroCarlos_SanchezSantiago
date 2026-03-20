package mungarro.carlos.gameshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.*
import mungarro.carlos.gameshop.ui.screens.GamesList

import mungarro.carlos.gameshop.ui.screens.GamesDetail
import mungarro.carlos.gameshop.viewmodel.GamesViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: GamesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            var showDetail by remember { mutableStateOf(false) }

            if (!showDetail) {

                GamesList(
                    games = viewModel.getGames(),
                    onGameSelected = { game ->
                        viewModel.selectGame(game)
                        showDetail = true
                    }
                )

            } else {

                GamesDetail(
                    viewModel = viewModel,
                    onBackToList = {
                        showDetail = false
                    }
                )
            }
        }
    }
}
