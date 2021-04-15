package hr.fragmenti.updateDelete

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import hr.database.table.Raspored
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.UpdateRasporedFragmentBinding
import hr.viewModel.RasporedViewModel
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class UpdateRasporedFragment : Fragment(R.layout.update_raspored_fragment) {

    private val args by navArgs<UpdateRasporedFragmentArgs>()

    @InternalCoroutinesApi
    private val mRasporedViewModel: RasporedViewModel by viewModels()
    private lateinit var binding: UpdateRasporedFragmentBinding

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateRasporedFragmentBinding.bind(view)

        binding.updateRasporedNatjecanje.setText(args.updateRasporedArgs.natjecanje)
        binding.updateRasporedDatum.setText(args.updateRasporedArgs.datum)
        binding.updateRasporedDomacin.setText(args.updateRasporedArgs.domacin)
        binding.updateRasporedGost.setText(args.updateRasporedArgs.gost)
        binding.updateRasporedVrijeme.setText(args.updateRasporedArgs.vrijeme)
        binding.updateRasporedNedostaje.setText(args.updateRasporedArgs.nedostaju)
        binding.updateRasporedClanak.setText(args.updateRasporedArgs.clanak)

        binding.gumbUpdateRaspored.setOnClickListener {
            updateItemRaspored()
        }

        binding.gumbDeleteRaspored.setOnClickListener {
            deleteItemRaspored()
        }
    }

    @InternalCoroutinesApi
    private fun deleteItemRaspored() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Da") { _, _ ->
            mRasporedViewModel.deleteRaspored(args.updateRasporedArgs)
            Toast.makeText(requireContext(), "Brisanje uspješno!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateRasporedFragment_to_rasporedFragment)
        }
        builder.setNegativeButton("Ne") { _, _ -> }
        builder.setTitle("Obrisati ${args.updateRasporedArgs.domacin}?")
        builder.setMessage("Jeste li sigurni da želite obrisati ${args.updateRasporedArgs.domacin}?")
        builder.create().show()
    }

    @InternalCoroutinesApi
    private fun updateItemRaspored() {
        val natjecanjeRaspored = binding.updateRasporedNatjecanje.text.toString()
        val datumRaspored = binding.updateRasporedDatum.text.toString()
        val domacinRaspored = binding.updateRasporedDomacin.text.toString()
        val gostRaspored = binding.updateRasporedGost.text.toString()
        val vrijemeRaspored = binding.updateRasporedVrijeme.text.toString()
        val nedostajeRaspored = binding.updateRasporedNedostaje.text.toString()
        val clanakRaspored = binding.updateRasporedClanak.text.toString()

        val updateRaspored = Raspored(
            args.updateRasporedArgs.id,
            natjecanjeRaspored,
            datumRaspored,
            domacinRaspored,
            gostRaspored,
            vrijemeRaspored,
            nedostajeRaspored,
            clanakRaspored
        )
        mRasporedViewModel.updateRaspored(updateRaspored)
        findNavController().navigate(R.id.action_updateRasporedFragment_to_rasporedFragment)
    }
}