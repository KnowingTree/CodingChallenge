import java.io.File

class Output {
    init {
        if(File("./outputs/").mkdir())
            println("outputs directory has been created")
        else { println("outputs directory already exists") }
    }

    fun writeResultToOutput(outputString: String) {
        File("./outputs/Output.json").writeText(outputString)
    }

    fun writeErrors(outputString: String) {
        File("./outputs/Errors.log").writeText(outputString)
    }
}