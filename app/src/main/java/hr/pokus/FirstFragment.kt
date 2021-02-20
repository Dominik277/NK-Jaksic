package hr.pokus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import hr.database.NKJaksicDatabase
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.fragment_najbolji_strijelci.*

class FirstFragment : Fragment() {

    //private lateinit var recyclerViewNajboljiStrijelci: RecyclerView
    private lateinit var adapter: ExampleAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_najbolji_strijelci, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

/*
        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
*/

        val firstFragment = SecondFragment()
        button_first.setOnClickListener {
            getFragmentManager()?.beginTransaction()?.replace(R.id.nav_host_fragment_najboljiStrijelci,firstFragment)
                ?.commit()
        }

        val database = getActivity()?.let {
            Room.databaseBuilder(
                it, NKJaksicDatabase::class.java,"nk_jaksic_baza"
            )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }

        recyclerViewNajboljiStrijelci.addItemDecoration(DividerItemDecoration
            (recyclerViewNajboljiStrijelci.context,DividerItemDecoration.VERTICAL))

        //val exampleList = generateDummyList(50)
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
        val exampleList = database?.najboljiStrijelciDao()?.getNajboljiStrijelciData()

        recyclerViewNajboljiStrijelci.adapter = exampleList?.let { ExampleAdapter(it) }
        recyclerViewNajboljiStrijelci.layoutManager = LinearLayoutManager(context)
        recyclerViewNajboljiStrijelci.setHasFixedSize(true)

    }
/*
    private fun generateDummyList(size: Int): List<ExampleItem> {
        val list = ArrayList<ExampleItem>()
        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_launcher_background
                1 -> R.drawable.ic_launcher_background
                else -> R.drawable.ic_launcher_background
            }
            val item = ExampleItem(drawable, "Item $i", "Line 2")
            list += item
        }
        return list
    }

 */

}