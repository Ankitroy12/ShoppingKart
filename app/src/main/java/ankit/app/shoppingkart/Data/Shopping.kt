package ankit.app.shoppingkart.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_table")
data class Shopping(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val desc:String,
    val qty: Double,
    val unit:String
)
