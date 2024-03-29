package com.route.chatappc39gsat.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.route.chatappc39gsat.ui.theme.blue

@Composable
fun LoadingDialog(isLoading: MutableState<Boolean>) {
    if (isLoading.value)
        Dialog(onDismissRequest = { isLoading.value = false }) {
            CircularProgressIndicator(
                color = blue,
                modifier = Modifier
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
                    .padding(36.dp)
                    .size(80.dp),
                strokeWidth = 4.dp,
            )
        }
    
}

