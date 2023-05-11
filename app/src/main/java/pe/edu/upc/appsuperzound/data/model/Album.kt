package pe.edu.upc.appsuperzound.data.model

import com.google.gson.annotations.SerializedName

data class Album(
    //@SerializedName("idAlbum")
    val idAlbum: String,

    //@SerializedName("strAlbum")
    val strAlbum: String,

    //@SerializedName("strArtist")
    val strArtist: String,

    //@SerializedName("strAlbumThumb")
    val strAlbumThumb: String,

    //@SerializedName("intYearReleased")
    val intYearReleased: String,

    val strGenre: String,

    val strAlbum3DCase: String,

    var favorite: Boolean
)