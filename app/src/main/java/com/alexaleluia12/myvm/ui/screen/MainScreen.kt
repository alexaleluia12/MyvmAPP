package com.alexaleluia12.myvm.ui.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alexaleluia12.myvm.data.AppViewModel
import com.alexaleluia12.myvm.ui.theme.MyvmTheme

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    appViewModel: AppViewModel = viewModel()
) {
    val uiState = appViewModel.uiState
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        Row {
            Button(onClick = {
                if (!uiState.isRunning)
                    showToast("Aperte GRAVAR antes", context)
                else
                    appViewModel.addTen()
            }) {
                Text("+10")
            }

            Spacer(Modifier.weight(0.5f))

            Button(onClick = {
                if (!uiState.isRunning)
                    showToast("Aperte GRAVAR antes", context)
                else
                    appViewModel.addTwentyFive()
            }) {
                Text("+25")
            }
        }

        Text("Resultado", modifier = Modifier.padding(8.dp))
        Spacer(modifier)
        Text(text = uiState.result.toString(), modifier = Modifier.padding(8.dp))
        Spacer(modifier)

        Button(onClick = {
            if (uiState.isRunning)
                appViewModel.stop()
            else
                appViewModel.start()

        }) {
            val text = if (uiState.isRunning) "STOP" else "GRAVAR"
            Text(text)
        }

        Button(onClick = { appViewModel.rezet() }) {
            Text("Reiniciar")
        }

    }
}

fun showToast(message: String, context: Context) {
    Toast.makeText(
        context,
        message,
        Toast.LENGTH_SHORT,
    ).show()
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MyvmTheme {
        MainScreen()
    }
}