package hr.fragmenti.fragmenti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import hr.dominik.nkjaki.R
import hr.fragmenti.TablicaFragmentDirections
import kotlinx.android.synthetic.main.fragment_tablica.view.*

class TablicaFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tablica, container, false)


        view.gumbNajboljiStrijelci.setOnClickListener {
            val action = TablicaFragmentDirections.actionNavTablicaToNajboljiStrijelciFragment()
            findNavController().navigate(action)
        }


        view.gumbTablica.setOnClickListener {
            val action = TablicaFragmentDirections.actionNavTablicaToTablicaTablicaFragment()
            findNavController().navigate(action)
        }

        view.gumbRezultati.setOnClickListener {
            val action = TablicaFragmentDirections.actionNavTablicaToTablicaRezultatiFragment()
            findNavController().navigate(action)
        }

        view.gumbRaspored.setOnClickListener {
            val action = TablicaFragmentDirections.actionNavTablicaToTablicaRasporedFragment()
            findNavController().navigate(action)
        }

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tablicaTablicaFragment = TablicaTablicaFragment()
        val strijelciFragment = NajboljiStrijelciFragment()
        val tablicaRasporedFragment = TablicaRasporedFragment()
        val noviRezultatiFragment = TablicaRezultatiFragment()

        /*
        childFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayoutTablica, tablicaTablicaFragment)
            commit()
        }
*/

/*
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

 */
    }
}