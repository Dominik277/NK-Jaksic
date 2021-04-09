package hr.fragmenti.fragmenti

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import hr.adapteri.RasporedAdapter
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.FragmentRasporedBinding
import hr.viewModel.RasporedViewModel
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class RasporedFragment : Fragment(R.layout.fragment_raspored) {

    @InternalCoroutinesApi
    private val mRasporedViewModel: RasporedViewModel by viewModels()
    private lateinit var binding: FragmentRasporedBinding

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRasporedBinding.bind(view)

        //RecyclerView
        val adapter = RasporedAdapter()
        val recyclerRaspored = binding.recyclerViewRaspored
        recyclerRaspored.adapter = adapter
        recyclerRaspored.layoutManager = LinearLayoutManager(requireContext())

        //RasporedViewModel
        mRasporedViewModel.readAllDataRaspored.observe(viewLifecycleOwner, Observer { raspored ->
            adapter.setData(raspored)
        })

        binding.recyclerViewRaspored.addItemDecoration(
            DividerItemDecoration
                (binding.recyclerViewRaspored.context, DividerItemDecoration.VERTICAL)
        )

    }
}