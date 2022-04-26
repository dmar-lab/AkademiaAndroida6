package dmar.akan.akademiaandroida.features.episodes.data.repository

import dmar.akan.akademiaandroida.core.api.RickAndMortyApi
import dmar.akan.akademiaandroida.features.episodes.domain.EpisodeRepository
import dmar.akan.akademiaandroida.features.episodes.domain.model.Episode

class EpisodeRepositoryImpl(private val api: RickAndMortyApi) : EpisodeRepository {

    override suspend fun getEpisodes(): List<Episode> {
        // EpisodeRemote as it
        return api.getEpisode()
            .results
            .map { it.toEpisode() } // typ z warstwy danych(sieciowej) na typ obiektu domenowego
    }
}