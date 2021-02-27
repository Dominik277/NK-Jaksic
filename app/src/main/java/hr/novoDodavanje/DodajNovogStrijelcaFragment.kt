package hr.novoDodavanje

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import hr.database.table.NajboljiStrijelci
import hr.dominik.nkjaki.R
import hr.viewModel.NajboljiStrijelciViewModel
import kotlinx.android.synthetic.main.fragment_novi_strijelac.*
import kotlinx.android.synthetic.main.fragment_novi_strijelac.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class DodajNovogStrijelcaFragment: Fragment() {

    @InternalCoroutinesApi
    private lateinit var mNajboljiStrijelacViewModel: NajboljiStrijelciViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view = inflater.inflate(R.layout.fragment_novi_strijelac,container, false)

        mNajboljiStrijelacViewModel = ViewModelProvider(this).get(NajboljiStrijelciViewModel::class.java)

        view.gumbSpremiNovogStrijelca.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    @InternalCoroutinesApi
    private fun insertDataToDatabase() {
        val noviStrijelacPozicija = noviStrijelacPozicija.text.toString()
        val noviStrijelacImePrezime = noviStrijelacImePrezime.text.toString()
        val noviStrijelacBrojGolova = noviStrijelacBrojGolova.text.toString()

        if (inputCheck(noviStrijelacPozicija,noviStrijelacImePrezime,noviStrijelacBrojGolova)){
            val najboljiStrijelac = NajboljiStrijelci(0,noviStrijelacPozicija,noviStrijelacImePrezime,noviStrijelacBrojGolova)
            mNajboljiStrijelacViewModel.addNajboljiStrijelac(najboljiStrijelac)
            Toast.makeText(requireContext(),"Successfully added", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(requireContext(),"Molimo unesite tekst u sva polja,", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(noviStrijelacPozicija: String,noviStrijelacImePrezime: String,noviStrijalacBrojGolova: String): Boolean{

        return !(TextUtils.isEmpty(noviStrijelacPozicija)
                && TextUtils.isEmpty(noviStrijelacImePrezime)
                && TextUtils.isEmpty(noviStrijalacBrojGolova))

    }
}