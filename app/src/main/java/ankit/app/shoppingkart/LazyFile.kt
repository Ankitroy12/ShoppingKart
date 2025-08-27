package ankit.app.shoppingkart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LazyFile(viewModel: ShoppingViewModel){

    val items = viewModel.allItems.collectAsState()
    LazyColumn(
        modifier = Modifier.padding(bottom = 100.dp)
    ) {
        items(items.value){shopping->
            Card(
                modifier = Modifier
                    .fillMaxWidth().padding(top = 7.dp, bottom = 7.dp, start = 15.dp, end = 15.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF7A5A5)
                ),
                elevation = CardDefaults.cardElevation(4.dp)

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth().padding(top = 15.dp, bottom = 15.dp, start = 20.dp, end = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = "Description: ${shopping.desc}",
                            fontFamily = FontFamily(playWriter),
                            color = Color(0xFF800000),
                            fontSize = 15.sp,
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = "Quantity: ${shopping.qty} ${shopping.unit}",
                            fontFamily = FontFamily(playWriter),
                            color = Color(0xFF800000),
                            fontSize = 15.sp,
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold))
                    }
                    IconButton(onClick = { viewModel.delete(shopping) }) {
                        Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete", tint = Color(0xFF800000))
                    }

                }
            }
        }
    }
}
