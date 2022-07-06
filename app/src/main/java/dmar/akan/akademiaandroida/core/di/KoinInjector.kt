package dmar.akan.akademiaandroida.core.di

import org.koin.core.module.Module

val koinInjector: List<Module> = featureModules
    .plus(appModule)
    .plus(networkModule)
    .plus(databaseModule)

/*
val koinInjector: List<Module> = listOf(
    networkModule,
    appModule,
    databaseModule
)*/
