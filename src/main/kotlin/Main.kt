
import deserializationObjects.JsonInput
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import mapping.ElementMapper

import java.io.File

fun main(args: Array<String>) {
    val output = Output()
    val validation = Validation(output)

    val pathToFile = validation.validateIfFileIsPresent(args[0])
    val numberOfViewSpots = validation.transformAndValidateViewSpotParameter(args[1])

    println("Starting to search for up to $numberOfViewSpots viewPoints in $pathToFile")

    val jsonString = File(pathToFile).readText(Charsets.UTF_8)
    val jsonInput = Json.decodeFromString<JsonInput>(jsonString)
    val jsonValues = jsonInput.values
    val jsonElements = jsonInput.elements

    val elements = ElementMapper().mapToListOfElements(jsonElements, jsonValues).sortedByDescending { it.height }
    val viewSpotFinder = ViewSpotFinder(elements)
    val viewSpots = viewSpotFinder.findViewSpots(numberOfViewSpots)

    val outputString = Json.encodeToString(viewSpots)
    output.writeResultToOutput(outputString)
}