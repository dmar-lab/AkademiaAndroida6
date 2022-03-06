package dmar.akan.akademiaandroida.features.characters.domain.model

data class Character(
    val id: Int,
    val name: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: List<String>,
    val location: List<String>,
    val image: String,
    val episode: List<String>,
    val url: String
)
