package dmar.akan.akademiaandroida.core.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dmar.akan.akademiaandroida.features.characters.domain.model.Character

class ObjectConverter {

    companion object {

        @TypeConverter
        @JvmStatic
        fun toJsonOrigin(data: Character.CharacterOrigin): String {
            return Gson().toJson(data)
        }

        @TypeConverter
        @JvmStatic
        fun toJsonLocation(data: Character.CharacterLocation): String {
            return Gson().toJson(data)
        }

        @TypeConverter
        @JvmStatic
        fun fromJsonOrigin(json: String): Character.CharacterOrigin {
            return Gson().fromJson(json, object : TypeToken<Character.CharacterOrigin>() {}.type)
        }

        @TypeConverter
        @JvmStatic
        fun fromJsonLocation(json: String): Character.CharacterLocation {
            return Gson().fromJson(json, object : TypeToken<Character.CharacterLocation>() {}.type)
        }
    }

}
