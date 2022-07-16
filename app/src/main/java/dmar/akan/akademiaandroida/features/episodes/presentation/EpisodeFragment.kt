package dmar.akan.akademiaandroida.features.episodes.presentation

import dmar.akan.akademiaandroida.R
import dmar.akan.akademiaandroida.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

//import androidx.lifecycle.observe

class EpisodeFragment : BaseFragment<EpisodeViewModel>(R.layout.fragment_episode) {

    override val viewModel: EpisodeViewModel by viewModel()
//    private val viewModel by viewModel<EpisodeViewModel>()

    override fun initViews() {
        super.initViews()
        //initialize all view-related classes
    }

    override fun initObservers() {
        super.initObservers()
        observeEpisodes()
    }

    override fun onIdleState() {
        super.onIdleState()
        //handle idle state here
    }

    override fun onPendingState() {
        super.onPendingState()
        //handle pending state here
    }

    private fun observeEpisodes() {
        viewModel.episodes.observe(this) {
            // code to show episodes
            val adapter = EpisodeAdapter()
            it?.let { adapter.data = it }
        }
    }
}
