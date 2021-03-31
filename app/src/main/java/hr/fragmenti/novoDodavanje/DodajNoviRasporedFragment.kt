package hr.fragmenti.novoDodavanje

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import hr.database.table.Raspored
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.FragmentNoviRasporedBinding
import hr.viewModel.RasporedViewModel
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class DodajNoviRasporedFragment : Fragment(R.layout.fragment_novi_raspored) {

    @InternalCoroutinesApi
    private val mRasporedViewModel: RasporedViewModel by viewModels()
    private lateinit var binding: FragmentNoviRasporedBinding

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNoviRasporedBinding.bind(view)

        binding.gumbSpremiNoviRaspored.setOnClickListener {
            val action =
                DodajNoviRasporedFragmentDirections.actionDodajNoviRasporedFragmentToRasporedFragment()
            findNavController().navigate(action)
            insertDataToDatabase()
        }
    }

    @InternalCoroutinesApi
    private fun insertDataToDatabase() {
        val noviRasporedNatjecanje = binding.noviRasporedNatjecanje.text.toString()
        val noviRasporedDatum = binding.noviRasporedDatum.text.toString()
        val noviRasporedDomacin = binding.noviRasporedDomacin.text.toString()
        val noviRasporedGost = binding.noviRasporedGost.text.toString()
        val noviRasporedVrijeme = binding.noviRasporedVrijeme.text.toString()
        val noviRasporedNedostaje = binding.noviRasporedNedostaju.text.toString()
        val noviRasporedClanak = binding.noviRasporedClanak.text.toString()

        //Create object
        val raspored = Raspored(
            0,
            noviRasporedNatjecanje,
            noviRasporedDatum,
            noviRasporedDomacin,
            noviRasporedGost,
            noviRasporedVrijeme,
            noviRasporedNedostaje,
            noviRasporedClanak
        )
        mRasporedViewModel.addRaspored(raspored)
        Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_LONG).show()

    }
}