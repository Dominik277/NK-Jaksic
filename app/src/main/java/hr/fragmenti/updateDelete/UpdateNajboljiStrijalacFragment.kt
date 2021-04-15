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
import hr.database.table.NajboljiStrijelci
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.UpdateStrijelciFragmentBinding
import hr.viewModel.NajboljiStrijelciViewModel
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class UpdateNajboljiStrijalacFragment : Fragment(R.layout.update_strijelci_fragment) {

    private val args by navArgs<UpdateNajboljiStrijalacFragmentArgs>()

    @InternalCoroutinesApi
    private val mStrijeciViewModel: NajboljiStrijelciViewModel by viewModels()
    private lateinit var binding: UpdateStrijelciFragmentBinding

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateStrijelciFragmentBinding.bind(view)

        binding.updateStrijelciPozicija.setText(args.updateStrijelciArgs.pozicijaPoGolovima)
        binding.updateStrijelciImePrezime.setText(args.updateStrijelciArgs.imeIgraca)
        binding.updateStrijeciBrojGolova.setText(args.updateStrijelciArgs.brojGolova)

        binding.gumbStrijelciUpdate.setOnClickListener {
            updateItemStrijelci()
        }

        binding.gumbStrijelciDelete.setOnClickListener {
            deleteItemStrijelci()
        }
    }

    @InternalCoroutinesApi
    private fun deleteItemStrijelci() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Da") { _, _ ->
            mStrijeciViewModel.deleteNajboljiStrijelci(args.updateStrijelciArgs)
            Toast.makeText(requireContext(), "Brisanje uspješno!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateNajboljiStrijalacFragment_to_najboljiStrijelciFragment)
        }
        builder.setNegativeButton("Ne") { _, _ -> }
        builder.setTitle("Obrisati ${args.updateStrijelciArgs.imeIgraca}?")
        builder.setMessage("Jeste li sigurni da želite obrisati ${args.updateStrijelciArgs.imeIgraca}?")
        builder.create().show()
    }

    @InternalCoroutinesApi
    private fun updateItemStrijelci() {
        val imeStrijelca = binding.updateStrijelciImePrezime.text.toString()
        val pozicijaStrijelca = binding.updateStrijelciPozicija.text.toString()
        val brojGolova = binding.updateStrijeciBrojGolova.text.toString()

        val updateStrijelac = NajboljiStrijelci(
            args.updateStrijelciArgs.id,
            pozicijaStrijelca,
            imeStrijelca,
            brojGolova
        )
        mStrijeciViewModel.updateNajboljiStrijalci(updateStrijelac)
        findNavController().navigate(R.id.action_updateNajboljiStrijalacFragment_to_najboljiStrijelciFragment)
    }

}