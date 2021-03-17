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
import hr.adapteri.TablicaRasporedAdapter
import hr.adapteri.RasporedAdapter
import hr.database.NKJaksicDatabase
import hr.database.table.TablicaRaspored
import hr.dominik.nkjaki.R
import hr.viewModel.TablicaRasporedViewModel
import kotlinx.android.synthetic.main.tablica_fragment_raspored.*
import kotlinx.android.synthetic.main.tablica_fragment_raspored.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class TablicaRasporedFragment : Fragment() {

    @InternalCoroutinesApi
    private lateinit var mTablicaRasporedViewModel: TablicaRasporedViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.tablica_fragment_raspored, container, false)

        //RecyclerView
        val adapter = TablicaRasporedAdapter()
        val recyclerTablicaRaspored = view.tablicaRecyclerViewRaspored
        recyclerTablicaRaspored.adapter = adapter
        recyclerTablicaRaspored.layoutManager = LinearLayoutManager(requireContext())

        //TablicaRasporedViewModel
        mTablicaRasporedViewModel = ViewModelProvider(this).get(TablicaRasporedViewModel::class.java)
        mTablicaRasporedViewModel.readAllDataTablicaRaspored.observe(viewLifecycleOwner, Observer { tablicaRaspored ->
            adapter.setData(tablicaRaspored)
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tablicaRecyclerViewRaspored.addItemDecoration(DividerItemDecoration
            (tablicaRecyclerViewRaspored.context,DividerItemDecoration.VERTICAL))
    }
}