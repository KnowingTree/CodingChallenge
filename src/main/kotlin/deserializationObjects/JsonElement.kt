package deserializationObjects

import kotlinx.serialization.Serializable

@Serializable
data class JsonElement(
    val id: Int,
    val nodes: List<Int>
)
