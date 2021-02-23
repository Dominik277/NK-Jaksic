package hr.fragmenti

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.fragment_tablica.*

class TablicaFragment: Fragment(R.layout.fragment_tablica) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tablicaTablicaFragment = TablicaTablicaFragment()
        val strijelciFragment = NajboljiStrijelciFragment()
        val tablicaRezultatiFragment = TablicaRezultatiFragment()
        val tablicaRasporedFragment = TablicaRasporedFragment()
        val noviRezultatiFragment = NoviRezultatiFragment()

        childFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayoutTablica, tablicaTablicaFragment)
            commit()
        }

        gumbTablica.setOnClickListener {
            childFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayoutTablica, tablicaTablicaFragment)
                addToBackStack(null)
                commit()
            }
        }

        gumbNajboljiStrijelci.setOnClickListener {
            childFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayoutTablica, strijelciFragment)
                addToBackStack(null)
                commit()
            }
        }

        gumbRaspored.setOnClickListener {
            childFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayoutTablica, tablicaRasporedFragment)
                addToBackStack(null)
                commit()
            }
        }

        gumbRezultati.setOnClickListener {
            childFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayoutTablica, noviRezultatiFragment)
                addToBackStack(null)
                commit()
            }
        }
    }
}