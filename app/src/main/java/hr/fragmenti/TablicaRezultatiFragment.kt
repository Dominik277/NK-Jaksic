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

        tablicaRecyclerViewRezultati.addItemDecoration(DividerItemDecoration
            (tablicaRecyclerViewRezultati.context,DividerItemDecoration.VERTICAL))

    }
}