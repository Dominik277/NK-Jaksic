package hr.fragmenti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import hr.adapteri.VijestiAdapter
import hr.database.NKJaksicDatabase
import hr.database.table.Vijesti
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.fragment_vijesti.*

class VijestiFragment : Fragment() {

    private lateinit var adapter: VijestiAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_vijesti,container,false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewVijesti.addItemDecoration(DividerItemDecoration
            (recyclerViewVijesti.context,DividerItemDecoration.VERTICAL))

    }
}