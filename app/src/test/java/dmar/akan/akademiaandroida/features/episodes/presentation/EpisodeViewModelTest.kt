package dmar.akan.akademiaandroida.features.episodes.presentation

import dmar.akan.akademiaandroida.core.base.UiState
import dmar.akan.akademiaandroida.features.episodes.domain.GetEpisodesUseCase
import dmar.akan.akademiaandroida.utils.ViewModelTest
import dmar.akan.akademiaandroida.utils.getOrAwaitValue
import dmar.akan.akademiaandroida.utils.observeForTesting
import io.mockk.mockk
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class EpisodeViewModelTest : ViewModelTest() {

    @Test
    fun `WHEN episode live data is observed THEN set pending state`() {
        //given
        val useCase = mockk<GetEpisodesUseCase>(relaxed = true)
        val viewModel = EpisodeViewModel(useCase)

        //when
        viewModel.episodes.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Pending
    }

    @Test
    fun `WHEN episode live data is observed THEN invoke use case to get episodes`() {

    }

    @Test
    fun `GIVEN use case result is success WHEN episode live data is observed THEN set idle state AND set result in live data`() {

    }

    @Test
    fun `GIVEN use case result is failure WHEN episode live data is observed THEN set idle state AND set error message in live data`() {

    }
}