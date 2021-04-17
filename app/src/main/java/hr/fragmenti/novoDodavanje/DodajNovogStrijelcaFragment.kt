package hr.fragmenti.novoDodavanje

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import hr.database.table.NajboljiStrijelci
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.FragmentNoviStrijelacBinding
import hr.viewModel.NajboljiStrijelciViewModel
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class DodajNovogStrijelcaFragment : Fragment(R.layout.fragment_novi_strijelac) {

    @InternalCoroutinesApi
    private val mNajboljiStrijelacViewModel: NajboljiStrijelciViewModel by viewModels()
    private lateinit var binding: FragmentNoviStrijelacBinding

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNoviStrijelacBinding.bind(view)

        binding.gumbSpremiNovogStrijelca.setOnClickListener {
            val action =
                DodajNovogStrijelcaFragmentDirections.actionDodajNovogStrijelcaFragmentToNajboljiStrijelciFragment()
            findNavController().navigate(action)
            insertDataToDatabase()
        }
    }

    @InternalCoroutinesApi
    private fun insertDataToDatabase() {
        val noviStrijelacPozicija = binding.noviStrijelacPozicija.text.toString()
        val noviStrijelacImePrezime = binding.noviStrijelacImePrezime.text.toString()
        val noviStrijelacBrojGolova = binding.noviStrijelacBrojGolova.text.toString()

        val najboljiStrijelac = NajboljiStrijelci(
            0,
            noviStrijelacPozicija,
            noviStrijelacImePrezime,
            noviStrijelacBrojGolova
        )
        mNajboljiStrijelacViewModel.addNajboljiStrijelac(najboljiStrijelac)
        Toast.makeText(requireContext(), "Uspješno dodano!", Toast.LENGTH_LONG).show()
    }
}