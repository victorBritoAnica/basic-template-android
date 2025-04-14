package com.template.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.template.data.model.response.PokemonListResponse
import com.template.data.repository.PokeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val repository: PokeRepository
) : ViewModel() {

    private val _pokemonListState = MutableStateFlow<PokemonListResponse?>(null)
    val pokemonListState: StateFlow<PokemonListResponse?> = _pokemonListState

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun fetchPokemonList(limit: Int = 10, offset: Int = 0) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            try {
                val response = repository.getPokemonList(limit, offset)
                _pokemonListState.value = response
            } catch (e: Exception) {
                _errorMessage.value = e.message ?: "Ocurrió un error desconocido"
            } finally {
                _isLoading.value = false
            }
        }
    }
}