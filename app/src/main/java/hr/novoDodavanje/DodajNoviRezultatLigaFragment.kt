package hr.novoDodavanje

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import hr.dominik.nkjaki.R
import hr.viewModel.TablicaRasporedViewModel
import hr.viewModel.TablicaRezultatiViewModel
import kotlinx.android.synthetic.main.fragment_novi_rezultati_liga.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class DodajNoviRezultatLigaFragment: Fragment() {

    @InternalCoroutinesApi
    private lateinit var mTablicaRezultatViewModel: TablicaRezultatiViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_novi_rezultati_liga,container, false)

        mTablicaRezultatViewModel = ViewModelProvider(this).get(TablicaRezultatiViewModel::class.java)

        view.gumbSpremiTablicaRezultat.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {

    }

    private fun inputCheck(): Boolean{

    }

}