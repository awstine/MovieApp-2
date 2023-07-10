package com.example.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sample.ui.theme.SampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleTheme() {
                // A surface container using the 'background' color from the theme
                val movies = listOf(
                    R.drawable.baby,
                    R.drawable.triple,
                    R.drawable.bank,
                    R.drawable.thieves,
                )
                Scaffold(
                    topBar = {
                        Column(
                            modifier = Modifier
                                .padding(16.dp),
                        ) {
                            TopAppBar(
                                navigationIcon = {
                                    Icon(painter = painterResource(id = R.drawable.menu),
                                        contentDescription = null,
                                        modifier = Modifier
                                            //.background(color = Color.White)
                                            // .padding(10.dp)
                                            .size(40.dp)
                                            .fillMaxWidth()
                                    )
                                },
                                actions = {
                                    Image(
                                        painter = painterResource(id = R.drawable.aws),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(40.dp)
                                            .clip(CircleShape),
                                        contentScale = ContentScale.Crop
                                    )
                                },
                                title = {}
                            )
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Activity",
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(15.dp)
                                ) {
                                    var selectedTab by remember {
                                        mutableStateOf("Friends")
                                    }
                                    circularTab(
                                        title = "Friends",
                                        selectedTab = selectedTab,
                                        onClickTab = {title ->
                                            selectedTab = title
                                        }
                                    )
                                    circularTab(
                                        title = "You",
                                        selectedTab = selectedTab,
                                        onClickTab = {title->
                                            selectedTab = title
                                        },

                                        )
                                }
                            }
                        }
                    }
                ){
                    LazyColumn(
                        modifier = Modifier.padding(it),
                        contentPadding = PaddingValues(18.dp),
                        verticalArrangement = Arrangement.spacedBy(24.dp),
                    ) {
                        item {
                            //Refactor then functions(Changes it to a function)
                            midInfoComponents(
                                circleContent = {
                                    Text(text = "A")
                                } ,
                                type = "Liked Collection",
                                content = {
                                    Text(
                                        color = Orange,
                                        text = "The best of the Disney",
                                        fontWeight = FontWeight.SemiBold,
                                    )
                                }
                            )
                            Spacer(modifier = Modifier.height(12.dp))

                        }

                        item {
                            midInfoComponents(
                                circleContent = {
                                    Text(text = "G")
                                },
                                type = "Like",
                                content = {
                                    Column{
                                        Spacer(modifier = Modifier.height(12.dp))
                                        LazyRow(
                                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                                        ){
                                            items(movies){movie ->
                                                Card(
                                                    modifier = Modifier
                                                        .width(150.dp)
                                                        .height(220.dp),
                                                ) {
                                                    Image(
                                                        painter = painterResource(id = movie),
                                                        contentDescription = null,
                                                        modifier = Modifier
                                                            .fillMaxSize(),
                                                        contentScale = ContentScale.Crop,
                                                    )
                                                }

                                            }
                                        }
                                        Spacer(modifier = Modifier.height(8.dp))

                                        Button(
                                            modifier = Modifier
                                                .fillMaxWidth(),
                                            shape = RoundedCornerShape(9.dp),
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = Color.Gray,
                                                contentColor = Color.Black
                                            ),
                                            onClick = { /*TODO*/ }) {
                                            Text(text = "8 more")
                                        }
                                    }
                                }
                            )
                        }

                        item {
                            midInfoComponents(
                                backgroundColor = Color.Black,
                                circleContent = {
                                    Image(painter = painterResource(id = R.drawable.netfllix),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(24.dp),
                                        contentScale = ContentScale.Crop
                                    )
                                },
                                type = "Posted",
                                content = {
                                    Column{
                                        Spacer(modifier = Modifier.size(8.dp))
                                        Text(
                                            text = "Watch official Trailer of FastX",
                                            fontWeight = FontWeight.SemiBold,
                                            fontSize = 16.sp,

                                            )
                                        Text(
                                            text = "FastX",
                                            fontWeight = FontWeight.SemiBold,
                                            color = Orange,
                                            fontSize = 16.sp,
                                        )
                                        Image(
                                            painter = painterResource(id = R.drawable.fastx),
                                            contentDescription = null,
                                            modifier = Modifier
                                                //.width(300.dp)
                                                //.height(220.dp)
                                                .clip(
                                                    RoundedCornerShape(30.dp),
                                                )
                                        )
                                    }
                                }
                            )
                        }
                    }
                }

            }
        }
    }

    @Composable
    private fun midInfoComponents(
        type: String="",
        content: @Composable () -> Unit = {},
        circleContent: @Composable () -> Unit,
        backgroundColor : Color = Color.Gray
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            //circle
            circleShape(
                backgroundColor = backgroundColor,
                content = {
                    circleContent()
                }
            )
            Column() {
                //The name title,description and the lower text
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    //The name and time
                    Text(
                        fontWeight = FontWeight.SemiBold,
                        text = "Awstine",
                    )
                    Text(
                        color = Color.Gray,
                        text = "45 mins"
                    )
                }
                Text(
                    type,
                    color = Color.Gray,
                )
                content()
            }
        }
    }

    @Composable
    fun circleShape(
        //to enable user pass what he wants to
        content: @Composable () ->Unit,
        backgroundColor : Color,
    ) {
        Box(modifier = Modifier
            .size(45.dp)
            .clip(CircleShape)
            .background(backgroundColor),
            contentAlignment = Alignment.Center,
        ){//content in the box
            content()
        }
    }


    @Composable
    fun circularTab(
        selectedTab: String,
        title: String,
        onClickTab:(title:String)->Unit  //the unit represents nothing
    ){
        val selected = selectedTab == title
        Box(modifier = Modifier
            .height(50.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(
                if (selected) {
                    Color(0xFFfe8157)
                } else {
                    Color(0xFFfecf1f2)
                }
            )
            .clickable {
                onClickTab(title)
            },
            contentAlignment = Alignment.Center,
        )/*Adding this braces is the content you want to add*/{
            Text(
                text = title,
                modifier = Modifier
                    .padding(horizontal = 15.dp),
                color = if (selected){
                    Color.White
                }else{
                    Color.Black
                }

            )
        }
    }

}


