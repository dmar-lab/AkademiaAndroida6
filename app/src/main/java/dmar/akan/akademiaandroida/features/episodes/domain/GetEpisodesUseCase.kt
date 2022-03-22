package dmar.akan.akademiaandroida.features.episodes.domain

import dmar.akan.akademiaandroida.core.base.UseCase
import dmar.akan.akademiaandroida.features.episodes.EpisodeRepository
import dmar.akan.akademiaandroida.features.episodes.domain.model.Episode

class GetEpisodesUseCase(private val episodeRepository: EpisodeRepository) :
    UseCase<List<Episode>, Unit>() {

    // typowanie dynamiczne
    // typ funkcji action() jest taki jak funkcji getEpisodes()
    override suspend fun action(params: Unit) = episodeRepository.getEpisodes()

/*
override suspend fun action(params: Unit): List<Episode> = episodeRepository.getEpisodes()

// before <convert to expression body> Alt+Enter
override suspend fun action(params: Unit): List<Episode> {
    return episodeRepository.getEpisodes()
}
*/

/* //before generic UseCase
operator fun invoke(
        scope: CoroutineScope,
        executionDispatcher: CoroutineDispatcher = Dispatchers.IO,
        onResult: (Result<List<Episode>>) -> Unit = {} //wartosc domyslna jako pusta lambda
    ) {
        scope.launch {
            val result = withContext(executionDispatcher) {
            // REMEMBER this should be called only from a coroutine
                // runCatching because network operation can be failed
                runCatching { episodeRepository.getEpisodes() } // background thread
            }
            onResult(result) //main
        }
    }
*/
}
