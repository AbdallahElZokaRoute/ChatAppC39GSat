package com.route.chatappc39gsat.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.route.chatappc39gsat.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatToolbar(title: String, onNavigationIconClick: (() -> Unit)? = null) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        },
        navigationIcon = {
            if (onNavigationIconClick != null)
                Image(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = stringResource(R.string.icon_back),
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .clickable {
                            onNavigationIconClick()
                        }
                        .padding(12.dp)
                )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = Color.White
        )
    )
}

@Preview
@Composable
private fun ChatToolbarPreview() {
    ChatToolbar(title = "Login") {

    }
}