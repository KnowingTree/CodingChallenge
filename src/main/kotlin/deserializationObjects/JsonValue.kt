package deserializationObjects

import kotlinx.serialization.Serializable

@Serializable
data class ExternalValue(
    val element_id: Int,
    val value: Double
)
