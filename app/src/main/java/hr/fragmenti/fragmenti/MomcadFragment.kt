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
import hr.adapteri.MomcadAdapter
import hr.database.NKJaksicDatabase
import hr.database.table.Igraci
import hr.dominik.nkjaki.R
import hr.viewModel.MomcadViewModel
import kotlinx.android.synthetic.main.fragment_momcad.*
import kotlinx.android.synthetic.main.fragment_momcad.view.*
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class MomcadFragment: Fragment() {

    @InternalCoroutinesApi
    private val mMomcadViewModel: MomcadViewModel by viewModels()

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_momcad,container,false)

        //RecyclerView
        val adapter = MomcadAdapter()
        val recyclerMomcad = view.recyclerViewMomcad
        recyclerMomcad.adapter = adapter
        recyclerMomcad.layoutManager = LinearLayoutManager(requireContext())

        //MomcadViewModel
        mMomcadViewModel.readAllDataMomcad.observe(viewLifecycleOwner, Observer { momcad ->
            adapter.setData(momcad)
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewMomcad.addItemDecoration(DividerItemDecoration
            (recyclerViewMomcad.context,DividerItemDecoration.VERTICAL))

    }
}