package dmar.akan.akademiaandroida.di

import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

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
}