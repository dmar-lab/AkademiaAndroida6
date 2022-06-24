package dmar.akan.akademiaandroida.features.characters.data.repository

import dmar.akan.akademiaandroida.core.api.RickAndMortyApi
import dmar.akan.akademiaandroida.core.network.NetworkStateProvider
import dmar.akan.akademiaandroida.features.characters.data.local.CharacterDao
import dmar.akan.akademiaandroida.features.characters.data.local.model.CharacterCached
import dmar.akan.akademiaandroida.features.characters.domain.CharacterRepository
import dmar.akan.akademiaandroida.features.characters.domain.model.Character

class CharacterRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val characterDao: CharacterDao,
    private val networkStateProvider: NetworkStateProvider
) : CharacterRepository {

    override suspend fun getCharacters(): List<Character> {
        return if (networkStateProvider.isNetworkAvailable()) {
            getCharactersFromRemote()
                .also { saveCharactersToLocal(it) }
        } else {
//            POZOR!! here - what happens if database not exists??
            getCharactersFromLocal()
        }
    }

    private suspend fun getCharactersFromRemote(): List<Character> {
        return rickAndMortyApi.getCharacter()
            .results
            .map { it.toCharacter() }
//            .also { saveCharactersToLocal(it) }
    }

    private suspend fun saveCharactersToLocal(characters: List<Character>) {
        characters.map { CharacterCached(it) }
            .toTypedArray()
            .let { characterDao.saveCharacters(*it) }
    }

    private suspend fun getCharactersFromLocal(): List<Character> {
        return characterDao.getCharacters()
            .map { it.toCharacter() }
    }
}
