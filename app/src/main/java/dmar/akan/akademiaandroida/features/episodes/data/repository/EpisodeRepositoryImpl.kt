package dmar.akan.akademiaandroida.features.episodes.data.repository

import dmar.akan.akademiaandroida.core.api.RickAndMortyApi
import dmar.akan.akademiaandroida.core.network.NetworkStateProvider
import dmar.akan.akademiaandroida.features.episodes.data.local.EpisodeDao
import dmar.akan.akademiaandroida.features.episodes.data.local.model.EpisodeCached
import dmar.akan.akademiaandroida.features.episodes.domain.EpisodeRepository
import dmar.akan.akademiaandroida.features.episodes.domain.model.Episode

class EpisodeRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val episodeDao: EpisodeDao,
    private val networkStateProvider: NetworkStateProvider
) : EpisodeRepository {

    override suspend fun getEpisodes(): List<Episode> {
        // EpisodeRemote as it
        return if (networkStateProvider.isNetworkAvailable()) {
            getEpisodesFromRemote()
                .also { saveEpisodesToLocal(it) }
        } else {
            getEpisodesFromLocal()
        }
    }

    private suspend fun getEpisodesFromRemote(): List<Episode> {
        return rickAndMortyApi.getEpisode()
            .results
            .map { it.toEpisode() } // typ z warstwy danych(sieciowej) na typ obiektu domenowego
    }

    private suspend fun saveEpisodesToLocal(episodes: List<Episode>) {
        episodes.map { EpisodeCached(it) }
            .toTypedArray()
            .let { episodeDao.saveEpisodes(*it) }
    }

    private suspend fun getEpisodesFromLocal(): List<Episode> {
        return episodeDao.getEpisodes()
            .map { it.toEpisode() }
    }
}
