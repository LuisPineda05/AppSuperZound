package pe.edu.upc.appsuperzound.ui.screens

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.lifecycle.AndroidViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(viewModel: AlbumViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Home") {
        composable("ListAlbum") {
            ListAlbumScreen(viewModel)
        }

        composable("FavouriteAlbums") {
            FavouriteAlbumScreen(viewModel)
        }


        composable("Home") {
            Home(onFindAlbum = { navController.navigate("ListAlbum") },
                onFavouriteAlbum = { navController.navigate("FavouriteAlbums") })
        }
    }
}