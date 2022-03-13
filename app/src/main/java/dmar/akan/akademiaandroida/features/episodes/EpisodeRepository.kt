package dmar.akan.akademiaandroida.features.episodes

import dmar.akan.akademiaandroida.features.episodes.domain.model.Episode

interface EpisodeRepository {
    suspend fun getEpisodes(): List<Episode> // type from domain layer
}
