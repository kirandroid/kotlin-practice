package com.example.myapplication

import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    GreetingImage(
//                        stringResource(R.string.happy_birthday_text),
//                        stringResource(R.string.from_message)
//                    )
//                    composedArticle(
//                        stringResource(R.string.article_title),
//                        stringResource(R.string.article_para_1),
//                        stringResource(R.string.article_para_2)
//                    )
//                    taskManager(
//                        stringResource(R.string.task_completed),
//                        stringResource(R.string.nice_work)
//                    )

//                    composeQuadrant(
//                        stringResource(R.string.q_title_1),
//                        stringResource(R.string.q_desc_1),
//                        stringResource(R.string.q_title_2),
//                        stringResource(R.string.q_desc_2),
//                        stringResource(R.string.q_title_3),
//                        stringResource(R.string.q_desc_3),
//                        stringResource(R.string.q_title_4),
//                        stringResource(R.string.q_desc_4),
//                    )
                    businessCard()
                }
            }
        }
    }
}

@Composable
fun businessCard(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFEADDFF)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        nameCard(modifier = Modifier.weight(1f))
        contacts(modifier = Modifier.weight(1f))
    }
}

@Composable
fun nameCard(modifier: Modifier = Modifier) {
    val android = painterResource(R.drawable.android_logo)
    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Bottom) {
        Box(modifier=Modifier.padding(24.dp).background(Color.LightGray).size(100.dp)) {
            Image(android, contentDescription = null)
        }
        Text(stringResource(R.string.jennifer_doe), fontSize = 50.sp)
        Text(stringResource(R.string.android_developer_extraordinaire), fontWeight = FontWeight.Bold, color = Color.Green)
    }
}

@Composable
fun contacts(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),

        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
        ) {
            Row(modifier= Modifier.padding(bottom = 16.dp)) {
                Icon(Icons.Rounded.Call, contentDescription = null, modifier = Modifier.padding(end = 16.dp))
                Text("+11 (123) 444 555 666")
            }
            Row(modifier= Modifier.padding(bottom = 16.dp)) {
                Icon(Icons.Rounded.Share, contentDescription = null, modifier = Modifier.padding(end = 16.dp))
                Text("@AndroidDev")
            }
            Row(modifier= Modifier.padding(bottom = 16.dp)) {
                Icon(Icons.Rounded.Email, contentDescription = null, modifier = Modifier.padding(end = 16.dp))
                Text("jen.doe@android.com")
            }
        }
    }
}

@Composable
fun composeQuadrant(
    qTitle1: String,
    qDesc1: String,
    qTitle2: String,
    qDesc2: String,
    qTitle3: String,
    qDesc3: String,
    qTitle4: String,
    qDesc4: String,
    modifier: Modifier = Modifier
) {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(qTitle1, qDesc1, Color(0xFFEADDFF), modifier = Modifier.weight(1f))
            ComposableInfoCard(qTitle2, qDesc2, Color(0xFFD0BCFF), modifier = Modifier.weight(1f))
        }
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(qTitle3, qDesc3, Color(0xFFB69DF8), modifier = Modifier.weight(1f))
            ComposableInfoCard(qTitle4, qDesc4, Color(0xFFF6EDFF), modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun ComposableInfoCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(description, textAlign = TextAlign.Justify)
    }
}

@Composable
fun taskManager(taskCompleted: String, niceWork: String) {
    val image = painterResource(R.drawable.ic_task_completed)
    Column(verticalArrangement = Arrangement.Center) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = taskCompleted,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 24.dp, bottom = 8.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = niceWork,
            fontSize = 16.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

    }
}

@Composable
fun composedArticle(
    articleTitle: String,
    articlePara1: String,
    articlePara2: String,
    modifier: Modifier = Modifier
) {
    val articleImage = painterResource(R.drawable.bg_compose_background)
    Column {
        Image(
            painter = articleImage,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Text(text = articleTitle, fontSize = 24.sp, modifier = modifier.padding(16.dp))
        Text(
            text = articlePara1,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = articlePara2, fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(16.dp)
        )

    }

}


@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        Greeting(
            message, from, modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Composable
fun Greeting(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HappyBirthdayTheme {
        GreetingImage("Android", "Cup")
    }
}