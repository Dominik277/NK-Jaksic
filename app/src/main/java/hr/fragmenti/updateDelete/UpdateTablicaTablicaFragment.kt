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
import hr.database.table.TablicaTablica
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.UpdateTablicaTablicaFragmentBinding
import hr.viewModel.TablicaTablicaViewModel
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class UpdateTablicaTablicaFragment : Fragment(R.layout.update_tablica_tablica_fragment) {

    private val args by navArgs<UpdateTablicaTablicaFragmentArgs>()
    @InternalCoroutinesApi
    private val mTablicaTablicaViewModel: TablicaTablicaViewModel by viewModels()
    private lateinit var binding: UpdateTablicaTablicaFragmentBinding

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateTablicaTablicaFragmentBinding.bind(view)

        binding.updateTablicaPozicija.setText(args.updateTablicaArgs.pozicija)
        binding.updateTablicaImeTima.setText(args.updateTablicaArgs.imeTima)
        binding.updateTablicaOdigraniSusreti.setText(args.updateTablicaArgs.odigraniSusreti)
        binding.updateTablicaGolRazlika.setText(args.updateTablicaArgs.golRazlika)
        binding.updateTablicaBodovi.setText(args.updateTablicaArgs.bodovi)

        binding.gumbUpdateTablica.setOnClickListener {
            updateItemTablica()
        }

        binding.gumbDeleteTablica.setOnClickListener {
            deleteItemTablica()
        }

    }

    @InternalCoroutinesApi
    private fun deleteItemTablica() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mTablicaTablicaViewModel.deleteTablicaTablica(args.updateTablicaArgs)
            Toast.makeText(requireContext(), "Brisanje uspješno!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateTablicaTablicaFragment_to_tablicaTablicaFragment)
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete ?")
        builder.setMessage("Are you sure you want to delete ?")
        builder.create().show()
    }

    @InternalCoroutinesApi
    private fun updateItemTablica() {

        val pozicijaTablica = binding.updateTablicaPozicija.text.toString()
        val imeTimaTablica = binding.updateTablicaImeTima.text.toString()
        val odigraniSusretiTablica = binding.updateTablicaOdigraniSusreti.text.toString()
        val golRazlikaTablica = binding.updateTablicaGolRazlika.text.toString()
        val bodovi = binding.updateTablicaBodovi.text.toString()

        val updateTablica = TablicaTablica(
            args.updateTablicaArgs.id,
            pozicijaTablica,
            imeTimaTablica,
            odigraniSusretiTablica,
            golRazlikaTablica,
            bodovi
        )
        mTablicaTablicaViewModel.updateTablicaTablica(updateTablica)
        findNavController().navigate(R.id.action_updateTablicaTablicaFragment_to_tablicaTablicaFragment)

    }
}