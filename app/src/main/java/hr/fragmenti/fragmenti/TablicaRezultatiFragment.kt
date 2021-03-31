package hr.fragmenti.fragmenti

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import hr.adapteri.TablicaRezultatiAdapter
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.NoviFragmentRezultatiBinding
import hr.viewModel.TablicaRezultatiViewModel
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class TablicaRezultatiFragment : Fragment(R.layout.novi_fragment_rezultati) {

    @InternalCoroutinesApi
    private val mTablicaRezultatiViewModel: TablicaRezultatiViewModel by viewModels()
    private lateinit var binding: NoviFragmentRezultatiBinding

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = NoviFragmentRezultatiBinding.bind(view)

        //RecyclerView
        val adapter = TablicaRezultatiAdapter()
        val recyclerTablicaRezultati = binding.tablicaRecyclerViewRezultati
        recyclerTablicaRezultati.adapter = adapter
        recyclerTablicaRezultati.layoutManager = LinearLayoutManager(requireContext())

        //TablicaRezultatiViewModel
        mTablicaRezultatiViewModel.readAllDataTablicaRezultati.observe(
            viewLifecycleOwner,
            Observer { tablicaRezultat ->
                adapter.setData(tablicaRezultat)
            })

        binding.tablicaRecyclerViewRezultati.addItemDecoration(
            DividerItemDecoration
                (binding.tablicaRecyclerViewRezultati.context, DividerItemDecoration.VERTICAL)
        )

    }
}