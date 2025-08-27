package ankit.app.shoppingkart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ankit.app.shoppingkart.Data.ShoppingRepo
import ankit.app.shoppingkart.data.Shopping
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repo: ShoppingRepo): ViewModel() {
    var desc by mutableStateOf("")
    var qty by mutableStateOf("")
    var unit by mutableStateOf("Piece")
    val allItems = repo.getAll.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun add() {
        val qtyDouble = qty.toDoubleOrNull() ?: 0.0
        if (desc.isNotBlank() && qtyDouble > 0) {
            viewModelScope.launch {
                repo.add(Shopping(desc = desc, qty = qtyDouble, unit = unit))
                desc = ""
                qty = ""
                unit = "Piece"
            }
        }
    }

    fun delete(item: Shopping) {
        viewModelScope.launch {
            repo.delete(item)
        }
    }
}