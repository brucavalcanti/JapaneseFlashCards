package com.example.japaneseflashcards

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.japaneseflashcards.ui.theme.CherryRed
import com.example.japaneseflashcards.ui.theme.JapaneseFlashCardsTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JapaneseFlashCardsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    MainScreenConstraint(
                        modifier = Modifier.padding()
                    )
                }
            }
        }
    }

    @Composable

    fun MainScreenConstraint(modifier: Modifier=Modifier)
    {
        Surface(color = MaterialTheme.colorScheme.primary)
        {
            ConstraintLayout(modifier = modifier.fillMaxSize()){
                val (logo,logoTitle,btnHiragana,btnKatakana) = createRefs()
                Image(painter = painterResource(R.drawable.ic_logo_50), contentDescription = "Logo",
                    modifier = modifier
                        .constrainAs(logo)
                        {
                            top.linkTo(parent.top,  margin = (86.dp))
                            centerHorizontallyTo(parent)
                        }
                        .size(120.dp)

                )
                Text("Japanese FlashCards",
                    fontFamily = FontFamily.Serif, fontWeight = FontWeight.Bold, fontSize = 20.sp,
                    modifier = modifier.constrainAs(logoTitle)
                {
                    top.linkTo(logo.bottom, margin = 10.dp)
                    centerHorizontallyTo(parent)

                })

                ElevatedButton(onClick = {Cliquei("Hiragana")},
                    modifier = modifier.constrainAs(btnHiragana)
                    {
                        top.linkTo(logoTitle.bottom, margin = 30.dp)
                        centerHorizontallyTo(parent)
                    }) { Text("Hiragana") }
                ElevatedButton(onClick = {Cliquei("Katakana")},
                    modifier = modifier.constrainAs(btnKatakana)
                    {
                        top.linkTo(btnHiragana.bottom, margin = 30.dp)
                        centerHorizontallyTo(parent)
                    }) { Text("Katakana") }
            }
        }
    }


    fun Cliquei(botao:String)
    {
        Log.d(botao.uppercase(), "Cliquei: $botao foi clicado ")
        Toast.makeText(this, "Cliquei em $botao", Toast.LENGTH_SHORT).show()
    }

/*@Composable
fun MainScreen(modifier: Modifier=Modifier) {
    Surface(color = MaterialTheme.colorScheme.surface) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
           Image(painter = painterResource(R.drawable.ic_logo_50),
               contentDescription ="Logo",modifier= modifier.size(150.dp) )
            Text("Japanese Flash Cards", color = CherryRed)
            ElevatedButton(onClick = {
                Log.d("Hiragana", "MainScreen: Clicou em Hiragana ")
            }) { Text(text = "Hiragana") }
            ElevatedButton(onClick = {}) { Text(text = "Katakana") }
        }
    }
}
*/
    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier,
            color = CherryRed
        )
    }

    @Preview(widthDp = 320)
    @Composable
    fun MainScreenPreview() {
        JapaneseFlashCardsTheme {
            MainScreenConstraint()
        }
    }
}
