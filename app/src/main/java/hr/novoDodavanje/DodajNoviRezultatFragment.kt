package hr.novoDodavanje

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import hr.database.table.Rezultat
import hr.dominik.nkjaki.R
import hr.viewModel.RezultatViewModel
import kotlinx.android.synthetic.main.fragment_novi_rezultat.*
import kotlinx.android.synthetic.main.fragment_novi_rezultat.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class DodajNoviRezultatFragment: Fragment() {

    @InternalCoroutinesApi
    private lateinit var mRezultatiViewModel: RezultatViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_novi_rezultat, container, false)

        mRezultatiViewModel = ViewModelProvider(this).get(RezultatViewModel::class.java)

        view.gumbSpremiNoviRezultat.setOnClickListener {
            val action = DodajNoviRezultatFragmentDirections.actionDodajNoviRezultatFragmentToRezultatiFragment()
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