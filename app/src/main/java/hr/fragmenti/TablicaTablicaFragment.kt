package hr.fragmenti

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import hr.adapteri.TablicaTablicaAdapter
import hr.database.NKJaksicDatabase
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.fragment_tablica_tablica.*

class TablicaTablicaFragment : Fragment(R.layout.fragment_tablica_tablica) {

    private lateinit var recyclerview: RecyclerView
    private lateinit var adapter: TablicaTablicaAdapter

    val database = Room.databaseBuilder(
        requireContext(),NKJaksicDatabase::class.java,"nk_jaksic_baza"
    )
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tablicaList = database.tablicaDao().getTablicaTablica()

        recyclerView_Tablica.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = TablicaTablicaAdapter(tablicaList)
        }
    }

}