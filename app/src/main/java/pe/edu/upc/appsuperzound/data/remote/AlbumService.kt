package pe.edu.upc.appsuperzound.data.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumService {
    @GET("json/523532/mostloved.php?format=album")
    fun fetchByName(): Call<AlbumResponse>
}