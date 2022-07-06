package dmar.akan.akademiaandroida.features.episodes.di

import dmar.akan.akademiaandroida.features.episodes.data.repository.EpisodeRepositoryImpl
import dmar.akan.akademiaandroida.features.episodes.domain.EpisodeRepository
import dmar.akan.akademiaandroida.features.episodes.domain.GetEpisodesUseCase
import dmar.akan.akademiaandroida.features.episodes.presentation.EpisodeFragment
import dmar.akan.akademiaandroida.features.episodes.presentation.EpisodeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val episodeModule= module {
    //data
    factory<EpisodeRepository> { EpisodeRepositoryImpl(get(), get(), get()) }

    //domain
    factory { GetEpisodesUseCase(get()) }

    //presentation
    viewModel { EpisodeViewModel(get()) }
    factory { EpisodeFragment() }
}
