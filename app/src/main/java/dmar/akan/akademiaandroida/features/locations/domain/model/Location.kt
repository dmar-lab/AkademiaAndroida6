package dmar.akan.akademiaandroida.features.locations.domain.model

// no annotations here please
data class Location(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String
)
