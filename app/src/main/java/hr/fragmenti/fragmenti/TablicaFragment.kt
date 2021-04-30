package hr.fragmenti.fragmenti

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.FragmentTablicaBinding

@AndroidEntryPoint
class TablicaFragment : Fragment(R.layout.fragment_tablica) {

    private lateinit var binding: FragmentTablicaBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTablicaBinding.bind(view)

    }
}