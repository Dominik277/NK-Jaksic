package hr.fragmenti

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
import kotlinx.android.synthetic.main.fragment_raspored.*

class RasporedFragment: Fragment() {

    private lateinit var adapter: RasporedAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_raspored, container, false)
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

        recyclerViewRaspored.addItemDecoration(DividerItemDecoration
            (recyclerViewRaspored.context,DividerItemDecoration.VERTICAL))

        database?.rasporedDao()?.insertRaspored(Raspored(0,"Prijateljska","21.09","NK Jakšić","NK Kuzmica","15:30"))
        database?.rasporedDao()?.insertRaspored(Raspored(1,"Liga","21.09","NK Jakšić","NK Kuzmica","15:30"))
        database?.rasporedDao()?.insertRaspored(Raspored(2,"Kup","21.09","NK Kuzmica","NK Jakšić","15:30"))
        database?.rasporedDao()?.insertRaspored(Raspored(3,"Prijateljska","21.09","NK Kuzmica","NK Jakšić","15:30"))
        database?.rasporedDao()?.insertRaspored(Raspored(4,"Liga","21.09","NK Kuzmica","NK Jakšić","15:30"))
        database?.rasporedDao()?.insertRaspored(Raspored(5,"Kup","21.09","NK Jakšić","NK Kuzmica","15:30"))
        database?.rasporedDao()?.insertRaspored(Raspored(6,"Prijateljska","21.09","NK Jakšić","NK Kuzmica","15:30"))
        database?.rasporedDao()?.insertRaspored(Raspored(7,"Liga","21.09","NK Kuzmica","NK Jakšić","15:30"))
        database?.rasporedDao()?.insertRaspored(Raspored(8,"Prijateljska","21.09","NK Kuzmica","NK Jakšić","15:30"))
        database?.rasporedDao()?.insertRaspored(Raspored(9,"Kup","21.09","NK Jakšić","NK Kuzmica","15:30"))
        database?.rasporedDao()?.insertRaspored(Raspored(10,"Prijateljska","21.09","NK Jakšić","NK Kuzmica","15:30"))
        database?.rasporedDao()?.insertRaspored(Raspored(11,"Liga","21.09","NK Kuzmica","NK Jakšić","15:30"))
        database?.rasporedDao()?.insertRaspored(Raspored(12,"Prijateljska","21.09","NK Kuzmica","NK Jakšić","15:30"))

        //database?.najboljiStrijelciDao()?.deleteNajboljiStrijelci()
        val exampleRasporedList = database?.rasporedDao()?.getRasporedData()

        recyclerViewRaspored.adapter = exampleRasporedList?.let { RasporedAdapter(it) }
        recyclerViewRaspored.layoutManager = LinearLayoutManager(context)
        recyclerViewRaspored.setHasFixedSize(true)

    }

}