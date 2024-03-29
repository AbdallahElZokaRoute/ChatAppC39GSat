package com.route.chatappc39gsat.home

import android.content.Intent
import android.hardware.TriggerEvent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.route.chatappc39gsat.R
import com.route.chatappc39gsat.ui.theme.ChatAppC39GSatTheme
import com.route.chatappc39gsat.utils.ChatToolbar
import androidx.lifecycle.viewmodel.compose.viewModel
import com.route.chatappc39gsat.addRoom.AddRoomActivity
import com.route.chatappc39gsat.ui.theme.blue

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatAppC39GSatTheme {
                // A surface container using the 'background' color from the theme
                HomeContent()
            }
        }
    }
}

@Composable
fun HomeContent(
    viewModel: HomeViewModel = viewModel()
) {
    Scaffold(
        topBar = {
            ChatToolbar(title = stringResource(id = R.string.chat_app))
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.navigateToAddRoomScreen()
                },
                containerColor = blue,
                contentColor = Color.White,
                shape = CircleShape,
                modifier = Modifier.size(60.dp),
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.ic_add
                    ), contentDescription = stringResource(
                        R.string.icon_add_room
                    )
                )
            }
        }
    ) { paddingValues ->
        paddingValues
        Column(
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    painter = painterResource(id = R.drawable.bg),
                    contentScale = ContentScale.FillBounds
                )
        ) {

        }
    }
    TriggerEvent(viewModel.events.value)
}

@Composable
fun TriggerEvent(event: HomeViewEvent, viewModel: HomeViewModel = viewModel()) {
    val context = LocalContext.current
    when (event) {
        HomeViewEvent.Idle -> {}
        HomeViewEvent.NavigateToAddRoomDestination -> {
            val intent = Intent(context, AddRoomActivity::class.java)
            context.startActivity(intent)
            viewModel.resetToIdleState()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomePreview() {
    HomeContent()
}

