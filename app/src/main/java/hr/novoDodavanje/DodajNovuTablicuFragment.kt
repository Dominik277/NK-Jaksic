package hr.novoDodavanje

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import hr.database.table.TablicaTablica
import hr.dominik.nkjaki.R
import hr.viewModel.TablicaRezultatiViewModel
import hr.viewModel.TablicaTablicaViewModel
import kotlinx.android.synthetic.main.fragment_nova_tablica.*
import kotlinx.android.synthetic.main.fragment_nova_tablica.view.*
import kotlinx.android.synthetic.main.fragment_tablica.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class DodajNovuTablicuFragment: Fragment() {

    @InternalCoroutinesApi
    private lateinit var mTablicaTablicaViewModel: TablicaTablicaViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_nova_tablica,container, false)

        mTablicaTablicaViewModel = ViewModelProvider(this).get(TablicaTablicaViewModel::class.java)

        view.gumbSpremiTablicu.setOnClickListener {
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

        if (inputCheck(novaTablicaPozcija,novaTablicaImeKluba,novaTablicaOdigraniSusreti,novaTablicaGolRazlika,novaTablicaBodovi)){
            //Create object
            val tablicaTablica = TablicaTablica(0,novaTablicaPozcija,novaTablicaImeKluba,novaTablicaOdigraniSusreti,novaTablicaGolRazlika,novaTablicaBodovi)
            mTablicaTablicaViewModel.addTablicaTablica(tablicaTablica)
            Toast.makeText(requireContext(),"Successfully added", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(requireContext(),"Molimo unesite tekst u sva polja,", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(novaTablicaPozicija: String, novaTablicaImeKluba: String, novaTablicaOdigraniSusreti: String,novaTablicaGolRazlika: String,novaTablicaBodovi: String): Boolean{
        return !(TextUtils.isEmpty(novaTablicaPozicija)
                && TextUtils.isEmpty(novaTablicaImeKluba)
                && TextUtils.isEmpty(novaTablicaOdigraniSusreti)
                && TextUtils.isEmpty(novaTablicaGolRazlika)
                && TextUtils.isEmpty(novaTablicaBodovi))
    }

}