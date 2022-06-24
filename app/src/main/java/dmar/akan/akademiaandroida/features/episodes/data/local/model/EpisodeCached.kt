package dmar.akan.akademiaandroida.features.episodes.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import dmar.akan.akademiaandroida.features.episodes.domain.model.Episode

@Entity
data class EpisodeCached(
    @PrimaryKey
    val id: Int,
    val name: String,
    val airDate: String,
    val code: String,
    val characters: List<String>, // list of links
    val url: String
) {
    //is used in EpisodeRepositoryImpl.saveEpisodesToLocal(episodes: List<Episode>)
    constructor(episode: Episode) : this(
        episode.id,
        episode.name,
        episode.airDate,
        episode.code,
        episode.characters,
        episode.url
    )

    companion object

    fun toEpisode() = Episode(
        id = id,
        name = name,
        airDate = airDate,
        code = code,
        characters = characters,
        url = url
    )
}
