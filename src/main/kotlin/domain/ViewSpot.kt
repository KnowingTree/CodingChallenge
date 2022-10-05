package domain

import kotlinx.serialization.Serializable

@Serializable
data class ViewSpot(
    val element_id: Int,
    val value: Double
)
