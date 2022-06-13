package dmar.akan.akademiaandroida.features.characters.data.repository

import dmar.akan.akademiaandroida.core.api.RickAndMortyApi
import dmar.akan.akademiaandroida.core.api.model.CharacterResponse
import dmar.akan.akademiaandroida.core.network.NetworkStateProvider
import dmar.akan.akademiaandroida.features.characters.data.local.CharacterDao
import dmar.akan.akademiaandroida.features.characters.domain.CharacterRepository
import dmar.akan.akademiaandroida.mock.mock
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

internal class CharacterRepositoryImplTest {

    @Test
    fun `GIVEN network is connected WHEN characters request THEN fetch characters from API`() {
        //given
        val api = mockk<RickAndMortyApi>() {
            coEvery { getCharacter() } returns CharacterResponse.mock()
        }
        val characterDao = mockk<CharacterDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }
        val repository: CharacterRepository =
            CharacterRepositoryImpl(api, characterDao, networkStateProvider)

        //when
        runBlocking { repository.getCharacters() }

        //then
        coVerify { api.getCharacter() }
    }
}
