package hr.fragmenti

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import hr.adapteri.TablicaTablicaAdapter
import hr.database.NKJaksicDatabase
import hr.database.table.TablicaTablica
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.tablica_fragment_tablica.*

class TablicaTablicaFragment : Fragment(R.layout.tablica_fragment_tablica) {

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

        tablicaRecyclerViewTablica.addItemDecoration(DividerItemDecoration
            (tablicaRecyclerViewTablica.context, DividerItemDecoration.VERTICAL))
/*
        database?.tablicaDao()?.insertTablicaTablica(TablicaTablica(0,1,"NK Jakšić",22,"+27",49))
        database?.tablicaDao()?.insertTablicaTablica(TablicaTablica(1,2,"NK Požega",22,"+21",39))
        database?.tablicaDao()?.insertTablicaTablica(TablicaTablica(2,3,"NK Lipik",22,"+19",29))
        database?.tablicaDao()?.insertTablicaTablica(TablicaTablica(3,4,"NK Pakrac",22,"+14",19))
        database?.tablicaDao()?.insertTablicaTablica(TablicaTablica(4,5,"NK Kuzmica",22,"+12",19))
        database?.tablicaDao()?.insertTablicaTablica(TablicaTablica(5,6,"NK Vidovci",22,"+4",19))
        database?.tablicaDao()?.insertTablicaTablica(TablicaTablica(6,7,"NK Gradac",22,"+8",19))
        database?.tablicaDao()?.insertTablicaTablica(TablicaTablica(7,8,"NK Mihaljevci",22,"+1",19))
        database?.tablicaDao()?.insertTablicaTablica(TablicaTablica(8,9,"NK Buk",22,"0",19))
        database?.tablicaDao()?.insertTablicaTablica(TablicaTablica(9,10,"NK Trenkovo",22,"-2",19))
        database?.tablicaDao()?.insertTablicaTablica(TablicaTablica(10,11,"NK Biškupci",22,"-4",19))
        database?.tablicaDao()?.insertTablicaTablica(TablicaTablica(11,12,"NK Eminovci",22,"-6",19))
        database?.tablicaDao()?.insertTablicaTablica(TablicaTablica(12,13,"NK Biškupci",22,"-9",19))
        database?.tablicaDao()?.insertTablicaTablica(TablicaTablica(13,14,"NK Eminovci",22,"-14",19))
*/
        //database.tablicaDao().deleteTablicaTablica()

        val svePokusTabliceUBazi = database?.tablicaDao()?.getTablicaTablica()

        tablicaRecyclerViewTablica.adapter = svePokusTabliceUBazi?.let { TablicaTablicaAdapter(it) }
        tablicaRecyclerViewTablica.layoutManager = LinearLayoutManager(context)
        tablicaRecyclerViewTablica.setHasFixedSize(true)

    }

}