package hr.fragmenti

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import hr.adapteri.TablicaTablicaAdapter
import hr.database.NKJaksicDatabase
import hr.database.TablicaTablica
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.fragment_tablica_tablica.*

class TablicaTablicaFragment : Fragment(R.layout.fragment_tablica_tablica) {

    private lateinit var recyclerview: RecyclerView
    private lateinit var adapter: TablicaTablicaAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tablicaList =

        recyclerView_Tablica.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = TablicaTablicaAdapter(tablicaList)

        }
    }

