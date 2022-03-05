package dmar.akan.akademiaandroida.features.episodes.domain.model

// no annotations here !!
data class Episode(
    val id: Int,
    val name: String,
    val airDate: String,
    val code: String,
    val characters: List<String>,
    val url: String
)
