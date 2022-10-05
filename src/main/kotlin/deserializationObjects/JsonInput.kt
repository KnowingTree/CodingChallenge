package deserializationObjects

import kotlinx.serialization.Serializable

@Serializable
data class InputJson(
    val nodes: List<ExternalNode>,
    val elements: List<ExternalElement>,
    val values: List<ExternalValue>
)
