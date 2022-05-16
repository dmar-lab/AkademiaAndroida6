package dmar.akan.akademiaandroida.features.characters.data.repository

import dmar.akan.akademiaandroida.core.api.RickAndMortyApi
import dmar.akan.akademiaandroida.features.characters.data.local.CharacterDao
import dmar.akan.akademiaandroida.features.characters.data.local.model.CharacterCached
import dmar.akan.akademiaandroida.features.characters.domain.CharacterRepository
import dmar.akan.akademiaandroida.features.characters.domain.model.Character

class CharacterRepositoryImpl(
    private val api: RickAndMortyApi,
    private val characterDao: CharacterDao
) : CharacterRepository {

    override suspend fun getCharacters(): List<Character> {
        return api.getCharacter()
            .results
            .map { it.toCharacter() } // CharacterRemote as it
            .also { saveCharacters(it) }
    }

    private suspend fun saveCharacters(characters: List<Character>) {
        characters.map { CharacterCached(it) }
            .toTypedArray()
            .let { characterDao.saveCharacters(*it) }
    }
}
