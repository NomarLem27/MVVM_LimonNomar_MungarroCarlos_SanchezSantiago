package mungarro.carlos.gameshop.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import mungarro.carlos.gameshop.data.models.Games
import mungarro.carlos.gameshop.viewmodel.GamesViewModel
import mungarro.carlos.gameshop.R

//aqui esta la lista de los juegos
@Composable
fun GamesList(
    games: List<Games>,
    onGameSelected: (Games) -> Unit
) {

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(games) { game ->
            GameItem(
                game = game,
                onClick = { onGameSelected(game) }
            )
        }
    }
}

//cada itemm
@Composable
fun GameItem(
    game: Games,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {

        Row(
            modifier = Modifier.padding(16.dp)
        ) {

            Image(
                painter = painterResource(id = game.img),
                contentDescription = game.name,
                modifier = Modifier.size(80.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = game.name,
                    fontSize = 18.sp
                )
                Text(
                    text = "$${game.price}",
                    fontSize = 14.sp
                )
            }
        }
    }
}

