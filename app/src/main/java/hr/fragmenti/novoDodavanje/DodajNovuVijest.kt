package hr.fragmenti.novoDodavanje

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import hr.database.table.Vijesti
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.FragmentNovaVijestBinding
import hr.viewModel.VijestiViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class DodajNovuVijest : Fragment(R.layout.fragment_nova_vijest) {

    @InternalCoroutinesApi
    private val mVijestiViewModel: VijestiViewModel by viewModels()
    private lateinit var binding: FragmentNovaVijestBinding

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNovaVijestBinding.bind(view)

        binding.novaVijestGumbSpremi.setOnClickListener {
            val action = DodajNovuVijestDirections.actionDodajNovuVijest2ToVijestiFragment()
            findNavController().navigate(action)
            insertDataToDatabase()
        }
    }

    @InternalCoroutinesApi
    private fun insertDataToDatabase() {
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        val noviNaslov = binding.novaVijestNaslov.text.toString()
        val novoVrijeme = currentDate
        val noviClanak = binding.novaVijestClanak.text.toString()
        val novaSlika = R.drawable.jaksic

        val vijest = Vijesti(0, noviNaslov, noviClanak, novoVrijeme, novaSlika)
        mVijestiViewModel.addVijesti(vijest)
    }
}
