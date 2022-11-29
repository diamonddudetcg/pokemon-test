package es.santirivera.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonDetail(
    val weight: Int,
    val height: Int,
    val baseExperience: Int,
    val name: String,
) : Parcelable {

    override fun equals(other: Any?): Boolean {
        if (other is PokemonDetail) {
            return other.name == name
        }
        return false
    }

    override fun hashCode(): Int {
        var result = weight
        result = 31 * result + height
        result = 31 * result + baseExperience
        result = 31 * result + name.hashCode()
        return result
    }
}