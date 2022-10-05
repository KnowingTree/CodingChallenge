package deserializationObjects

import kotlinx.serialization.Serializable

@Serializable
data class JsonInput(
    val nodes: List<JsonNode>,
    val elements: List<JsonElement>,
    val values: List<JsonValue>
)
