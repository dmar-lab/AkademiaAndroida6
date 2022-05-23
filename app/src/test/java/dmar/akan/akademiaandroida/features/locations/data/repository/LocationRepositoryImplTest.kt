package dmar.akan.akademiaandroida.features.locations.data.repository

import dmar.akan.akademiaandroida.core.api.RickAndMortyApi
import dmar.akan.akademiaandroida.core.api.model.LocationResponse
import dmar.akan.akademiaandroida.core.network.NetworkStateProvider
import dmar.akan.akademiaandroida.features.locations.data.local.LocationDao
import dmar.akan.akademiaandroida.features.locations.data.local.model.LocationCached
import dmar.akan.akademiaandroida.features.locations.domain.LocationRepository
import dmar.akan.akademiaandroida.mock.mock
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

internal class LocationRepositoryImplTest {

    @Test
    fun `GIVEN network is connected WHEN locations request THEN fetch locations from API`() {
        //given
        val api = mockk<RickAndMortyApi> {
            coEvery { getLocation() } returns LocationResponse.mock()
        }
        val locationDao = mockk<LocationDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }
        val repository: LocationRepository =
            LocationRepositoryImpl(api, locationDao, networkStateProvider)

        //when
        runBlocking { repository.getLocations() }

        //then
        coVerify { api.getLocation() }
    }

    @Test
    fun `GIVEN network is connected AND successful data fetch WHEN location request THEN save locations to local database`() {
        //given
        val api = mockk<RickAndMortyApi> {
            coEvery { getLocation() } returns LocationResponse.mock()
        }
        val locationDao = mockk<LocationDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }
        val repository: LocationRepository =
            LocationRepositoryImpl(api, locationDao, networkStateProvider)

        //when
        runBlocking { repository.getLocations() }

        //then
        coVerify { locationDao.saveLocations(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is disconnected WHEN locations request THEN fetch locations from local database`() {
        //given
        val api = mockk<RickAndMortyApi>(relaxed = true)
        val locationDao = mockk<LocationDao> {
            coEvery { getLocations() } returns listOf(LocationCached.mock(), LocationCached.mock())
        }
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns false
        }
        val repository: LocationRepository =
            LocationRepositoryImpl(api, locationDao, networkStateProvider)

        //when
        runBlocking { repository.getLocations() }

        //then
        coVerify { locationDao.getLocations() }
    }
}
