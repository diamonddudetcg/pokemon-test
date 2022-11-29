package es.santirivera.pokemontest.fragment.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import es.santirivera.domain.usecase.Callback
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import es.santirivera.domain.model.PokemonDetail
import es.santirivera.pokemontest.R
import es.santirivera.pokemontest.databinding.FragmentItemDetailBinding
import es.santirivera.pokemontest.fragment.base.PokemonBottomSheetDialogFragment
import java.lang.Exception


@AndroidEntryPoint
class PokemonDetailFragment : PokemonBottomSheetDialogFragment(), Callback<PokemonDetail> {

    private var _binding: FragmentItemDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PokemonDetailViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemDetailBinding.inflate(inflater, container, false)
        val rootView = binding.root
        val url = PokemonDetailFragmentArgs.fromBundle(requireArguments()).url
        setProgressLayout(binding.progressLayout)
        startLoad()
        viewModel.loadPokemonDetail(url, this)
        return rootView
    }


    private fun updateContent(item:PokemonDetail) {
        binding.textViewPokemonName.text = item.name.replaceFirstChar { c: Char -> c.uppercaseChar() }

        var heightAsFloat = (item.height.toFloat() / 10)
        var weightAsFloat = (item.weight.toFloat() / 10)

        binding.textViewPokemonHeight.text = String.format("Height: %.2f m", heightAsFloat)
        binding.textViewPokemonWeight.text = String.format("Weight: %.2f kg", weightAsFloat)
        binding.textViewPokemonBaseExp.text = String.format("Base Exp: %d", item.baseExperience)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onSuccess(response: PokemonDetail) {
        endLoad()
        updateContent(response)
    }

    override fun onError(error: Exception) {
        endLoad()
        error.printStackTrace()
        Toast.makeText(context, R.string.error_no_internet, Toast.LENGTH_LONG).show()
    }
}