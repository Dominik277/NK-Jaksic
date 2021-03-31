package hr.fragmenti.novoDodavanje

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import hr.database.table.Rezultat
import hr.dominik.nkjaki.R
import hr.fragmenti.novoDodavanje.DodajNoviRezultatFragmentDirections
import hr.viewModel.RezultatViewModel
import kotlinx.android.synthetic.main.fragment_novi_rezultat.*
import kotlinx.android.synthetic.main.fragment_novi_rezultat.view.*
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class DodajNoviRezultatFragment: Fragment() {

    @InternalCoroutinesApi
    private val mRezultatiViewModel: RezultatViewModel by viewModels()

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_novi_rezultat, container, false)

        view.gumbSpremiNoviRezultat.setOnClickListener {
            val action =
                DodajNoviRezultatFragmentDirections.actionDodajNoviRezultatFragmentToRezultatiFragment()
            findNavController().navigate(action)
            insertDataToDatabase()
        }
        return view
    }

    @InternalCoroutinesApi
    private fun insertDataToDatabase() {
        val noviRezultatNatjecanje = noviRezultatNatjecanje.text.toString()
        val noviRezultatDatum = noviRezultatDatum.text.toString()
        val noviRezultatDomacin = noviRezultatDomacin.text.toString()
        val noviRezultatGost = noviRezultatGost.text.toString()
        val noviRezultatRezultat = noviRezultatRezultat.text.toString()
        val noviRezultatIshod = noviRezultatIshod.text.toString()
        val noviRezultatPostave = noviRezultatPostave.text.toString()
        val noviRezultatDetalji = noviRezultatDetalji.text.toString()
        val noviRezultatClanak = noviRezultatClanak.text.toString()

            //Create object
            val rezultat = Rezultat(0,noviRezultatNatjecanje,noviRezultatDatum,
                noviRezultatDomacin,noviRezultatGost,noviRezultatRezultat,noviRezultatIshod,noviRezultatPostave,
                noviRezultatDetalji,noviRezultatClanak)
            mRezultatiViewModel.addRezultat(rezultat)
            Toast.makeText(requireContext(),"Successfully added", Toast.LENGTH_LONG).show()

    }
}