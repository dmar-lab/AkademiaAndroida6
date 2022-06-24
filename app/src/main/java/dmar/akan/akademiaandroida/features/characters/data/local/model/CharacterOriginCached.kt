package dmar.akan.akademiaandroida.features.characters.data.local.model

import dmar.akan.akademiaandroida.features.characters.domain.model.Character

class CharacterOriginCached(
    val name: String,
    val url: String
) {
    constructor(origin: Character.CharacterOrigin) : this(origin.name, origin.url)

    companion object

    fun toCharacterOrigin() = Character.CharacterOrigin(name, url)
}
