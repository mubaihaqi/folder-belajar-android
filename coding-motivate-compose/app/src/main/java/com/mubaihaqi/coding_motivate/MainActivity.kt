package com.mubaihaqi.coding_motivate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.os.Build
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.compose.runtime.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.mubaihaqi.coding_motivate.ui.theme.CodingmotivateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodingmotivateTheme {
                val systemUiController = rememberSystemUiController()
                val statusBarColor = colorResource(id = R.color.bgslate)

                SideEffect {
                    systemUiController.setStatusBarColor(
                        color = statusBarColor,
                        darkIcons = false
                    )
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.cardslate)
                ) {
                    MotivationalMessage()
                }
            }
        }
    }
}


@OptIn(ExperimentalTextApi::class)
@Composable
fun MotivationalMessage() {
    Column(modifier = Modifier.padding(top = 32.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        val gradientText = listOf(
            colorResource(id = R.color.textcream),
            colorResource(id = R.color.pinktone)
        )

        Text(
            text = "Semangat calon pro dev",
            style = TextStyle(
                brush = Brush.linearGradient(gradientText),
                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = buildAnnotatedString {
                withStyle(style = ParagraphStyle(textIndent = TextIndent(firstLine = 16.sp))) {
                    append(
                        """
                        Belajar ngoding tuh kadang kayak naik roller coaster—seru tapi juga bikin mual. Kadang lo semangat kayak mau hack NASA, kadang stuck gara-gara typo doang 3 jam. Tapi chill, itu semua bagian dari proses.

                        Ingat, semua engineer jago juga pernah noob. Gak ada yang lahir-lahir langsung bisa bikin app sekeren Instagram. Mereka juga pernah nanya ke StackOverflow buat hal receh kayak “kenapa semicolon gue error”.

                        Lo gak harus langsung paham semuanya. Satu-satu aja. Hari ini ngerti loop, besok ngerti function, lusa ngegas bikin API. Yang penting lo jalan terus, walaupun pelan. Yang penting lo tetap belajar, walau capek. Istirahat boleh, nyerah jangan.

                        Dan jangan terlalu bandingin progres lo sama orang lain. Mereka mungkin udah di level 99 karena udah mulai duluan. Fokus aja sama level lo sendiri—lama-lama juga naik EXP-nya.

                        Lo bukan gagal, lo lagi *progress*. Jadi nikmatin aja proses belajar lo. Toh nanti, pas lo ngeliat ke belakang, lo bakal amazed sendiri: “Gila, dulu gue beneran gak ngerti apa-apa, sekarang bisa bikin project sendiri.”

                        Semangat, calon pro dev! 💻🔥
                        Gas terus, jangan kasih kendor! 💪
                        """.trimIndent()
                    )
                }
            },
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(top = 16.dp),
            color = colorResource(id = R.color.textcream)
        )
    }
}