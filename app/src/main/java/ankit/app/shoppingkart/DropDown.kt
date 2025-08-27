package ankit.app.shoppingkart

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp

@Composable
fun DropDownCall(viewModel: ShoppingViewModel){
    var drop by remember { mutableStateOf(false) }
    var unt by remember { mutableStateOf("piece") }
    Button(
        onClick = { drop = true},
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFFF7A5A5))
    ) {
        Text(
            text = unt,
            fontFamily = FontFamily(playWriter),
            color = Color(0xFF800000)
        )
        Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "dropdown")
    }
    DropdownMenu(
        onDismissRequest = {drop = false},
        expanded = drop,
        containerColor = Color(0xFFF5E3BB)
    ) {
        DropdownMenuItem(
            text = {Text(
                text = "piece",
                fontFamily = FontFamily(playWriter),
                color = Color(0xFF800000)
            )},
            onClick = {viewModel.unit = "piece"
                unt="piece"
                drop=false
            }
        )
        DropdownMenuItem(
            text = {Text(
                text = "kg",
                fontFamily = FontFamily(playWriter),
                color = Color(0xFF800000)
            )},
            onClick = {viewModel.unit = "kg"
                unt="kg"
                drop=false
            }
        )
        DropdownMenuItem(
            text = {Text(
                text = "g",
                fontFamily = FontFamily(playWriter),
                color = Color(0xFF800000)
            )},
            onClick = {viewModel.unit = "g"
                unt="g"
                drop=false
            }
        )
        DropdownMenuItem(
            text = {Text(
                text = "l",
                fontFamily = FontFamily(playWriter),
                color = Color(0xFF800000)
            )},
            onClick = {viewModel.unit = "l"
                unt="l"
                drop=false
            }
        )
        DropdownMenuItem(
            text = {Text(
                text = "ml",
                fontFamily = FontFamily(playWriter),
                color = Color(0xFF800000)
            )},
            onClick = {viewModel.unit = "ml"
                unt="ml"
                drop=false
            }
        )
        DropdownMenuItem(
            text = {Text(
                text = "pack",
                fontFamily = FontFamily(playWriter),
                color = Color(0xFF800000)
            )},
            onClick = {viewModel.unit = "pack"
                unt="pack"
                drop=false
            }
        )
    }
}