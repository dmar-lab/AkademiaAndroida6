package dmar.akan.akademiaandroida.features.episodes.domain

import dmar.akan.akademiaandroida.features.episodes.EpisodeRepository
import dmar.akan.akademiaandroida.features.episodes.domain.model.Episode
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

// POZOR! before commit create modul6 branch
class GetEpisodesUseCase(private val episodeRepository: EpisodeRepository) {

    operator fun invoke(
        scope: CoroutineScope,
        onResult: (List<Episode>) -> Unit
    ) {
        scope.launch {
            // REMEMBER this should be called only from a coroutine
            val result = episodeRepository.getEpisodes()
            onResult(result)
        }
    }
}
