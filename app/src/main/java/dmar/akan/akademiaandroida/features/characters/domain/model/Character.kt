package dmar.akan.akademiaandroida.features.characters.domain.model

import dmar.akan.akademiaandroida.features.data.remote.model.CharacterLocationRemote
import dmar.akan.akademiaandroida.features.data.remote.model.CharacterRemote

data class Character(
    val id: Int,
    val name: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: List<CharacterRemote.CharacterOriginRemote>,
    val location: List<CharacterLocationRemote>,
    val image: String,
    val episode: List<String>,
    val url: String
)
