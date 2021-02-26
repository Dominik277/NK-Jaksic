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
import hr.adapteri.TablicaRezultatiAdapter
import hr.dominik.nkjaki.R
import hr.viewModel.TablicaRasporedViewModel
import hr.viewModel.TablicaRezultatiViewModel
import kotlinx.android.synthetic.main.novi_fragment_rezultati.*
import kotlinx.android.synthetic.main.novi_fragment_rezultati.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class TablicaRezultatiFragment: Fragment() {

    @InternalCoroutinesApi
    private lateinit var mTablicaRezultatiViewModel: TablicaRezultatiViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.novi_fragment_rezultati, container, false)

        //RecyclerView
        val adapter = TablicaRezultatiAdapter()
        val recyclerTablicaRezultati = view.tablicaRecyclerViewRezultati
        recyclerTablicaRezultati.adapter = adapter
        recyclerTablicaRezultati.layoutManager = LinearLayoutManager(requireContext())

        //TablicaRezultatiViewModel
        mTablicaRezultatiViewModel = ViewModelProvider(this).get(TablicaRezultatiViewModel::class.java)
        mTablicaRezultatiViewModel.readAllDataTablicaRezultat.observe(viewLifecycleOwner, Observer { tablicaRezultat ->
            adapter.setData(tablicaRezultat)
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
/*
        val database = getActivity()?.let {
            Room.databaseBuilder(
                it, NKJaksicDatabase::class.java, "nk_jaksic_baza"
            )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
*/
        tablicaRecyclerViewRezultati.addItemDecoration(DividerItemDecoration
            (tablicaRecyclerViewRezultati.context,DividerItemDecoration.VERTICAL))

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
        //val sviTablicaRasporedObjekti = database?.tablicaRezultatiDao()?.getNoviRezultatiData()
        //noviRecyclerViewRezultati.adapter = sviTablicaRasporedObjekti?.let { TablicaRezultatiAdapter(it) }
        //noviRecyclerViewRezultati.layoutManager = LinearLayoutManager(context)
        //noviRecyclerViewRezultati.setHasFixedSize(true)

    }

}