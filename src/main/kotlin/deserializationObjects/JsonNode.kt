package deserializationObjects

import kotlinx.serialization.Serializable

@Serializable
data class JsonNode(
    val id: Int,
    val x: Float,
    val y: Float
)