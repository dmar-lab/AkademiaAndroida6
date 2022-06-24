package dmar.akan.akademiaandroida.core.api

import dmar.akan.akademiaandroida.core.api.model.CharacterResponse
import dmar.akan.akademiaandroida.core.api.model.EpisodeResponse
import dmar.akan.akademiaandroida.core.api.model.LocationResponse
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("episode")
    suspend fun getEpisode(): EpisodeResponse

    @GET("character")
    suspend fun getCharacter(): CharacterResponse

    @GET("location")
    suspend fun getLocation(): LocationResponse
}
