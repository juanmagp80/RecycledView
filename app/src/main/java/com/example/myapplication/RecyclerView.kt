package com.example.myapplication

import Model.SuperHero
import android.widget.HorizontalScrollView
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable

fun SympleReciclerView() {
    val mylist = listOf("Aris", "Pepe", "Manolo")
    LazyColumn {
        items(mylist) {
            Text(text = "hola, me llamo $it")
        }
    }
}

@OptIn
@Composable
fun SuperHeroGridView() {
    val context = LocalContext.current
    LazyVerticalGrid(GridCells.Fixed(2), content = {
        items(getsuperhero()) { superhero ->
            Itemhero(superHero = superhero)
            { Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show() }
        }
    }, contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp))
}


@Composable
fun Itemhero(superHero: SuperHero, onItemselected: (SuperHero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .width(200.dp)
            .clickable { onItemselected(superHero) }. padding(top= 8.dp, bottom = 8.dp, end = 16.dp, start= 16.dp)) {
        Column() {
            Image(
                painterResource(id = superHero.photo),
                contentDescription = "avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                superHero.superheroName, modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                superHero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superHero.publisher, modifier = Modifier
                    .align(Alignment.End)
                    .padding(8.dp)
            )

        }

    }
}

fun getsuperhero(): List<SuperHero> {
    return listOf(
        SuperHero("spiderman", "peter parker", "marvel", R.drawable.spiderman),
        SuperHero("batman", "bruce wayne", "DC", R.drawable.batman),
        SuperHero("daredevil", "nombre daredevil", "DC", R.drawable.daredevil),
        SuperHero("flash", "nombre de flash", "DC", R.drawable.flash),
        SuperHero("linterna verde", "nombre linterna verde", "DC", R.drawable.green_lantern),
        SuperHero("logan", "nombre de logan", "Marvel", R.drawable.logan),
        SuperHero("Thor", "dios del trueno", "Marvel", R.drawable.thor),
        SuperHero("wonder woman", "nombre de wonder woman", "Marvel", R.drawable.wonder_woman)


    )

}