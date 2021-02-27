package hr.novoDodavanje

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hr.dominik.nkjaki.R
import hr.viewModel.TablicaRezultatiViewModel
import kotlinx.coroutines.InternalCoroutinesApi

class DodajNovuTablicuFragment: Fragment() {

    @InternalCoroutinesApi
    private lateinit var mTablicaTablicaViewModel: TablicaRezultatiViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_nova_tablica,container, false)
    }

}