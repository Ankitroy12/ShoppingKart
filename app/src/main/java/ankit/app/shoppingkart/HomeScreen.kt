package ankit.app.shoppingkart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(viewModel: ShoppingViewModel = viewModel()){
    var flag by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize().background(color = Color(0xFFFFFFE3))
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize().statusBarsPadding(),
            containerColor = Color((0xFFFFFFE3)),
            floatingActionButton = {
                FloatingActionButton(
                    modifier = Modifier.padding(20.dp),
                    onClick = {flag = true},
                    containerColor = Color(0xFFF7A5A5),
                    shape = RoundedCornerShape(50.dp)
                ){
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                }
            },
            floatingActionButtonPosition = FabPosition.Center
        ) { paddingValues ->
            if (flag == true) {
                Add(onDismiss = { flag = false }, viewModel)
            }
            Column(modifier = Modifier.padding(paddingValues)) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(10.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "ShoppingList",
                        fontSize = 50.sp,
                        fontFamily = FontFamily(top),
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = Color(0xFF800000)
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                LazyFile(viewModel)
            }
        }
    }
}

