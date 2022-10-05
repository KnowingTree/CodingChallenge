package domain

import deserializationObjects.JsonElement
import deserializationObjects.JsonValue

data class Element(
    var id: Int,
    var nodes: List<Int>,
    var height: Double
)
