package dmar.akan.akademiaandroida.features.characters.data.local.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import dmar.akan.akademiaandroida.features.characters.domain.model.Character

@Entity
data class CharacterCached(
    @PrimaryKey
    val id: Int,
    val name: String,
    val species: String,
    val type: String,
    val gender: String,
//    val origin: Character.CharacterOrigin,
    @Embedded(prefix = "characterOriginCached")
    val origin: CharacterOriginCached,
//    val location: Character.CharacterLocation,
    @Embedded(prefix = "characterLocationCached")
    val location: CharacterLocationCached,
    val image: String,
    val episode: List<String>,
    val url: String
) {

    constructor(character: Character) : this(
        character.id,
        character.name,
        character.species,
        character.type,
        character.gender,
        CharacterOriginCached(character.origin),
        CharacterLocationCached(character.location),
        character.image,
        character.episode,
        character.url
    )

    companion object

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
}
