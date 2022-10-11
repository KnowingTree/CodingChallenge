import java.io.File
import kotlin.system.exitProcess

class Validation(
    private val output: Output
) {
    fun transformAndValidateViewSpotParameter(numberOfViewSpots: String): Int {
        return try {
            numberOfViewSpots.toInt()
        } catch (e: NumberFormatException) {
            e.message?.let { output.writeErrors(it) }
            System.err.println("'$numberOfViewSpots' could not be transformed to an integer")
            exitProcess(1)
        }
    }

    /**
     * Checks, if [pathToFile] exists and gives back the exact same path, if it does.
     * Should [pathToFile] not exist, this function writes an error message to an output and exists the process.
     */
    fun validateIfFileIsPresent(pathToFile: String): String {
        if (File(pathToFile).isFile) return pathToFile
        else {
            output.writeErrors("$pathToFile doesn't exist or isn't a file")
            System.err.println("existence of $pathToFile cannot be validated")
            exitProcess(1)
        }
    }
}