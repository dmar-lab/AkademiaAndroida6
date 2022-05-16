package dmar.akan.akademiaandroida.features.locations.data.repository

import dmar.akan.akademiaandroida.core.api.RickAndMortyApi
import dmar.akan.akademiaandroida.features.locations.data.local.LocationDao
import dmar.akan.akademiaandroida.features.locations.data.local.model.LocationCached
import dmar.akan.akademiaandroida.features.locations.domain.LocationRepository
import dmar.akan.akademiaandroida.features.locations.domain.model.Location

class LocationRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val locationDao: LocationDao
) : LocationRepository {

    override suspend fun getLocations(): List<Location> {
        return rickAndMortyApi.getLocation()
            .results
            .map { it.toLocation() }
            .also { saveLocations(it) }
    }

    private suspend fun saveLocations(locations: List<Location>) {
        locations.map { LocationCached(it) }
            .toTypedArray()
            .let { locationDao.saveLocations(*it) }
    }
}
