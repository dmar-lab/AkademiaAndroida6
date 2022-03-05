package dmar.akan.akademiaandroida.core.di

import org.koin.dsl.module

val databaseModule = module {
/*
    single {
        Room.databaseBuilder(
            androidApplication(),
            CharactersDatabase::class.java,
            "characters_db"
        ).build()
    }

    factory<CharactersDao> {
        get<CharactersDatabase>().characterDao()
    }

    factory<CharactersRepository> {
        CharactersRepository(charactersDao = get())
    }
    */
}
