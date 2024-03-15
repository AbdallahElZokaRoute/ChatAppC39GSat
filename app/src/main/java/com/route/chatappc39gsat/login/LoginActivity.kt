package com.route.chatappc39gsat.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.route.chatappc39gsat.R
import com.route.chatappc39gsat.ui.theme.ChatAppC39GSatTheme
import com.route.chatappc39gsat.ui.theme.black
import com.route.chatappc39gsat.utils.ChatAuthTextField
import com.route.chatappc39gsat.utils.ChatToolbar
import androidx.lifecycle.viewmodel.compose.viewModel
import com.route.chatappc39gsat.ui.theme.black2
import com.route.chatappc39gsat.utils.ChatAuthButton

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatAppC39GSatTheme {
                LoginContent()
            }
        }
    }
}

@Composable
fun LoginContent(viewModel: LoginViewModel = viewModel()) {
    Scaffold(topBar = {
        ChatToolbar(title = stringResource(R.string.login))
    }) { paddingValues ->
        paddingValues
        Column(
            modifier = Modifier
                .fillMaxSize()
                .paint(painterResource(id = R.drawable.bg), contentScale = ContentScale.FillBounds),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Spacer(modifier = Modifier.fillMaxHeight(0.38F))
            Text(
                text = stringResource(R.string.welcome_back),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = black,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(horizontal = 18.dp)
            )
            Spacer(modifier = Modifier.height(6.dp))
            ChatAuthTextField(
                state = viewModel.emailState,
                error = viewModel.emailErrorState.value,
                label = stringResource(
                    R.string.email
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            ChatAuthTextField(
                state = viewModel.passwordState,
                error = viewModel.passwordErrorState.value,
                label = stringResource(R.string.password),
            )
            Spacer(modifier = Modifier.height(16.dp))
            ChatAuthButton(title = stringResource(id = R.string.login)) {

            }
            TextButton(
                onClick = { }, modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.Start)
            ) {
                Text(
                    text = stringResource(R.string.or_create_my_account),
                    color = black2,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light
                )
            }
        }

    }
}

@Preview
@Composable
private fun LoginPreview() {
    LoginContent()
}
