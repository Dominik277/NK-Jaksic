package hr.fragmenti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import hr.adapteri.MomcadAdapter
import hr.database.NKJaksicDatabase
import hr.database.table.Igraci
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.fragment_momcad.*

class MomcadFragment: Fragment() {

    private lateinit var adapter: MomcadAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_momcad, container, false)
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

        recyclerViewMomcad.addItemDecoration(DividerItemDecoration
            (recyclerViewMomcad.context,DividerItemDecoration.VERTICAL))
/*
        database?.igraciDao()?.insertIgrac(Igraci(0,"Domagoj","Kovačević",5,R.drawable.face))
        database?.igraciDao()?.insertIgrac(Igraci(1,"Matko","Kovačević",6,R.drawable.face))
        database?.igraciDao()?.insertIgrac(Igraci(2,"Ivan","Karača",15,R.drawable.face))
        database?.igraciDao()?.insertIgrac(Igraci(3,"Ivan","Brus",14,R.drawable.face))
        database?.igraciDao()?.insertIgrac(Igraci(4,"Stjepan","Šilhan",2,R.drawable.face))
        database?.igraciDao()?.insertIgrac(Igraci(5,"Maurizio","Rezo",6,R.drawable.face))
        database?.igraciDao()?.insertIgrac(Igraci(6,"Ivo","Ivić",9,R.drawable.face))
        database?.igraciDao()?.insertIgrac(Igraci(7,"Matko","Matkić",7,R.drawable.face))
        database?.igraciDao()?.insertIgrac(Igraci(8,"Ivan","Ivić",6,R.drawable.face))
        database?.igraciDao()?.insertIgrac(Igraci(9,"Marko","Grbeš",8,R.drawable.face))
        database?.igraciDao()?.insertIgrac(Igraci(10,"Stjepan","Stjepić",3,R.drawable.face))
        database?.igraciDao()?.insertIgrac(Igraci(11,"Luka","Obradović",11,R.drawable.face))
*/
        //database?.igraciDao()?.deletePodatke()

        val examplePokusMomcadList = database?.igraciDao()?.getIgraciData()

        recyclerViewMomcad.adapter = examplePokusMomcadList?.let { MomcadAdapter(it) }
        recyclerViewMomcad.layoutManager = LinearLayoutManager(context)
        recyclerViewMomcad.setHasFixedSize(true)

    }

}