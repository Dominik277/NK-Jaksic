package hr.fragmenti.fragmenti

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import hr.adapteri.RezultatiAdapter
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.FragmentRezultatiBinding
import hr.viewModel.RezultatViewModel
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class RezultatiFragment : Fragment(R.layout.fragment_rezultati) {

    @InternalCoroutinesApi
    private val mRezultatViewModel: RezultatViewModel by viewModels()
    private lateinit var binding: FragmentRezultatiBinding

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRezultatiBinding.bind(view)

        //RecyclerView
        val adapter = RezultatiAdapter()
        val recyclerRezultat = binding.recyclerViewRezultati
        recyclerRezultat.adapter = adapter
        recyclerRezultat.layoutManager = LinearLayoutManager(requireContext())

        //RezultatiViewModel
        mRezultatViewModel.readAllDataRezultati.observe(viewLifecycleOwner, Observer { rezultat ->
            adapter.setData(rezultat)
        })

        binding.recyclerViewRezultati.addItemDecoration(
            DividerItemDecoration
                (binding.recyclerViewRezultati.context, DividerItemDecoration.VERTICAL)
        )

    }
}