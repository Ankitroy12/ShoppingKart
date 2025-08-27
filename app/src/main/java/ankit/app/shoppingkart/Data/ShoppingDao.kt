package ankit.app.shoppingkart.Data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ankit.app.shoppingkart.data.Shopping
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(shopping: Shopping)
    @Delete
    suspend fun delete(shopping: Shopping)
    @Query("SELECT * FROM shopping_table")
    fun getAll(): Flow<List<Shopping>>
}