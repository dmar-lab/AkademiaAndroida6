package dmar.akan.akademiaandroida.features.episodes.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import dmar.akan.akademiaandroida.R
import dmar.akan.akademiaandroida.core.base.UiState
import org.koin.androidx.viewmodel.ext.android.viewModel

//import androidx.lifecycle.ViewModelStoreOwner

class EpisodeFragment : Fragment() {

    private val viewModel: EpisodeViewModel by viewModel()
//    private val viewModel by viewModel<EpisodeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeEpisodes()
        observeUiState()
        observeMessage()
    }

    private fun observeEpisodes() {
        viewModel.episodes.observe(this) {
            // code to show episodes
            val adapter = EpisodeAdapter()
            it?.let { adapter.data = it }
        }

    }

    private fun observeUiState() {
        viewModel.uiState.observe(this) {
            when (it) {
                UiState.Idle -> onIdleState()
                UiState.Pending -> onPendingState()
            }
        }
    }

    private fun onIdleState() {
        //handle idle state
    }

    private fun onPendingState() {
        //handle pending state
    }

    private fun observeMessage() {
        viewModel.message.observe(this) {
            showToast(it)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_episode, container, false)
    }
}
