package hr.pokusRezultati

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import hr.database.NKJaksicDatabase
import hr.database.table.Raspored
import hr.dominik.nkjaki.R
import hr.pokusRaspored.PokusRasporedAdapter
import kotlinx.android.synthetic.main.fragment_pokus_raspored.*

class PokusRezultatiFragment: Fragment() {

    private lateinit var adapter: PokusRasporedAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokus_raspored, container, false)
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

        recyclerViewPokusRaspored.addItemDecoration(DividerItemDecoration)

        database?.rasporedDao()?.insertRaspored(Raspored(0,"21.02","NK Jakšić-NK Kuzmica"))
        database?.rasporedDao()?.insertRaspored(Raspored(1,"21.02","NK Jakšić-NK Kuzmica"))
        database?.rasporedDao()?.insertRaspored(Raspored(2,"21.02","NK Jakšić-NK Kuzmica"))
        database?.rasporedDao()?.insertRaspored(Raspored(3,"21.02","NK Jakšić-NK Kuzmica"))
        database?.rasporedDao()?.insertRaspored(Raspored(4,"21.02","NK Jakšić-NK Kuzmica"))
        database?.rasporedDao()?.insertRaspored(Raspored(5,"21.02","NK Jakšić-NK Kuzmica"))
        database?.rasporedDao()?.insertRaspored(Raspored(6,"21.02","NK Jakšić-NK Kuzmica"))
        database?.rasporedDao()?.insertRaspored(Raspored(7,"21.02","NK Jakšić-NK Kuzmica"))
        database?.rasporedDao()?.insertRaspored(Raspored(8,"21.02","NK Jakšić-NK Kuzmica"))

        //database?.najboljiStrijelciDao()?.deleteNajboljiStrijelci()
        val examplePokusRasporedList = database?.rasporedDao()?.getRasporedData()

        recyclerViewPokusRaspored.adapter = examplePokusRasporedList?.let { PokusRasporedAdapter(it) }
        recyclerViewPokusRaspored.layoutManager = LinearLayoutManager(context)
        recyclerViewPokusRaspored.setHasFixedSize(true)

    }

}