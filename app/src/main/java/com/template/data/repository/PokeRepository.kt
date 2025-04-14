package com.template.data.repository

import com.template.data.model.response.PokemonListResponse
import com.template.data.network.PokeApiService
import javax.inject.Inject

class PokeRepository @Inject constructor(
    private val apiService: PokeApiService
) {
    suspend fun getPokemonList(limit: Int = 10, offset: Int = 0): PokemonListResponse {
        return apiService.getPokemonList(limit, offset)
    }
}