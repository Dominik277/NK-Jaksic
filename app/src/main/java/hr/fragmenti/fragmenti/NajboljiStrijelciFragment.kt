package hr.fragmenti.fragmenti


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import hr.adapteri.NajboljiStrijelciAdapter
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.FragmentNajboljiStrijelciBinding
import hr.viewModel.NajboljiStrijelciViewModel
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class NajboljiStrijelciFragment : Fragment(R.layout.fragment_najbolji_strijelci) {

    @InternalCoroutinesApi
    private val mNajboljiStrijelacViewModel: NajboljiStrijelciViewModel by viewModels()
    private lateinit var binding: FragmentNajboljiStrijelciBinding

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNajboljiStrijelciBinding.bind(view)

        //RecyclerView
        val adapter = NajboljiStrijelciAdapter()
        val recyclerNajboljiStrijelci = binding.recyclerViewNajboljiStrijelci
        recyclerNajboljiStrijelci.adapter = adapter
        recyclerNajboljiStrijelci.layoutManager = LinearLayoutManager(requireContext())

        //NajboljiStrijelciViewModel
        mNajboljiStrijelacViewModel.readAllDataNajboljiStrijelci.observe(
            viewLifecycleOwner,
            Observer { najboljiStrijelac ->
                adapter.setData(najboljiStrijelac)
            })

        binding.recyclerViewNajboljiStrijelci.addItemDecoration(
            DividerItemDecoration
                (binding.recyclerViewNajboljiStrijelci.context, DividerItemDecoration.VERTICAL)
        )

    }
}