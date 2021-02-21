package hr.fragmenti

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import hr.adapteri.TablicaRezultatiAdapter
import hr.database.NKJaksicDatabase
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.tablica_fragment_rezultati.*

class TablicaRezultatiFragment : Fragment(R.layout.tablica_fragment_rezultati) {

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

        pokusRecyclerViewRezultati.addItemDecoration(DividerItemDecoration
            (pokusRecyclerViewRezultati.context,DividerItemDecoration.VERTICAL))
/*
        database?.rezultatiDao()?.insertRezultat(Rezultat(0,"21.02","NK Jakšić-NK Kuzmica","4:1","P"))
        database?.rezultatiDao()?.insertRezultat(Rezultat(1,"21.02","NK Jakšić-NK Požega","4:1","P"))
        database?.rezultatiDao()?.insertRezultat(Rezultat(2,"21.02","NK Jakšić-NK Vidovci","4:1","P"))
        database?.rezultatiDao()?.insertRezultat(Rezultat(3,"21.02","NK Jakšić-NK Rajsavac","4:1","P"))
        database?.rezultatiDao()?.insertRezultat(Rezultat(4,"21.02","NK Jakšić-NK Eminovci","4:1","P"))
        database?.rezultatiDao()?.insertRezultat(Rezultat(5,"21.02","NK Jakšić-NK Buk","4:1","P"))
*/
        //database?.rezultatiDao()?.deletePodatkeRezultat()
        val examplePokusRezultatiList = database?.rezultatiDao()?.getRezultatData()

        pokusRecyclerViewRezultati.adapter = examplePokusRezultatiList?.let { TablicaRezultatiAdapter(it) }
        pokusRecyclerViewRezultati.layoutManager = LinearLayoutManager(context)
        pokusRecyclerViewRezultati.setHasFixedSize(true)

    }

}