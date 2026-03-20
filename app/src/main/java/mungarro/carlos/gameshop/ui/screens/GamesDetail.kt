package mungarro.carlos.gameshop.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import mungarro.carlos.gameshop.viewmodel.GamesViewModel

@Composable
fun GamesDetail(
    viewModel: GamesViewModel,
    onBackToList: () -> Unit
) {

    val game by viewModel.selectedGame.collectAsState()
    val discount by viewModel.discount.collectAsState()

    var comprado by remember { mutableStateOf(false) }

    game?.let {

        val finalPrice = it.price * (1 - discount / 100f)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Image(
                painter = painterResource(id = it.img),
                contentDescription = it.name,
                modifier = Modifier.size(200.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = it.name, fontSize = 22.sp)
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Precio: $${it.price}", fontSize = 18.sp)

            Spacer(modifier = Modifier.height(16.dp))


            if (discount > 0) {
                Text(
                    text = "$discount% de descuento aplicado",
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Precio final: $${"%.2f".format(finalPrice)}",
                    fontSize = 20.sp
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                comprado = true
                onBackToList()
            }) {
                Text("Comprar juego")
            }

            if (comprado) {
                Spacer(modifier = Modifier.height(16.dp))
                Text("Comprado", fontSize = 18.sp)
            }
        }
    }
}