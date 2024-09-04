package com.example.pokedexappmvvm


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pokedexappmvvm.ui.theme.PokedexAppMVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexAppMVVMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}
@Composable
fun LoginScreen(onLoginClicked: () -> Unit) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Login", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            LoginField(label = "Username", value = "", onValueChanged = {})
            Spacer(modifier = Modifier.height(8.dp))
            LoginField(label = "Password", value = "", onValueChanged = {},
                isPassword = true)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onLoginClicked) {
                Text("Login")
            }
        }
    }
}

@Composable
fun LoginField(label: String, value: String, onValueChanged: (String) -> Unit,
               isPassword: Boolean = false) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        label = Text( text = label) ,
        modifier = Modifier.fillMaxWidth(),
        isSingleLine = true,
        isError = false, // Handle errors if needed
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = if (isPassword) KeyboardType.Password else KeyboardType.Text
        ),
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None
    )
}
@Composable
fun MainScreen() {
    LoginScreen(onLoginClicked = {}) // Implement login action here
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(onLoginClicked = {})
}



