package hr.fragmenti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import hr.adapteri.PokusRezultatiAdapter
import hr.database.NKJaksicDatabase
import hr.database.table.Rezultat
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.fragment_rezultati.*

class PokusRezultatiFragment: Fragment() {

    private lateinit var adapter: PokusRezultatiAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rezultati, container, false)
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

        recyclerViewRezultati.addItemDecoration(DividerItemDecoration
            (recyclerViewRezultati.context,DividerItemDecoration.VERTICAL))

        database?.rezultatiDao()?.insertRezultat(Rezultat(0,"21.02","NK Jakšić-NK Kuzmica","4:1","P"))
        database?.rezultatiDao()?.insertRezultat(Rezultat(1,"21.02","NK Jakšić-NK Kuzmica","4:1","P"))
        database?.rezultatiDao()?.insertRezultat(Rezultat(2,"21.02","NK Jakšić-NK Kuzmica","4:1","P"))
        database?.rezultatiDao()?.insertRezultat(Rezultat(3,"21.02","NK Jakšić-NK Kuzmica","4:1","P"))
        database?.rezultatiDao()?.insertRezultat(Rezultat(4,"21.02","NK Jakšić-NK Kuzmica","4:1","P"))
        database?.rezultatiDao()?.insertRezultat(Rezultat(5,"21.02","NK Jakšić-NK Kuzmica","4:1","P"))

        //database?.rezultatiDao()?.deletePodatkeRezultat()
        val examplePokusRezultatiList = database?.rezultatiDao()?.getRezultatData()

        recyclerViewRezultati.adapter = examplePokusRezultatiList?.let { PokusRezultatiAdapter(it) }
        recyclerViewRezultati.layoutManager = LinearLayoutManager(context)
        recyclerViewRezultati.setHasFixedSize(true)

    }

}