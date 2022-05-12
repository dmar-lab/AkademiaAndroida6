package dmar.akan.akademiaandroida.features.data.remote.model

import com.google.gson.annotations.SerializedName
import dmar.akan.akademiaandroida.features.characters.domain.model.Character

// data classes can be nested
data class CharacterRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("species") val species: String,
    @SerializedName("type") val type: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("origin") val origin: CharacterOriginRemote,
    @SerializedName("location") val location: CharacterLocationRemote,
    @SerializedName("image") val image: String,
    @SerializedName("episode") val episode: List<String>,
    @SerializedName("url") val url: String
) {
    // mapping from CharacterRemote to Character
    fun toCharacter() = Character(
        id = id,
        name = name,
        species = species,
        type = type,
        gender = gender,
        origin = origin.toCharacterOrigin(),
        location = location.toCharacterLocation(),
        image = image,
        episode = episode,
        url = url
    )

    data class CharacterOriginRemote(
        val name: String = "",
        val url: String = ""
    ) {
        fun toCharacterOrigin() = Character.CharacterOrigin(
            name = name,
            url = url
        )
    }

    data class CharacterLocationRemote(
        val name: String = "",
        val url: String = ""
    ) {
        fun toCharacterLocation() = Character.CharacterLocation(
            name = name,
            url = url
        )
    }
}
