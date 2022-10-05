package deserializationObjects

import kotlinx.serialization.Serializable

@Serializable
data class ExternalElement(
    val id: Int,
    val nodes: List<Int>
)
