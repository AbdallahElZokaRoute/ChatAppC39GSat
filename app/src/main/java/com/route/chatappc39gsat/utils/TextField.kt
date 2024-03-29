package com.route.chatappc39gsat.utils

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp
import com.route.chatappc39gsat.ui.theme.black
import com.route.chatappc39gsat.ui.theme.blue

@Composable
fun ChatAuthTextField(
    state: MutableState<String>,
    error: String?,
    label: String,
    modifier: Modifier = Modifier,
    isPassword: Boolean = false
) {
    Column(modifier = modifier.fillMaxWidth(0.9F)) {
        TextField(
            value = state.value,
            onValueChange = {
                state.value = it
            },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                errorContainerColor = Color.Transparent,
                focusedIndicatorColor = blue,
                unfocusedIndicatorColor = black,
                errorIndicatorColor = Color.Red
            ),
            label = {
                Text(text = label, fontSize = 12.sp, fontWeight = FontWeight.Normal)
            },
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None
        )
        if (error != null) {
            Text(
                text = error,
                color = Color.Red,
                fontSize = 18.sp,
                modifier = Modifier.align(Alignment.Start)
            )
        }
    }
}
