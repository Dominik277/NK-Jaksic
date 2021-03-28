package hr.fragmenti.fragmenti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import hr.adapteri.TablicaRezultatiAdapter
import hr.dominik.nkjaki.R
import hr.viewModel.TablicaRasporedViewModel
import hr.viewModel.TablicaRezultatiViewModel
import kotlinx.android.synthetic.main.novi_fragment_rezultati.*
import kotlinx.android.synthetic.main.novi_fragment_rezultati.view.*
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class TablicaRezultatiFragment : Fragment() {

    @InternalCoroutinesApi
    private val mTablicaRezultatiViewModel: TablicaRezultatiViewModel by viewModels()

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
        mTablicaRezultatiViewModel.readAllDataTablicaRezultati.observe(
            viewLifecycleOwner,
            Observer { tablicaRezultat ->
                adapter.setData(tablicaRezultat)
            })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tablicaRecyclerViewRezultati.addItemDecoration(
            DividerItemDecoration
                (tablicaRecyclerViewRezultati.context, DividerItemDecoration.VERTICAL)
        )

    }
}