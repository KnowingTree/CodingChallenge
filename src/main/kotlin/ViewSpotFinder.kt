import domain.Element
import domain.ViewSpot

class ViewSpotFinder(
    val elements: List<Element>
) {
    fun findViewSpots(numberOfViewSpots: Int) : List<ViewSpot> {
        val sharedNodes: MutableSet<Int> = mutableSetOf()
        val viewSpots: MutableList<ViewSpot> = mutableListOf()

        elements.forEach { element ->
            if (viewSpots.size < numberOfViewSpots) {
                if (!sharedNodes.any { it in element.nodes }) {
                    viewSpots.plusAssign(ViewSpot(element.id, element.height))
                }
                sharedNodes.plusAssign(element.nodes)
            }
        }
        println("searching for viewPoints finished")

        return viewSpots
    }
}