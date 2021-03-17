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
import hr.adapteri.TablicaTablicaAdapter
import hr.database.NKJaksicDatabase
import hr.database.table.TablicaTablica
import hr.dominik.nkjaki.R
import hr.viewModel.TablicaTablicaViewModel
import kotlinx.android.synthetic.main.tablica_fragment_tablica.*
import kotlinx.android.synthetic.main.tablica_fragment_tablica.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class TablicaTablicaFragment : Fragment(R.layout.tablica_fragment_tablica) {

    @InternalCoroutinesApi
    private lateinit var mTablicaTablicaViewModel: TablicaTablicaViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.tablica_fragment_tablica,container, false)

        //RecyclerView
        val adapter = TablicaTablicaAdapter()
        val recyclerTablica = view.tablicaRecyclerViewTablica
        recyclerTablica.adapter = adapter
        recyclerTablica.layoutManager = LinearLayoutManager(requireContext())

        //TablicaTablicaViewModel
        mTablicaTablicaViewModel = ViewModelProvider(this).get(TablicaTablicaViewModel::class.java)
        mTablicaTablicaViewModel.readAllDataTablicaTablica.observe(viewLifecycleOwner, Observer { tablicaTablica ->
            adapter.setData(tablicaTablica)
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tablicaRecyclerViewTablica.addItemDecoration(DividerItemDecoration
            (tablicaRecyclerViewTablica.context, DividerItemDecoration.VERTICAL))

    }
}