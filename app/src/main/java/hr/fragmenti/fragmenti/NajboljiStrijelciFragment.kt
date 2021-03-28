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
import androidx.room.Room
import dagger.hilt.android.AndroidEntryPoint
import hr.adapteri.NajboljiStrijelciAdapter
import hr.database.NKJaksicDatabase
import hr.database.table.NajboljiStrijelci
import hr.dominik.nkjaki.R
import hr.viewModel.NajboljiStrijelciViewModel
import kotlinx.android.synthetic.main.fragment_najbolji_strijelci.*
import kotlinx.android.synthetic.main.fragment_najbolji_strijelci.view.*
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class NajboljiStrijelciFragment : Fragment() {

    @InternalCoroutinesApi
    private val mNajboljiStrijelacViewModel: NajboljiStrijelciViewModel by viewModels()

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_najbolji_strijelci,container, false)

        //RecyclerView
        val adapter = NajboljiStrijelciAdapter()
        val recyclerNajboljiStrijelci = view.recyclerViewNajboljiStrijelci
        recyclerNajboljiStrijelci.adapter = adapter
        recyclerNajboljiStrijelci.layoutManager = LinearLayoutManager(requireContext())

        //NajboljiStrijelciViewModel
        mNajboljiStrijelacViewModel.readAllDataNajboljiStrijelci.observe(viewLifecycleOwner, Observer { najboljiStrijelac ->
            adapter.setData(najboljiStrijelac)
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewNajboljiStrijelci.addItemDecoration(DividerItemDecoration
            (recyclerViewNajboljiStrijelci.context,DividerItemDecoration.VERTICAL))

    }
}