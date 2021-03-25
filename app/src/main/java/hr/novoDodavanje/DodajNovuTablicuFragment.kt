package hr.novoDodavanje

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import hr.database.table.TablicaTablica
import hr.dominik.nkjaki.R
import hr.viewModel.TablicaRezultatiViewModel
import hr.viewModel.TablicaTablicaViewModel
import kotlinx.android.synthetic.main.fragment_nova_tablica.*
import kotlinx.android.synthetic.main.fragment_nova_tablica.view.*
import kotlinx.android.synthetic.main.fragment_tablica.view.*
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class DodajNovuTablicuFragment: Fragment() {

    @InternalCoroutinesApi
    private val mTablicaTablicaViewModel: TablicaTablicaViewModel by viewModels()

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_nova_tablica,container, false)

        view.gumbSpremiTablicu.setOnClickListener {
            val action = DodajNovuTablicuFragmentDirections.actionDodajNovuTablicuToTablicaTablicaFragment()
            findNavController().navigate(action)
            insertDataToDatabase()
        }

        return view
    }

    @InternalCoroutinesApi
    private fun insertDataToDatabase() {
        val novaTablicaPozcija = novaTablicaPozcija.text.toString()
        val novaTablicaImeKluba = novaTablicaImeKluba.text.toString()
        val novaTablicaOdigraniSusreti = novaTablicaOdigraniSusreti.text.toString()
        val novaTablicaGolRazlika = novaTablicaGolRazlika.text.toString()
        val novaTablicaBodovi = novaTablicaBodovi.text.toString()

            val tablicaTablica = TablicaTablica(0,novaTablicaPozcija,novaTablicaImeKluba,
                novaTablicaOdigraniSusreti,novaTablicaGolRazlika,novaTablicaBodovi)
            mTablicaTablicaViewModel.addTablicaTablica(tablicaTablica)
            Toast.makeText(requireContext(),"Successfully added", Toast.LENGTH_LONG).show()
    }
}