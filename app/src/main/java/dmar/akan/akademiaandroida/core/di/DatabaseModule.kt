package dmar.akan.akademiaandroida.core.di

import androidx.room.Room
import dmar.akan.akademiaandroida.core.database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "appDatabase"
        )
    }

    single { get<AppDatabase>().episodeDao() }
    single { get<AppDatabase>().characterDao() }
    single { get<AppDatabase>().locationDao() }
}
