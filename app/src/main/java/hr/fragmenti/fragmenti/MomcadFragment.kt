package hr.fragmenti.fragmenti

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import hr.adapteri.MomcadAdapter
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.FragmentMomcadBinding
import hr.viewModel.MomcadViewModel
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class MomcadFragment : Fragment(R.layout.fragment_momcad) {

    @InternalCoroutinesApi
    private val mMomcadViewModel: MomcadViewModel by viewModels()
    private lateinit var binding: FragmentMomcadBinding

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMomcadBinding.bind(view)

        //RecyclerView
        val adapter = MomcadAdapter()
        val recyclerMomcad = binding.recyclerViewMomcad
        recyclerMomcad.adapter = adapter
        recyclerMomcad.layoutManager = LinearLayoutManager(requireContext())

        //MomcadViewModel
        mMomcadViewModel.readAllDataMomcad.observe(viewLifecycleOwner, Observer { momcad ->
            adapter.setData(momcad)
        })

        binding.recyclerViewMomcad.addItemDecoration(
            DividerItemDecoration
                (binding.recyclerViewMomcad.context, DividerItemDecoration.VERTICAL)
        )

    }
}