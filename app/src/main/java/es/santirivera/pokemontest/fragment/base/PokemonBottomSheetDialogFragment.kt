package es.santirivera.pokemontest.fragment.base

import android.view.View
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class PokemonBottomSheetDialogFragment : BottomSheetDialogFragment(),LoadableFragment {

    private var loading = false

    private lateinit var progressLayout: View

    protected fun setProgressLayout(view:View){
        this.progressLayout = view
    }

    override fun startLoad() {
        loading = true
        if (this::progressLayout.isInitialized){
            progressLayout.visibility = View.VISIBLE
        }
    }

    override fun endLoad() {
        loading = false
        if (this::progressLayout.isInitialized){
            progressLayout.visibility = View.GONE
        }
    }
}