package hr.pokusTablicaFragmenti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import hr.adapteri.RasporedAdapter
import hr.database.NKJaksicDatabase
import hr.database.table.Raspored
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.pokus_fragment_raspored.*

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

        pokusRecyclerViewRaspored.addItemDecoration(DividerItemDecoration
            (pokusRecyclerViewRaspored.context,DividerItemDecoration.VERTICAL))

        database?.rasporedDao()?.insertRaspored(Raspored(0,"21.02","NK Jakšić-NK Kuzmica"))
        database?.rasporedDao()?.insertRaspored(Raspored(1,"21.02","NK Jakšić-NK Požega"))
        database?.rasporedDao()?.insertRaspored(Raspored(2,"21.02","NK Jakšić-NK Mihaljevci"))
        database?.rasporedDao()?.insertRaspored(Raspored(3,"21.02","NK Jakšić-NK Gradac"))
        database?.rasporedDao()?.insertRaspored(Raspored(4,"21.02","NK Jakšić-NK Trenkovo"))
        database?.rasporedDao()?.insertRaspored(Raspored(5,"21.02","NK Jakšić-NK Vidovci"))
        database?.rasporedDao()?.insertRaspored(Raspored(6,"21.02","NK Jakšić-NK Eminovci"))
        database?.rasporedDao()?.insertRaspored(Raspored(7,"21.02","NK Jakšić-NK Rajsavac"))
        database?.rasporedDao()?.insertRaspored(Raspored(8,"21.02","NK Jakšić-NK Buk"))

        //database?.najboljiStrijelciDao()?.deleteNajboljiStrijelci()
        val examplePokusRasporedList = database?.rasporedDao()?.getRasporedData()

        pokusRecyclerViewRaspored.adapter = examplePokusRasporedList?.let { PokusRasporedAdapter(it) }
        pokusRecyclerViewRaspored.layoutManager = LinearLayoutManager(context)
        pokusRecyclerViewRaspored.setHasFixedSize(true)

    }

}