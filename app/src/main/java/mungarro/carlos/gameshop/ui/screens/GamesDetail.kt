package mungarro.carlos.gameshop.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import mungarro.carlos.gameshop.component.GameGridItem
import mungarro.carlos.gameshop.data.models.Games

@Composable
fun GameMenuScreen(
    gameList: List<Games>,
    onClick: (Games) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(140.dp),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(gameList) { game ->
            GameGridItem(
                game = game,
                onClick = { onClick(game) }
            )
        }
    }
}