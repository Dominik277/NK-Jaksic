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
import hr.adapteri.VijestiAdapter
import hr.database.NKJaksicDatabase
import hr.database.table.Vijesti
import hr.dominik.nkjaki.R
import hr.viewModel.VijestiViewModel
import kotlinx.android.synthetic.main.fragment_vijesti.*
import kotlinx.android.synthetic.main.fragment_vijesti.view.*
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class VijestiFragment : Fragment() {

    @InternalCoroutinesApi
    private val mVijestiViewModel: VijestiViewModel by viewModels()

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_vijesti,container,false)

        //RecyclerView
        val adapter = VijestiAdapter()
        val recyclerVijesti = view.recyclerViewVijesti
        recyclerVijesti.adapter = adapter
        recyclerVijesti.layoutManager = LinearLayoutManager(requireContext())

        //VijestiViewModel
        mVijestiViewModel.readAllDataVijesti.observe(viewLifecycleOwner, Observer { vijesti ->
            adapter.setData(vijesti)
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewVijesti.addItemDecoration(DividerItemDecoration
            (recyclerViewVijesti.context,DividerItemDecoration.VERTICAL))

    }
}