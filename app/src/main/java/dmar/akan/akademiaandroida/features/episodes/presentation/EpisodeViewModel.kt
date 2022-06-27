package dmar.akan.akademiaandroida.features.episodes.presentation

import androidx.lifecycle.*
import com.hadilq.liveevent.LiveEvent
import dmar.akan.akademiaandroida.core.base.UiState
import dmar.akan.akademiaandroida.features.episodes.domain.GetEpisodesUseCase
import dmar.akan.akademiaandroida.features.episodes.domain.model.Episode
import dmar.akan.akademiaandroida.features.episodes.presentation.model.EpisodeDisplayable

class EpisodeViewModel(private val getEpisodesUseCase: GetEpisodesUseCase): ViewModel() {

    private val _message by lazy { LiveEvent<String>() }
    val message: LiveData<String> = _message

    // zainicjowanie poczatkowym stanem tu: UiState.Idle
    private val _uiState by lazy { MutableLiveData<UiState>(UiState.Idle) }
    val uiState: LiveData<UiState> = _uiState

    private val _episodes by lazy { MutableLiveData<List<Episode>>()
        .also { getEpisodes(it) }
    }

    val episodes: LiveData<List<EpisodeDisplayable>> = _episodes.map { episodes ->
        episodes.map { EpisodeDisplayable(it) }
    }

    private fun getEpisodes(episodeLiveData: MutableLiveData<List<Episode>>) {
        _uiState.value = UiState.Pending
        getEpisodesUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            _uiState.value = UiState.Idle
            result.onSuccess { episodes ->
                episodeLiveData.value = episodes
            }

            result.onFailure { throwable ->
                throwable.message
                ?.let { showMessage(it) }
            }
        }
    }

    private fun showMessage(message: String) {
        _message.value = message
    }

    private fun setPendingState() {}
    private fun setIdleState() {}
}
