package hr.fragmenti.novoDodavanje

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import hr.database.table.TablicaTablica
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.FragmentNovaTablicaBinding
import hr.viewModel.TablicaTablicaViewModel
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class DodajNovuTablicuFragment : Fragment(R.layout.fragment_nova_tablica) {

    @InternalCoroutinesApi
    private val mTablicaTablicaViewModel: TablicaTablicaViewModel by viewModels()
    private lateinit var binding: FragmentNovaTablicaBinding

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNovaTablicaBinding.bind(view)

        binding.gumbSpremiTablicu.setOnClickListener {
            val action =
                DodajNovuTablicuFragmentDirections.actionDodajNovuTablicuToTablicaTablicaFragment()
            findNavController().navigate(action)
            insertDataToDatabase()
        }
    }

    @InternalCoroutinesApi
    private fun insertDataToDatabase() {
        val novaTablicaPozcija = binding.novaTablicaPozcija.text.toString()
        val novaTablicaImeKluba = binding.novaTablicaImeKluba.text.toString()
        val novaTablicaOdigraniSusreti = binding.novaTablicaOdigraniSusreti.text.toString()
        val novaTablicaGolRazlika = binding.novaTablicaGolRazlika.text.toString()
        val novaTablicaBodovi = binding.novaTablicaBodovi.text.toString()

        val tablicaTablica = TablicaTablica(
            0, novaTablicaPozcija, novaTablicaImeKluba,
            novaTablicaOdigraniSusreti, novaTablicaGolRazlika, novaTablicaBodovi
        )
        mTablicaTablicaViewModel.addTablicaTablica(tablicaTablica)
        Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_LONG).show()
    }
}