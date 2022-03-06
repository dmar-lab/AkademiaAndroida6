package dmar.akan.akademiaandroida.features.data.remote.model

import com.google.gson.annotations.SerializedName
import dmar.akan.akademiaandroida.features.episodes.domain.model.Episode

data class EpisodeRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("air_date") val airDate: String,
    @SerializedName("episode") val code: String,
    @SerializedName("characters") val characters: List<String>,
    @SerializedName("url") val url: String,
) {

    // mapping from EpisodeRemote to episode
    fun toEpisode() = Episode(
        id = id,
        name = name,
        airDate = airDate,
        code = code,
        characters = characters,
        url = url
    )
}
