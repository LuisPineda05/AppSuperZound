package pe.edu.upc.appsuperzound.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun Home(onFindAlbum: () -> Unit, onFavouriteAlbum: () -> Unit) {
    Column( horizontalAlignment = Alignment.CenterHorizontally
        ,modifier = Modifier.fillMaxWidth().fillMaxHeight().absolutePadding(top = 120.dp)) {
        BrandingImage()
        Button(onClick =  onFindAlbum ,
            modifier = Modifier.fillMaxWidth().padding(30.dp)) {
            Text(text = "Album List")
        }
        Button(onClick =  onFavouriteAlbum ,
            modifier = Modifier.fillMaxWidth().padding(30.dp)) {
            Text(text = "Favourite Albums")
        }
    }
}

@Composable
private fun BrandingImage() {
    AsyncImage(model = "https://static.vecteezy.com/system/resources/previews/009/393/830/original/black-vinyl-disc-record-for-music-album-cover-design-free-png.png"
        , contentDescription = "Organization Logo", modifier = Modifier.size(250.dp))
}