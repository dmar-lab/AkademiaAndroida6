package dmar.akan.akademiaandroida.core.api.model

import com.google.gson.annotations.SerializedName

data class EpisodeResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val results: List<EpisodeRemote>
)
