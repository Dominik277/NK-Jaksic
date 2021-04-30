package hr.fragmenti.fragmenti

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import hr.adapteri.TablicaTablicaAdapter
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.TablicaFragmentTablicaBinding
import hr.viewModel.TablicaTablicaViewModel
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class TablicaTablicaFragment : Fragment(R.layout.tablica_fragment_tablica) {

    @InternalCoroutinesApi
    private val mTablicaTablicaViewModel: TablicaTablicaViewModel by viewModels()
    private lateinit var binding: TablicaFragmentTablicaBinding

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = TablicaFragmentTablicaBinding.bind(view)

        //RecyclerView
        val adapter = TablicaTablicaAdapter()
        val recyclerTablica = binding.tablicaRecyclerViewTablica
        recyclerTablica.adapter = adapter
        recyclerTablica.layoutManager = LinearLayoutManager(requireContext())

        //TablicaTablicaViewModel
        mTablicaTablicaViewModel.readAllDataTablicaTablica.observe(
            viewLifecycleOwner,
            Observer { tablicaTablica ->
                adapter.setData(tablicaTablica)
            })

        binding.tablicaRecyclerViewTablica.addItemDecoration(
            DividerItemDecoration
                (binding.tablicaRecyclerViewTablica.context, DividerItemDecoration.VERTICAL)
        )

    }
}