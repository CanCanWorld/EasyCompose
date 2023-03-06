package com.zrq.easycompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zrq.easycompose.bean.Category
import com.zrq.easycompose.ui.theme.EasyComposeTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EasyComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting("Android")

                    val picService = ServiceCreator.create(PicService::class.java)
                    picService.getCategory().enqueue(object : Callback<Category> {
                        override fun onResponse(call: Call<Category>, response: Response<Category>) {
                            Log.d("TAG", "onResponse: ${response.body().toString()}")
                        }

                        override fun onFailure(call: Call<Category>, t: Throwable) {
                        }
                    })
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EasyComposeTheme {
        Greeting("Android")
    }
}