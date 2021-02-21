package hr.fragmenti


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import hr.adapteri.NajboljiStrijelciAdapter
import hr.database.NKJaksicDatabase
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.fragment_najbolji_strijelci.*

class NajboljiStrijelciFragment : Fragment(R.layout.fragment_najbolji_strijelci) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

/*
        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
*/

        val database = getActivity()?.let {
            Room.databaseBuilder(
                it, NKJaksicDatabase::class.java,"nk_jaksic_baza"
            )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }

        pokusRecyclerViewNajboljiStrijelci.addItemDecoration(DividerItemDecoration
            (pokusRecyclerViewNajboljiStrijelci.context,DividerItemDecoration.VERTICAL))

/*
        database?.najboljiStrijelciDao()?.insertNajboljiStrijelac(NajboljiStrijelci(0,1,"Domagoj Kovačević","17"))
        database?.najboljiStrijelciDao()?.insertNajboljiStrijelac(NajboljiStrijelci(1,2,"Tomislav Žuljević","14"))
        database?.najboljiStrijelciDao()?.insertNajboljiStrijelac(NajboljiStrijelci(2,3,"Mile Pavelić","13"))
        database?.najboljiStrijelciDao()?.insertNajboljiStrijelac(NajboljiStrijelci(3,4,"Stjepan Šilhan","12"))
        database?.najboljiStrijelciDao()?.insertNajboljiStrijelac(NajboljiStrijelci(4,5,"Ivan Brus","12"))
        database?.najboljiStrijelciDao()?.insertNajboljiStrijelac(NajboljiStrijelci(5,6,"Marko Marić","11"))
        database?.najboljiStrijelciDao()?.insertNajboljiStrijelac(NajboljiStrijelci(6,7,"Pero Perić","8"))
*/
        //database?.najboljiStrijelciDao()?.deleteNajboljiStrijelci()
        val pokusStrijelciList = database?.najboljiStrijelciDao()?.getNajboljiStrijelciData()

        pokusRecyclerViewNajboljiStrijelci.adapter = pokusStrijelciList?.let { NajboljiStrijelciAdapter(it) }
        pokusRecyclerViewNajboljiStrijelci.layoutManager = LinearLayoutManager(context)
        pokusRecyclerViewNajboljiStrijelci.setHasFixedSize(true)

    }

}