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
import kotlinx.android.synthetic.main.novi_fragment_rezultati.*

class TablicaRezultatiFragment: Fragment(R.layout.novi_fragment_rezultati) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val database = getActivity()?.let {
            Room.databaseBuilder(
                it, NKJaksicDatabase::class.java, "nk_jaksic_baza"
            )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }

        noviRecyclerViewRezultati.addItemDecoration(DividerItemDecoration
            (noviRecyclerViewRezultati.context,DividerItemDecoration.VERTICAL))

/*
        database?.noviRezultatiDao()?.insertNoviRezultati(NoviRezultati(0,1,
            "19.09","NK Jakšić","NK Kuzmica","4:1",
            "19.09","NK Vidovci","NK Požega","1:1",
            "20.09","NK Mihaljevci","NK Trenkovo","2:0",
            "20.09","NK Buk","NK Rajsavac","1:2",
            "19.09","NK Papuk","NK Gradac","3:3",
            "19.09","NK Eminovci","NK Drenovac","1:4",
            "21.09","NK Zagrađe","NK Bučje","6:2"))
        database?.noviRezultatiDao()?.insertNoviRezultati(NoviRezultati(1,2,
            "19.09","NK Jakšić","NK Kuzmica","4:1",
            "19.09","NK Vidovci","NK Požega","1:1",
            "20.09","NK Mihaljevci","NK Trenkovo","2:0",
            "20.09","NK Buk","NK Rajsavac","1:2",
            "19.09","NK Papuk","NK Gradac","3:3",
            "19.09","NK Eminovci","NK Drenovac","1:4",
            "21.09","NK Zagrađe","NK Bučje","6:2"))
        database?.noviRezultatiDao()?.insertNoviRezultati(NoviRezultati(2,3,
            "19.09","NK Jakšić","NK Kuzmica","4:1",
            "19.09","NK Vidovci","NK Požega","1:1",
            "20.09","NK Mihaljevci","NK Trenkovo","2:0",
            "20.09","NK Buk","NK Rajsavac","1:2",
            "19.09","NK Papuk","NK Gradac","3:3",
            "19.09","NK Eminovci","NK Drenovac","1:4",
            "21.09","NK Zagrađe","NK Bučje","6:2"))
        database?.noviRezultatiDao()?.insertNoviRezultati(
            NoviRezultati(3,4,
            "19.09","NK Jakšić","NK Kuzmica","4:1",
            "19.09","NK Vidovci","NK Požega","1:1",
            "20.09","NK Mihaljevci","NK Trenkovo","2:0",
            "20.09","NK Buk","NK Rajsavac","1:2",
            "19.09","NK Papuk","NK Gradac","3:3",
            "19.09","NK Eminovci","NK Drenovac","1:4",
            "21.09","NK Zagrađe","NK Bučje","6:2")
        )
*/
        //database?.noviRezultatiDao()?.deleteNoviRezultati()
        val sviTablicaRasporedObjekti = database?.tablicaRezultatiDao()?.getNoviRezultatiData()
        noviRecyclerViewRezultati.adapter = sviTablicaRasporedObjekti?.let { TablicaRezultatiAdapter(it) }
        noviRecyclerViewRezultati.layoutManager = LinearLayoutManager(context)
        noviRecyclerViewRezultati.setHasFixedSize(true)

    }

}