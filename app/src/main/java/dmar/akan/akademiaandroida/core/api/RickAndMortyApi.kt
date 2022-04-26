package dmar.akan.akademiaandroida.core.api

import dmar.akan.akademiaandroida.core.api.model.EpisodeResponse
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("episode")
    suspend fun getEpisode(): EpisodeResponse
}
