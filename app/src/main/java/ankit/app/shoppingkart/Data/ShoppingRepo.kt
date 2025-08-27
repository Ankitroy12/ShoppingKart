package ankit.app.shoppingkart.Data

import ankit.app.shoppingkart.data.Shopping

class ShoppingRepo(private val shoppingDao: ShoppingDao) {
    suspend fun add(shopping: Shopping){
        shoppingDao.add(shopping)
    }
    suspend fun delete(shopping: Shopping){
        shoppingDao.delete(shopping)
    }
    val getAll =  shoppingDao.getAll()
}