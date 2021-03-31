package hr.fragmenti.novoDodavanje

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import hr.database.table.Raspored
import hr.dominik.nkjaki.R
import hr.fragmenti.novoDodavanje.DodajNoviRasporedFragmentDirections
import hr.viewModel.RasporedViewModel
import kotlinx.android.synthetic.main.fragment_novi_raspored.*
import kotlinx.android.synthetic.main.fragment_novi_raspored.view.*
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class DodajNoviRasporedFragment: Fragment() {

    @InternalCoroutinesApi
    private val mRasporedViewModel: RasporedViewModel by viewModels()

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_novi_raspored,container, false)

        view.gumbSpremiNoviRaspored.setOnClickListener {
            val action =
                DodajNoviRasporedFragmentDirections.actionDodajNoviRasporedFragmentToRasporedFragment()
            findNavController().navigate(action)
            insertDataToDatabase()
        }
        return view
    }

    @InternalCoroutinesApi
    private fun insertDataToDatabase() {
        val noviRasporedNatjecanje = noviRasporedNatjecanje.text.toString()
        val noviRasporedDatum = noviRasporedDatum.text.toString()
        val noviRasporedDomacin = noviRasporedDomacin.text.toString()
        val noviRasporedGost = noviRasporedGost.text.toString()
        val noviRasporedVrijeme = noviRasporedVrijeme.text.toString()
        val noviRasporedNedostaje = noviRasporedNedostaju.text.toString()
        val noviRasporedClanak = noviRasporedClanak.text.toString()

            //Create object
            val raspored = Raspored(0,noviRasporedNatjecanje,noviRasporedDatum,noviRasporedDomacin,noviRasporedGost,noviRasporedVrijeme,noviRasporedNedostaje,noviRasporedClanak)
            mRasporedViewModel.addRaspored(raspored)
            Toast.makeText(requireContext(),"Successfully added",Toast.LENGTH_LONG).show()

    }
}