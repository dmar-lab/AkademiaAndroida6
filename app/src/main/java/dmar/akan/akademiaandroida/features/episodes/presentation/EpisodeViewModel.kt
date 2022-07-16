package dmar.akan.akademiaandroida.features.episodes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import dmar.akan.akademiaandroida.core.base.BaseViewModel
import dmar.akan.akademiaandroida.features.episodes.domain.GetEpisodesUseCase
import dmar.akan.akademiaandroida.features.episodes.domain.model.Episode
import dmar.akan.akademiaandroida.features.episodes.presentation.model.EpisodeDisplayable

class EpisodeViewModel(private val getEpisodesUseCase: GetEpisodesUseCase): BaseViewModel() {

    private val _episodes by lazy { MutableLiveData<List<Episode>>()
        .also { getEpisodes(it) }
    }

//    keep it simple:
//    val episodes: LiveData<List<EpisodeDisplayable>> = Transformations.map(_episodes) { episodes ->
    val episodes: LiveData<List<EpisodeDisplayable>> by lazy {
        _episodes.map { episodes ->
            episodes.map { EpisodeDisplayable(it) }
        }
    }

    private fun getEpisodes(episodeLiveData: MutableLiveData<List<Episode>>) {
        setPendingState()
        getEpisodesUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            /*result.onSuccess { episodes ->
                episodeLiveData.value = episodes
            }*/
            result.onSuccess { episodeLiveData.value = it }
            result.onFailure { handleFailure(it) } // in BaseViewModel
        }
    }

    /*override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        //
    }*/
}
