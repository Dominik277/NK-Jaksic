package hr.fragmenti.novoDodavanje

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import hr.database.table.Rezultat
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.FragmentNoviRezultatBinding
import hr.viewModel.RezultatViewModel
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class DodajNoviRezultatFragment : Fragment(R.layout.fragment_novi_rezultat) {

    @InternalCoroutinesApi
    private val mRezultatiViewModel: RezultatViewModel by viewModels()
    private lateinit var binding: FragmentNoviRezultatBinding

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNoviRezultatBinding.bind(view)

        binding.gumbSpremiNoviRezultat.setOnClickListener {
            val action =
                DodajNoviRezultatFragmentDirections.actionDodajNoviRezultatFragmentToRezultatiFragment()
            findNavController().navigate(action)
            insertDataToDatabase()
        }
    }

    @InternalCoroutinesApi
    private fun insertDataToDatabase() {
        val noviRezultatNatjecanje = binding.noviRezultatNatjecanje.text.toString()
        val noviRezultatDatum = binding.noviRezultatDatum.text.toString()
        val noviRezultatDomacin = binding.noviRezultatDomacin.text.toString()
        val noviRezultatGost = binding.noviRezultatGost.text.toString()
        val noviRezultatRezultat = binding.noviRezultatRezultat.text.toString()
        val noviRezultatPostave = binding.noviRezultatPostave.text.toString()
        val noviRezultatDetalji = binding.noviRezultatDetalji.text.toString()
        val noviRezultatClanak = binding.noviRezultatClanak.text.toString()

        //Create object
        val rezultat = Rezultat(
            0,
            noviRezultatNatjecanje,
            noviRezultatDatum,
            noviRezultatDomacin,
            noviRezultatGost,
            noviRezultatRezultat,
            noviRezultatPostave,
            noviRezultatDetalji,
            noviRezultatClanak
        )
        mRezultatiViewModel.addRezultat(rezultat)
        Toast.makeText(requireContext(), "Uspješno dodano!", Toast.LENGTH_LONG).show()

    }
}