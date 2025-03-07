package xyz.teamgravity.supportedgetoedgecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import xyz.teamgravity.supportedgetoedgecompose.ui.theme.SupportEdgeToEdgeComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SupportEdgeToEdgeComposeTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = stringResource(R.string.hello_world)
                                )
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = Color(0xFF37B362)
                            )
                        )
                    },
                    bottomBar = {
                        BottomAppBar(
                            containerColor = Color(0xFF37B362)
                        ) {
                            Text(
                                text = stringResource(R.string.hello_world)
                            )
                        }
                    },
                    contentWindowInsets = WindowInsets.safeContent,
                    modifier = Modifier.fillMaxSize()
                ) { padding ->
                    LazyColumn(
                        contentPadding = padding
                    ) {
                        items(
                            count = 100,
                            key = { it }
                        ) { index ->
                            Text(
                                text = stringResource(R.string.your_item, index),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.White)
                                    .padding(16.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}