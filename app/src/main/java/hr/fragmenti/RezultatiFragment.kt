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
import hr.adapteri.RezultatiAdapter
import hr.database.NKJaksicDatabase
import hr.database.table.Rezultat
import hr.dominik.nkjaki.R
import hr.viewModel.RasporedViewModel
import hr.viewModel.RezultatViewModel
import kotlinx.android.synthetic.main.fragment_rezultati.*
import kotlinx.android.synthetic.main.fragment_rezultati.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class RezultatiFragment: Fragment() {

    @InternalCoroutinesApi
    private lateinit var mRezultatViewModel: RezultatViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_rezultati, container, false)

        //RecyclerView
        val adapter = RezultatiAdapter()
        val recyclerRezultat = view.recyclerViewRezultati
        recyclerRezultat.adapter = adapter
        recyclerRezultat.layoutManager = LinearLayoutManager(requireContext())

        //RezultatiViewModel
        mRezultatViewModel = ViewModelProvider(this).get(RezultatViewModel::class.java)
        mRezultatViewModel.readAllDataRezultat.observe(viewLifecycleOwner, Observer { rezultat ->
            adapter.setData(rezultat)
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
        recyclerViewRezultati.addItemDecoration(DividerItemDecoration
            (recyclerViewRezultati.context,DividerItemDecoration.VERTICAL))
/*
        database?.rezultatiDao()?.insertRezultat(Rezultat(0,"Liga","21.09","NK Jakšić","NK Kuzmica","3:1","P"))
        database?.rezultatiDao()?.insertRezultat(Rezultat(1,"Liga","21.09","NK Jakšić","NK Kuzmica","2:0","P"))
        database?.rezultatiDao()?.insertRezultat(Rezultat(2,"kup","21.09","NK Jakšić","NK Kuzmica","2:2","N"))
        database?.rezultatiDao()?.insertRezultat(Rezultat(3,"Liga","21.09","NK Jakšić","NK Kuzmica","1:3","I"))
        database?.rezultatiDao()?.insertRezultat(Rezultat(4,"Kup","21.09","NK Jakšić","NK Kuzmica","0:1","I"))
        database?.rezultatiDao()?.insertRezultat(Rezultat(5,"Prijateljska","21.09","NK Jakšić","NK Kuzmica","0:0","N"))
        database?.rezultatiDao()?.insertRezultat(Rezultat(6,"Kup","21.09","NK Jakšić","NK Kuzmica","3:0","P"))
        database?.rezultatiDao()?.insertRezultat(Rezultat(7,"Prijateljska","21.09","NK Jakšić","NK Kuzmica","1:0","P"))
        database?.rezultatiDao()?.insertRezultat(Rezultat(8,"Prijateljska","21.09","NK Jakšić","NK Kuzmica","0:0","N"))
        database?.rezultatiDao()?.insertRezultat(Rezultat(9,"Kup","21.09","NK Jakšić","NK Kuzmica","3:0","P"))
        database?.rezultatiDao()?.insertRezultat(Rezultat(10,"Prijateljska","21.09","NK Jakšić","NK Kuzmica","1:0","P"))
*/
        //database?.rezultatiDao()?.deletePodatkeRezultat()
        //val exampleRezultatiList = database?.rezultatiDao()?.getRezultatData()

        //recyclerViewRezultati.adapter = exampleRezultatiList?.let { RezultatiAdapter(it) }
        //recyclerViewRezultati.layoutManager = LinearLayoutManager(context)
        //recyclerViewRezultati.setHasFixedSize(true)

    }

}