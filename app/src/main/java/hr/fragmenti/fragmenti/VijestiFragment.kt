package hr.fragmenti.fragmenti

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import hr.adapteri.VijestiAdapter
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.FragmentVijestiBinding
import hr.viewModel.VijestiViewModel
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class VijestiFragment : Fragment(R.layout.fragment_vijesti) {

    @InternalCoroutinesApi
    private val mVijestiViewModel: VijestiViewModel by viewModels()
    private lateinit var binding: FragmentVijestiBinding

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentVijestiBinding.bind(view)

        //RecyclerView
        val adapter = VijestiAdapter()
        val recyclerVijesti = binding.recyclerViewVijesti
        recyclerVijesti.adapter = adapter
        recyclerVijesti.layoutManager = LinearLayoutManager(requireContext())

        //VijestiViewModel
        mVijestiViewModel.readAllDataVijesti.observe(viewLifecycleOwner, Observer { vijesti ->
            adapter.setData(vijesti)
        })

        binding.recyclerViewVijesti.addItemDecoration(
            DividerItemDecoration
                (binding.recyclerViewVijesti.context, DividerItemDecoration.VERTICAL)
        )

    }
}