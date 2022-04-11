package dmar.akan.akademiaandroida.features.characters.domain

import dmar.akan.akademiaandroida.features.characters.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
}
