package com.example.modifierdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.modifierdemo.ui.theme.ModifierDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ModifierDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DemoScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun DemoScreen(modifier: Modifier = Modifier) {
    val my_modifier = modifier
        .border(width = 2.dp, color = Color.Black) // Рисует чёрную рамку шириной 2 пикселя
        .padding(all = 10.dp) // Добавляет отступ в 10 пикселей со всех четырёх сторон
    Column(
        Modifier.padding(20.dp), // Отступ 20 пикселей вокруг
        horizontalAlignment = Alignment.CenterHorizontally, // Центрирование по горизонтали
        verticalArrangement = Arrangement.Center // Центрирование по вертикали
    ) {
        Text(
            "TANK GIRL",
            my_modifier,
            fontSize = 40.sp, // Размер шрифта
            fontWeight = FontWeight.Bold // Жирный шрифт
        )
        Spacer(Modifier.height(10.dp)) // Отступ от строки к изображению
        CustomImage(R.drawable.movie,
            Modifier
                .padding(10.dp) // Отступ вокруг изображения
                .width(270.dp) // Ширина изображения
                .clip(shape = RoundedCornerShape(30.dp)) // Обрезает и закругляет углы
        )
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ModifierDemoTheme {
        DemoScreen()
    }
}

/*val modifier = Modifier
    .padding(all = 10.dp) // Добавляет отступ в 10 пикселей со всех четырёх сторон
    .border(width = 2.dp, color = Color.Black) // Рисует чёрную рамку шириной 2 пикселя */

@Composable // Параметр модификатора должен быть необязательным, чтобы функцию можно было вызвать без него
fun CustomImage(image: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(image),
        contentDescription = null,
        modifier
    )
}
