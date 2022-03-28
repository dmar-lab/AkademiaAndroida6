package dmar.akan.akademiaandroida.features.characters

import dmar.akan.akademiaandroida.features.characters.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
}
