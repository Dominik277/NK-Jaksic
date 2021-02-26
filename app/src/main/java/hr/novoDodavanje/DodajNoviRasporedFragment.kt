package hr.novoDodavanje

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import hr.database.table.Raspored
import hr.dominik.nkjaki.R
import hr.viewModel.RasporedViewModel
import kotlinx.android.synthetic.main.fragment_novi_raspored.*
import kotlinx.android.synthetic.main.fragment_novi_raspored.view.*
import kotlinx.android.synthetic.main.fragment_novi_rezultat.*
import kotlinx.coroutines.InternalCoroutinesApi

class DodajNoviRasporedFragment: Fragment(R.layout.fragment_novi_raspored) {

    @InternalCoroutinesApi
    private lateinit var mRasporedViewModel: RasporedViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_novi_raspored,container, false)

        mRasporedViewModel = ViewModelProvider(this).get(RasporedViewModel::class.java)

        view.gumbSpremiNoviRaspored.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    @InternalCoroutinesApi
    private fun insertDataToDatabase() {
        val noviRasporedNatjecanje = noviRasporedNatjecanje.text.toString()
        val noviRasporedDatum = noviRasporedDatum.text.toString()
        val noviRasporedDomacin = noviRasporedDomacin.text.toString()
        val noviRasporedGost = noviRasporedGost.text.toString()
        val noviRasporedVrijeme = noviRasporedVrijeme.text.toString()

        if (inputCheck(noviRasporedNatjecanje,noviRasporedDatum,noviRasporedDomacin,noviRasporedGost,noviRasporedVrijeme)){
            //Create object
            val raspored = Raspored(0,noviRasporedNatjecanje,noviRasporedDatum,noviRasporedDomacin,noviRasporedGost,noviRasporedVrijeme)
            mRasporedViewModel.addRaspored(raspored)
            Toast.makeText(requireContext(),"Successfully added",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(requireContext(),"Molimo unesite tekst u sva polja,",Toast.LENGTH_LONG).show()
        }

    }

    private fun inputCheck(noviRasporedNatjecanje: String, noviRasporedDatum: String, noviRasporedDomacin: String, noviRasporedGost: String, noviRasporedVrijeme: String): Boolean{
        return !(TextUtils.isEmpty(noviRasporedNatjecanje)
                && TextUtils.isEmpty(noviRasporedDatum)
                && TextUtils.isEmpty(noviRasporedDomacin)
                && TextUtils.isEmpty(noviRasporedGost)
                && TextUtils.isEmpty(noviRasporedVrijeme))
    }

}