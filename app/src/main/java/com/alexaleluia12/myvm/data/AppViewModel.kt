package com.alexaleluia12.myvm.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AppViewModel : ViewModel() {
    var uiState: AppUiState by mutableStateOf(AppUiState())
        private set

    fun stop() {
        // assin nao atualiza o composable
        // uiState.isRunning = false
        // precisa mudar a referencia de uiState
        uiState = uiState.copy(isRunning = false)
    }

    fun start() {
        uiState = uiState.copy(isRunning = true)
    }

    fun addTen() {
        if (uiState.isRunning)
            uiState = uiState.copy(
                result = uiState.result + 10
            )
    }

    fun addTwentyFive() {
        if (uiState.isRunning)
            uiState = uiState.copy(result = uiState.result+25)

    }

    fun rezet() {
        uiState = uiState.copy(result = 0)
    }
}
