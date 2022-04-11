package dmar.akan.akademiaandroida.features.locations.domain

import dmar.akan.akademiaandroida.core.base.UseCase
import dmar.akan.akademiaandroida.features.locations.domain.model.Location

class GetLocationsUseCase(private val locationRepository: LocationRepository) :
    UseCase<List<Location>, Unit>() {

    override suspend fun action(params: Unit) = locationRepository.getLocations()
}
