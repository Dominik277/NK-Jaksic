package hr.pokusMomcad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import hr.database.NKJaksicDatabase
import hr.database.table.Igraci
import hr.database.table.Raspored
import hr.dominik.nkjaki.R
import hr.pokusRaspored.PokusRasporedAdapter
import kotlinx.android.synthetic.main.fragment_pokus_momcad.*
import kotlinx.android.synthetic.main.fragment_pokus_raspored.*

class PokusMomcadFragment: Fragment() {

    private lateinit var adapter: PokusMomcadAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokus_momcad, container, false)
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

        recyclerViewPokusMomcad.addItemDecoration(DividerItemDecoration
            (recyclerViewPokusMomcad.context,DividerItemDecoration.VERTICAL))

        database?.igraciDao()?.insertIgrac(Igraci(0,"Domagoj","Kovačević",5))
        database?.igraciDao()?.insertIgrac(Igraci(1,"Matko","Kovačević",5))
        database?.igraciDao()?.insertIgrac(Igraci(2,"Ivan","Karača",5))
        database?.igraciDao()?.insertIgrac(Igraci(3,"Ivan","Brus",5))
        database?.igraciDao()?.insertIgrac(Igraci(4,"Stjepan","Šilhan",5))
        database?.igraciDao()?.insertIgrac(Igraci(5,"Maurizio","Rezo",5))

        //database?.igraciDao()?.deletePodatke()

        val examplePokusMomcadList = database?.igraciDao()?.getIgraciData()

        recyclerViewPokusMomcad.adapter = examplePokusMomcadList?.let { PokusMomcadAdapter(it) }
        recyclerViewPokusMomcad.layoutManager = LinearLayoutManager(context)
        recyclerViewPokusMomcad.setHasFixedSize(true)

    }

}