package es.santirivera.pokemontest.fragment.base

import android.app.Dialog
import android.view.Window
import androidx.fragment.app.Fragment
import es.santirivera.pokemontest.R

abstract class PokemonFragment : Fragment(), LoadableFragment {

    private var loading = false

    private lateinit var dialog: Dialog

    override fun startLoad() {
        if (!loading) {
            dialog = createDialog()
            dialog.show()
            loading = true
        }
    }

    override fun endLoad() {
        if (loading) {
            dialog.hide()
            loading = false
        }
    }

    private fun createDialog(): Dialog {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.progress_dialog)
        return dialog
    }

}