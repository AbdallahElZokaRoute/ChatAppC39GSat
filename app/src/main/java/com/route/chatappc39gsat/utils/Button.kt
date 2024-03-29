package com.route.chatappc39gsat.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.route.chatappc39gsat.R
import com.route.chatappc39gsat.ui.theme.blue
import com.route.chatappc39gsat.ui.theme.gray
import com.route.chatappc39gsat.ui.theme.shadowColor

@Composable
fun ChatAuthButton(
    title: String,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true, onClick: () -> Unit,
) {
    Button(
        modifier = if (isEnabled) modifier.fillMaxWidth(0.9F) else modifier
            .fillMaxWidth(0.9F)
            .shadow(
                shape = RoundedCornerShape(
                    6.dp
                ),
                elevation = 5.dp,
                ambientColor = shadowColor,
            ),
        onClick = {
            onClick()
        },
        contentPadding = PaddingValues(horizontal = 36.dp, vertical = 18.dp),
        shape = RoundedCornerShape(6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isEnabled) blue else Color.White,
            contentColor = if (isEnabled) Color.White else gray
        )
    ) {
        Text(text = title, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.weight(1F))
        Image(
            painter = painterResource(id = R.drawable.ic_right),
            contentDescription = stringResource(
                R.string.icon_right
            )
        )
    }
}

@Composable
fun CreateButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = { onClick() },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(containerColor = blue, contentColor = Color.White)
    ) {
        Text(
            text = stringResource(R.string.create),
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White,
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ChatAuthButtonPreview() {
    ChatAuthButton(title = "Login") {

    }
}