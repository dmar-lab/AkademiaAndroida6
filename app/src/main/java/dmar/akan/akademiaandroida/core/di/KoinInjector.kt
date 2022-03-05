package dmar.akan.akademiaandroida.core.di

import org.koin.core.module.Module

val koinInjector: List<Module> = listOf(
    networkModule,
    appModule,
    databaseModule
)