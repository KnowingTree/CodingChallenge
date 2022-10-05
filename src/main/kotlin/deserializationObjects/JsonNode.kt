package deserializationObjects

import kotlinx.serialization.Serializable

@Serializable
data class ExternalNode(
    val id: Int,
    val x: Float,
    val y: Float
)