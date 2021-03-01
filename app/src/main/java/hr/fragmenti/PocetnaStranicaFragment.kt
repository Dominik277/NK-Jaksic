package hr.fragmenti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.fragment_pocetna_stranica.view.*

class PocetnaStranicaFragment: Fragment(R.layout.fragment_pocetna_stranica) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pocetna_stranica,container,false)

        view.gumbPokus.setOnClickListener {
            findNavController().navigate(R.id.action_pocetnaStranicaFragment_to_rasporedFragment2)
        }

        return view
    }

}