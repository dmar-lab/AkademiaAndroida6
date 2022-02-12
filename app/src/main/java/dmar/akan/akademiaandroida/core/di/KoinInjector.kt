package dmar.akan.akademiaandroida.core.di

import dmar.akan.akademiaandroida.di.appModule
import dmar.akan.akademiaandroida.di.databaseModule
import org.koin.core.module.Module

val koinInjector: List<Module> = listOf(
    networkModule,
    appModule,
    databaseModule
)