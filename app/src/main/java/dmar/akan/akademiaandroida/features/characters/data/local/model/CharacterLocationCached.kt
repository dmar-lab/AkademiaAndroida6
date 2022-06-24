package dmar.akan.akademiaandroida.features.characters.data.local.model

import dmar.akan.akademiaandroida.features.characters.domain.model.Character

class CharacterLocationCached(
    val name: String,
    val url: String
) {
    constructor(location: Character.CharacterLocation) : this(location.name, location.url)

    companion object

    fun toCharacterLocation() = Character.CharacterLocation(name, url)
}
