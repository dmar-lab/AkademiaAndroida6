package dmar.akan.akademiaandroida.core.di

import dmar.akan.akademiaandroida.features.episodes.di.episodeModule
import org.koin.core.module.Module

val featureModules = listOf<Module>(
    episodeModule
)