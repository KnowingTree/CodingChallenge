package deserializationObjects

import kotlinx.serialization.Serializable

@Serializable
data class JsonValue(
    val element_id: Int,
    val value: Double
)
