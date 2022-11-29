package es.santirivera.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonListItem(
    val name: String,
    val url: String
) : Parcelable {

    override fun equals(other: Any?): Boolean {
        if (other is PokemonListItem) {
            return other.name == name
        }
        return false
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + url.hashCode()
        return result
    }
}