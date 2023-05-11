package pe.edu.upc.appsuperzound.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import pe.edu.upc.appsuperzound.data.model.Album

@Composable
fun ListAlbumScreen(viewModel: AlbumViewModel) {
    viewModel.fetchByName()
    Column{
        //AlbumSearch(viewModel = viewModel)
        ListAlbum(viewModel = viewModel)
    }
}



@Composable
fun ListAlbum(viewModel: AlbumViewModel){
    val albums by viewModel.albums.observeAsState(listOf())

    LazyColumn {
        items(albums) { album ->
            AlbumCard(
                album,
                insertAlbum = {
                    viewModel.insert(album)
                },
                deleteAlbum = {
                    viewModel.delete(album)
                }
            )
        }
    }
}

@Composable
fun AlbumCard(
    album: Album,
    insertAlbum: () -> Unit,
    deleteAlbum: () -> Unit
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ){
        Row (modifier = Modifier.background(Color.Yellow)) {
            ProductImage(album)
            AlbumItem(album, insertAlbum, deleteAlbum)
        }
    }
}

@Composable
fun AlbumItem(
    album: Album,
    insertProduct: () -> Unit,
    deleteProduct: () -> Unit
){
    val isFavorite = remember {
        mutableStateOf(false)
    }
    isFavorite.value=album.favorite

    Spacer(modifier = Modifier.width(8.dp))
    Row {
        Column(modifier = Modifier.weight(7f)) {
            Text(text = album.strAlbum, fontWeight = FontWeight.Bold)
            Text(text = "Artist: " + album.strArtist, fontWeight = FontWeight.Bold)
            Text(text = "Year: " + album.intYearReleased, fontWeight = FontWeight.Bold)


        }
        IconButton(
            modifier = Modifier.weight(1f),
            onClick = {
                if (isFavorite.value){
                    deleteProduct()
                }else{
                    insertProduct()
                }
                isFavorite.value=!isFavorite.value

            }) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = null,
                tint = if(isFavorite.value) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
fun ProductImage(album: Album){
    AsyncImage(
        model = album.strAlbumThumb,
        contentDescription = null,
        modifier = Modifier
            .size(92.dp)
            .clip(shape = RoundedCornerShape(8.dp)),
        contentScale = ContentScale.Crop
    )
}

