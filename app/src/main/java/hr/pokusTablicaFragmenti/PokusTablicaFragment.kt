package hr.pokusTablicaFragmenti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hr.adapteri.NajboljiStrijelciAdapter
import hr.dominik.nkjaki.R

class PokusTablicaFragment : Fragment() {

    //private lateinit var recyclerViewNajboljiStrijelci: RecyclerView
    private lateinit var adapter: NajboljiStrijelciAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_najbolji_strijelci, container, false)
    }

}