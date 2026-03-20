package mungarro.carlos.gameshop.dummies

import mungarro.carlos.gameshop.R
import mungarro.carlos.gameshop.data.models.Games

fun getAllGames(): List<Games> {
    return listOf(
        Games("FIFA 24", 999.99f, R.drawable.fifa),
        Games("Call of Duty", 1299.50f, R.drawable.cod),
        Games("Minecraft", 499.99f, R.drawable.minecraft),
        Games("GTA V", 699.00f, R.drawable.gta),
        Games("Fortnite", 0.0f, R.drawable.fortnite),
        Games("Resident Evil 4", 899.99f, R.drawable.re4)
    )
}