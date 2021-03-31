package hr.fragmenti.fragmenti

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import hr.adapteri.TablicaRasporedAdapter
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.TablicaFragmentRasporedBinding
import hr.viewModel.TablicaRasporedViewModel
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class TablicaRasporedFragment : Fragment(R.layout.tablica_fragment_raspored) {

    @InternalCoroutinesApi
    private val mTablicaRasporedViewModel: TablicaRasporedViewModel by viewModels()
    private lateinit var binding: TablicaFragmentRasporedBinding

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = TablicaFragmentRasporedBinding.bind(view)

        //RecyclerView
        val adapter = TablicaRasporedAdapter()
        val recyclerTablicaRaspored = binding.tablicaRecyclerViewRaspored
        recyclerTablicaRaspored.adapter = adapter
        recyclerTablicaRaspored.layoutManager = LinearLayoutManager(requireContext())

        //TablicaRasporedViewModel
        mTablicaRasporedViewModel.readAllDataTablicaRaspored.observe(
            viewLifecycleOwner,
            Observer { tablicaRaspored ->
                adapter.setData(tablicaRaspored)
            })

        binding.tablicaRecyclerViewRaspored.addItemDecoration(
            DividerItemDecoration
                (binding.tablicaRecyclerViewRaspored.context, DividerItemDecoration.VERTICAL)
        )
    }
}