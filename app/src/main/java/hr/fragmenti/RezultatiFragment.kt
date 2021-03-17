package hr.fragmenti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import hr.adapteri.RezultatiAdapter
import hr.database.NKJaksicDatabase
import hr.database.table.Rezultat
import hr.dominik.nkjaki.R
import hr.viewModel.RasporedViewModel
import hr.viewModel.RezultatViewModel
import kotlinx.android.synthetic.main.fragment_rezultati.*
import kotlinx.android.synthetic.main.fragment_rezultati.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class RezultatiFragment: Fragment() {

    @InternalCoroutinesApi
    private lateinit var mRezultatViewModel: RezultatViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_rezultati, container, false)

        //RecyclerView
        val adapter = RezultatiAdapter()
        val recyclerRezultat = view.recyclerViewRezultati
        recyclerRezultat.adapter = adapter
        recyclerRezultat.layoutManager = LinearLayoutManager(requireContext())

        //RezultatiViewModel
        mRezultatViewModel = ViewModelProvider(this).get(RezultatViewModel::class.java)
        mRezultatViewModel.readAllDataRezultat.observe(viewLifecycleOwner, Observer { rezultat ->
            adapter.setData(rezultat)
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewRezultati.addItemDecoration(DividerItemDecoration
            (recyclerViewRezultati.context,DividerItemDecoration.VERTICAL))

    }
}