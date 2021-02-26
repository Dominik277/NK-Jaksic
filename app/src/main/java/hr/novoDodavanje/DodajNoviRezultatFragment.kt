package hr.novoDodavanje

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import hr.database.table.Rezultat
import hr.dominik.nkjaki.R
import hr.viewModel.RezultatViewModel
import kotlinx.android.synthetic.main.fragment_novi_rezultat.*
import kotlinx.android.synthetic.main.fragment_novi_rezultat.view.*

class DodajNoviRezultatFragment: Fragment() {

    private lateinit var mRezultatiViewModel: RezultatViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_novi_rezultat, container, false)

        mRezultatiViewModel = ViewModelProvider(this).get(RezultatViewModel::class.java)

        view.gumbSpremiNoviRezultat.setOnClickListener {
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase() {
        val noviRezultatNatjecanje = noviRezultatNatjecanje.text.toString()
        val noviRezultatDatum = noviRezultatDatum.text.toString()
        val noviRezultatDomacin = noviRezultatDomacin.text.toString()
        val noviRezultatGost = noviRezultatGost.text.toString()
        val noviRezultatRezultat = noviRezultatRezultat.text.toString()
        val noviRezultatIshod = noviRezultatIshod.text.toString()

        if (inputCheck(noviRezultatNatjecanje,noviRezultatDatum,noviRezultatDomacin,noviRezultatGost,noviRezultatRezultat,noviRezultatIshod)){
            //Create object
            val rezultat = Rezultat(0,noviRezultatNatjecanje,noviRezultatDatum,noviRezultatDomacin,noviRezultatGost,noviRezultatRezultat,noviRezultatIshod)
            mRezultatiViewModel.addRezultat(rezultat)
            Toast.makeText(requireContext(),"Successfully added", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(requireContext(),"Molimo unesite tekst u sva polja,",Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(noviRezultatNatjecanje: String,noviRezultatDatum: String,noviRezultatDomacin: String,noviRezultatGost: String,noviRezultatRezultat: String,noviRezultatIshod: String): Boolean{
        return !(TextUtils.isEmpty(noviRezultatNatjecanje)
                && TextUtils.isEmpty(noviRezultatDatum)
                && TextUtils.isEmpty(noviRezultatDomacin)
                && TextUtils.isEmpty(noviRezultatGost)
                && TextUtils.isEmpty(noviRezultatRezultat)
                && TextUtils.isEmpty(noviRezultatIshod))

    }
}