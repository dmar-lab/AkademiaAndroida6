package dmar.akan.akademiaandroida.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dmar.akan.akademiaandroida.features.characters.data.local.CharacterDao
import dmar.akan.akademiaandroida.features.episodes.data.local.EpisodeDao
import dmar.akan.akademiaandroida.features.episodes.data.local.model.EpisodeCached
import dmar.akan.akademiaandroida.features.locations.data.local.LocationDao

@Database(entities = [EpisodeCached::class], version = 1)
@TypeConverters(ListConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun episodeDao(): EpisodeDao
    abstract fun characterDao(): CharacterDao
    abstract fun locationDao(): LocationDao
}
