package hr.fragmenti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import hr.adapteri.RasporedAdapter
import hr.database.NKJaksicDatabase
import hr.database.table.Raspored
import hr.dominik.nkjaki.R
import hr.viewModel.RasporedViewModel
import kotlinx.android.synthetic.main.fragment_raspored.*
import kotlinx.android.synthetic.main.fragment_raspored.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class RasporedFragment: Fragment(), RasporedAdapter.OnItemClickListener {

    private val adapter = RasporedAdapter(this)
    private val exampleList = emptyList<Raspored>()

    @InternalCoroutinesApi
    private lateinit var mRasporedViewModel: RasporedViewModel

    lateinit var navController: NavController

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_raspored, container, false)


        //RecyclerView
        val recyclerRaspored = view.recyclerViewRaspored
        recyclerRaspored.adapter = adapter
        recyclerRaspored.layoutManager = LinearLayoutManager(requireContext())

        //RasporedViewModel
        mRasporedViewModel = ViewModelProvider(this).get(RasporedViewModel::class.java)
        mRasporedViewModel.readAllData.observe(viewLifecycleOwner, Observer { raspored ->
            adapter.setData(raspored)
        })


        return view

    }

    override fun onItemClick(position: Int) {
        Toast.makeText(requireContext(), "Item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem: Raspored = exampleList[position]
        clickedItem.natjecanje = "Clicked"
        adapter.notifyItemChanged(position)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewRaspored.addItemDecoration(DividerItemDecoration
            (recyclerViewRaspored.context,DividerItemDecoration.VERTICAL))

    }
}