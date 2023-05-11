package pe.edu.upc.appsuperzound.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AlbumDao {
    @Query("select * from Album where id=:id")
    fun fetchById(id: String): List<AlbumEntity>

    @Insert
    fun insert(productEntity: AlbumEntity)

    @Delete
    fun delete(productEntity: AlbumEntity)

}