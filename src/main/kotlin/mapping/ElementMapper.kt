package mapping

import deserializationObjects.JsonElement
import deserializationObjects.JsonValue
import domain.Element

class ElementMapper {
    fun mapToElement(jsonElement: JsonElement, jsonValue: JsonValue) : Element {
        return Element(id = jsonElement.id, nodes = jsonElement.nodes, height = jsonValue.value)
    }

    fun mapToListOfElements(elementsList: List<JsonElement>, valuesList: List<JsonValue>) : List<Element> {
        val jsonElementsMap = elementsList.associateBy { it.id }
        val jsonValuesMap = valuesList.associateBy { it.element_id }

        val elements = mutableListOf<Element>()
        jsonElementsMap.forEach { jsonElement ->
            val jsonValue = jsonValuesMap[jsonElement.key]!!
            elements.plusAssign(mapToElement(jsonElement.value, jsonValue))
        }

        return elements
    }
}