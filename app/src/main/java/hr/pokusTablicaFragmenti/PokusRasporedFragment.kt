package hr.pokusTablicaFragmenti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hr.adapteri.RasporedAdapter
import hr.dominik.nkjaki.R

class PokusRasporedFragment : Fragment(R.layout.pokus_fragment_raspored) {

    private lateinit var adapter: RasporedAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.pokus_fragment_raspored, container, false)
    }

}