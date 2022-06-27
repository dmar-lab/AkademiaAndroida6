package dmar.akan.akademiaandroida.core.base

sealed class UiState {
    object Idle: UiState() // ekran w spoczynku
    object Pending: UiState() // oczekujemy na rezultat jakiejs operacji (progressBar, szary button)
}
