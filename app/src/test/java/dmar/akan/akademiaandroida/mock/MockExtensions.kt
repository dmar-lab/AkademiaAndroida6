package dmar.akan.akademiaandroida.mock

import dmar.akan.akademiaandroida.core.api.model.*
import dmar.akan.akademiaandroida.features.characters.data.local.model.CharacterCached
import dmar.akan.akademiaandroida.features.characters.data.local.model.CharacterLocationCached
import dmar.akan.akademiaandroida.features.characters.data.local.model.CharacterOriginCached
import dmar.akan.akademiaandroida.features.episodes.data.local.model.EpisodeCached
import dmar.akan.akademiaandroida.features.locations.data.local.model.LocationCached
import org.jetbrains.annotations.TestOnly

@TestOnly
fun ResponseInfo.Companion.mock() = ResponseInfo(
    count = 10,
    pages = 3,
    next = "next page url",
    prev = "previous page url"
)

@TestOnly
fun EpisodeRemote.Companion.mock() = EpisodeRemote(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url",
//    created = "example data"
)

@TestOnly
fun EpisodeResponse.Companion.mock() = EpisodeResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        EpisodeRemote.mock(),
        EpisodeRemote.mock(),
        EpisodeRemote.mock()
    )
)

@TestOnly
fun EpisodeCached.Companion.mock() = EpisodeCached(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url"
)
/* ------------------------------------------------------ */
@TestOnly
fun LocationRemote.Companion.mock() = LocationRemote(
    id = 1,
    name = "location name",
    type = "location type",
    dimension = "location dimension",
    residents = emptyList(),
    url = "location url"
)

@TestOnly
fun LocationResponse.Companion.mock() = LocationResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        LocationRemote.mock(),
        LocationRemote.mock(),
        LocationRemote.mock()
    )
)

@TestOnly
fun LocationCached.Companion.mock() = LocationCached(
    id = 1,
    name = "location name",
    type = "location type",
    dimension = "location dimension",
    residents = emptyList(),
    url = "location url"
)

/* ------------------------------------------------------ */

@TestOnly
fun CharacterRemote.Companion.mock() = CharacterRemote(
    id = 1,
    name = "character name",
    species = "character species",
    type = "character type",
    gender = "character gender",
    origin = CharacterRemote.CharacterOriginRemote(
        "character origin name",
        "character origin url"
    ),
    location = CharacterRemote.CharacterLocationRemote(
        "character location name",
        "character location url"
    ),
    image = "character image",
    episode = emptyList(),
    url = "character url"
)

/*
@TestOnly
fun CharacterRemote.CharacterLocationRemote.Companion.mock() = CharacterLocationRemote(
    name = "location character name",
    url = "location character url"
)
*/
@TestOnly
fun CharacterResponse.Companion.mock() = CharacterResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        CharacterRemote.mock(),
        CharacterRemote.mock(),
        CharacterRemote.mock()
    )
)

@TestOnly
fun CharacterCached.Companion.mock() = CharacterCached(
    id = 1,
    name = "character name",
    species = "character species",
    type = "character type",
    gender = "character gender",
    origin = CharacterOriginCached(
        "character origin cached name",
        "character origin cached url"
    ),
    location = CharacterLocationCached(
        "character location cached name",
        "character location cached url"
    ),
    image = "character image",
    episode = emptyList(),
    url = "character url"
)

/*
@TestOnly
fun LocationCharacterCached.Companion.mock() = LocationCharacterCached(
    name = "location character name",
    url = "location character url",
)
*/
