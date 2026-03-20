package mungarro.carlos.gameshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import mungarro.carlos.gameshop.dummies.getAllGames
import mungarro.carlos.gameshop.screen.GameMenuScreen
import mungarro.carlos.gameshop.ui.theme.GameShopTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GameShopTheme {

                GameMenuScreen(
                    gameList = getAllGames(),
                    onClick = { game ->

                        println("Click en: ${game.name}")
                    }
                )

            }
        }
    }
}
