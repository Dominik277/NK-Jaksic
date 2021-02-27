package hr.fragmenti


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import hr.adapteri.NajboljiStrijelciAdapter
import hr.database.NKJaksicDatabase
import hr.database.table.NajboljiStrijelci
import hr.dominik.nkjaki.R
import hr.viewModel.NajboljiStrijelciViewModel
import kotlinx.android.synthetic.main.fragment_najbolji_strijelci.*
import kotlinx.android.synthetic.main.fragment_najbolji_strijelci.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class NajboljiStrijelciFragment : Fragment() {

    @InternalCoroutinesApi
    private lateinit var mNajboljiStrijelacViewModel: NajboljiStrijelciViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_najbolji_strijelci,container, false)

        //RecyclerView
        val adapter = NajboljiStrijelciAdapter()
        val recyclerNajboljiStrijelci = view.recyclerViewNajboljiStrijelci
        recyclerNajboljiStrijelci.adapter = adapter
        recyclerNajboljiStrijelci.layoutManager = LinearLayoutManager(requireContext())

        //NajboljiStrijelciViewModel
        mNajboljiStrijelacViewModel = ViewModelProvider(this).get(NajboljiStrijelciViewModel::class.java)
        mNajboljiStrijelacViewModel.readAllDataNajboljiStrijelci.observe(viewLifecycleOwner, Observer { najboljiStrijelac ->
            adapter.setData(najboljiStrijelac)
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

/*
        val database = getActivity()?.let {
            Room.databaseBuilder(
                it, NKJaksicDatabase::class.java,"nk_jaksic_baza"
            )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
*/
        recyclerViewNajboljiStrijelci.addItemDecoration(DividerItemDecoration
            (recyclerViewNajboljiStrijelci.context,DividerItemDecoration.VERTICAL))

/*
        database?.najboljiStrijelciDao()?.insertNajboljiStrijelac(NajboljiStrijelci(0,1,"Domagoj Kovačević","17"))
        database?.najboljiStrijelciDao()?.insertNajboljiStrijelac(NajboljiStrijelci(1,2,"Tomislav Žuljević","14"))
        database?.najboljiStrijelciDao()?.insertNajboljiStrijelac(NajboljiStrijelci(2,3,"Mile Pavelić","13"))
        database?.najboljiStrijelciDao()?.insertNajboljiStrijelac(NajboljiStrijelci(3,4,"Stjepan Šilhan","12"))
        database?.najboljiStrijelciDao()?.insertNajboljiStrijelac(NajboljiStrijelci(4,5,"Ivan Brus","12"))
        database?.najboljiStrijelciDao()?.insertNajboljiStrijelac(NajboljiStrijelci(5,6,"Marko Marić","11"))
        database?.najboljiStrijelciDao()?.insertNajboljiStrijelac(NajboljiStrijelci(6,7,"Pero Perić","8"))
        database?.najboljiStrijelciDao()?.insertNajboljiStrijelac(NajboljiStrijelci(7,8,"Stjepan Šilhan","12"))
        database?.najboljiStrijelciDao()?.insertNajboljiStrijelac(NajboljiStrijelci(8,9,"Ivan Brus","12"))
        database?.najboljiStrijelciDao()?.insertNajboljiStrijelac(NajboljiStrijelci(9,10,"Marko Marić","11"))
        database?.najboljiStrijelciDao()?.insertNajboljiStrijelac(NajboljiStrijelci(10,11,"Pero Perić","8"))
        database?.najboljiStrijelciDao()?.insertNajboljiStrijelac(NajboljiStrijelci(11,12,"Ivan Brus","12"))
        database?.najboljiStrijelciDao()?.insertNajboljiStrijelac(NajboljiStrijelci(12,13,"Marko Marić","11"))
        database?.najboljiStrijelciDao()?.insertNajboljiStrijelac(NajboljiStrijelci(13,14,"Pero Perić","8"))
*/

        //database?.najboljiStrijelciDao()?.deleteNajboljiStrijelci()
        //val pokusStrijelciList = database?.najboljiStrijelciDao()?.getNajboljiStrijelciData()

        //recyclerViewNajboljiStrijelci.adapter = pokusStrijelciList?.let { NajboljiStrijelciAdapter(it) }
        //recyclerViewNajboljiStrijelci.layoutManager = LinearLayoutManager(context)
        //recyclerViewNajboljiStrijelci.setHasFixedSize(true)

    }

}