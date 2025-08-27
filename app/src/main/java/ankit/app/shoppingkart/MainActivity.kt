package ankit.app.shoppingkart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import ankit.app.shoppingkart.Data.ShoppingRepo
import ankit.app.shoppingkart.Data.ShoppingDatabase
import ankit.app.shoppingkart.ui.theme.ShoppingKartTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val db = ShoppingDatabase.getDatabase(this)
        val repo = ShoppingRepo(db.shoppingDao())
        val viewModel = ShoppingViewModel(repo)


        setContent {
            ShoppingKartTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(viewModel)
                }
            }
        }
    }
}
