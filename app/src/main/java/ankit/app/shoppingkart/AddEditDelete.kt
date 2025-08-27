package ankit.app.shoppingkart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun Add(onDismiss:()->Unit,viewModel: ShoppingViewModel){

    Dialog(onDismissRequest = onDismiss) {
        Box(
            modifier = Modifier
                .padding(all = 10.dp)
                .fillMaxWidth()
                .background(
                    Color(0xFFF5E3BB),
                    shape = RoundedCornerShape(20.dp)
                )
        ){
            Column(
                modifier = Modifier.padding(all = 12.dp)
            ) {
                OutlinedTextField(value = viewModel.desc,
                    onValueChange = {viewModel.desc = it},
                    label = {
                        Text(text = "Description",
                            fontFamily = FontFamily(playWriter),
                            color = Color(0xFF800000)
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = Color(0xFF800000),
                    )
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(value = viewModel.qty,
                    onValueChange = {viewModel.qty = it},
                    label = {
                        Text(text = "Quantity",
                            fontFamily = FontFamily(playWriter),
                            color = Color(0xFF800000)
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = Color(0xFF800000),
                    )
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row {
                    Text(
                        text = "Unit:",
                        fontSize = 15.sp,
                        modifier = Modifier.padding(all = 10.dp),
                        fontFamily = FontFamily(playWriter),
                        color = Color(0xFF800000)
                    )
                    DropDownCall(viewModel)
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = { onDismiss() },
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFFF7A5A5))
                    ) {
                        Text(text = "Cancel",
                            fontFamily = FontFamily(playWriter),
                            color = Color(0xFF800000)
                        )
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Button(
                        onClick = { viewModel.add()
                            onDismiss()},
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFFF7A5A5))
                    ) {
                        Text(text = "Add",
                            fontFamily = FontFamily(playWriter),
                            color = Color(0xFF800000)
                        )
                    }
                }
            }
        }
    }
}