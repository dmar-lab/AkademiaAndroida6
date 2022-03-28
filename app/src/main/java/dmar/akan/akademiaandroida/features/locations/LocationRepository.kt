package dmar.akan.akademiaandroida.features.locations

import dmar.akan.akademiaandroida.features.locations.domain.model.Location

interface LocationRepository {
    suspend fun getLocations(): List<Location>
}
