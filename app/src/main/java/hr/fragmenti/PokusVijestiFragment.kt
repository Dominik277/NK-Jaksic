package hr.fragmenti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import hr.adapteri.PokusVijestiAdapter
import hr.database.NKJaksicDatabase
import hr.database.table.Vijesti
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.fragment_pokus_vijesti.*

class PokusVijestiFragment : Fragment() {

    private lateinit var adapter: PokusVijestiAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokus_vijesti, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val database = getActivity()?.let {
            Room.databaseBuilder(
                it, NKJaksicDatabase::class.java,"nk_jaksic_baza"
            )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }

        recyclerViewPokusVijesti.addItemDecoration(DividerItemDecoration
            (recyclerViewPokusVijesti.context,DividerItemDecoration.VERTICAL))
/*
        database?.najboljiStrijelciDao()?.insertNajboljiStrijelac(NajboljiStrijelci(0,1,"Domagoj Kovačević","17"))
        database?.najboljiStrijelciDao()?.insertNajboljiStrijelac(NajboljiStrijelci(1,2,"Tomislav Žuljević","14"))
        database?.najboljiStrijelciDao()?.insertNajboljiStrijelac(NajboljiStrijelci(2,3,"Mile Pavelić","13"))
        database?.najboljiStrijelciDao()?.insertNajboljiStrijelac(NajboljiStrijelci(3,4,"Stjepan Šilhan","12"))
        database?.najboljiStrijelciDao()?.insertNajboljiStrijelac(NajboljiStrijelci(4,5,"Ivan Brus","12"))
        database?.najboljiStrijelciDao()?.insertNajboljiStrijelac(NajboljiStrijelci(5,6,"Marko Marić","11"))
        database?.najboljiStrijelciDao()?.insertNajboljiStrijelac(NajboljiStrijelci(6,7,"Pero Perić","8"))
*/

        database?.vijestiDao()?.insertVijest(Vijesti(0,"Jakšić pobijedio rezultatom 3:1",R.drawable.slikavijesti))
        database?.vijestiDao()?.insertVijest(Vijesti(1,"Jakšić pobijedio rezultatom 3:1",R.drawable.slikavijesti))
        database?.vijestiDao()?.insertVijest(Vijesti(2,"Jakšić pobijedio rezultatom 3:1",R.drawable.slikavijesti))
        database?.vijestiDao()?.insertVijest(Vijesti(3,"Jakšić pobijedio rezultatom 3:1",R.drawable.slikavijesti))
        database?.vijestiDao()?.insertVijest(Vijesti(4,"Jakšić pobijedio rezultatom 3:1",R.drawable.slikavijesti))
        database?.vijestiDao()?.insertVijest(Vijesti(5,"Jakšić pobijedio rezultatom 3:1",R.drawable.slikavijesti))
        database?.vijestiDao()?.insertVijest(Vijesti(6,"Jakšić pobijedio rezultatom 3:1",R.drawable.slikavijesti))

        //database?.najboljiStrijelciDao()?.deleteNajboljiStrijelci()
        val examplePokusList = database?.vijestiDao()?.getVijestiData()

        recyclerViewPokusVijesti.adapter = examplePokusList?.let { PokusVijestiAdapter(it) }
        recyclerViewPokusVijesti.layoutManager = LinearLayoutManager(context)
        recyclerViewPokusVijesti.setHasFixedSize(true)

    }

}