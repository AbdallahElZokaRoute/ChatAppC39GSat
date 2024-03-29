package com.route.chatappc39gsat.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.route.chatappc39gsat.R
import com.route.chatappc39gsat.ui.theme.ChatAppC39GSatTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.route.chatappc39gsat.Constants
import com.route.chatappc39gsat.home.HomeActivity
import com.route.chatappc39gsat.login.LoginActivity

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatAppC39GSatTheme {
                SplashContent {
                    finish()
                }
            }
        }
    }
}

@Composable
fun SplashContent(viewModel: SplashViewModel = viewModel(), onFinish: () -> Unit) {
    LaunchedEffect(key1 = Unit) {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                viewModel.navigate()
            }, 1000
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1F))
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = stringResource(R.string.application_logo),
            modifier = Modifier.fillMaxHeight(0.25F),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.weight(1F))
        Image(
            painter = painterResource(id = R.drawable.signature),
            contentDescription = stringResource(
                R.string.application_development_signature
            ), modifier = Modifier
                .padding(8.dp)
                .fillMaxHeight(0.2F),
            contentScale = ContentScale.Crop
        )
    }
    TriggerEvents(event = viewModel.event.value) {
        onFinish()
    }
}

@Composable
fun TriggerEvents(
    event: SplashEvent,
    viewModel: SplashViewModel = viewModel(),
    onFinish: () -> Unit
) {
    val context = LocalContext.current
    when (event) {
        SplashEvent.Idle -> {}
        is SplashEvent.NavigateToHome -> {
            val intent = Intent(context, HomeActivity::class.java)
            // Serializable (Java SDK io)
            // Parcelable (Android OS )

            intent.putExtra(Constants.USER_KEY, event.user)
            context.startActivity(intent)
            onFinish()
        }

        SplashEvent.NavigateToLogin -> {
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
            onFinish()
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun SplashPreview() {
    SplashContent {

    }
}
