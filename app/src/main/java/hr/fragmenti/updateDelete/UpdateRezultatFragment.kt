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
import hr.database.table.Rezultat
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.UpdateRezultatFragmentBinding
import hr.viewModel.RezultatViewModel
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class UpdateRezultatFragment : Fragment(R.layout.update_rezultat_fragment) {

    private val args by navArgs<UpdateRezultatFragmentArgs>()
    @InternalCoroutinesApi
    private val mRezultatiViewModel: RezultatViewModel by viewModels()
    private lateinit var binding: UpdateRezultatFragmentBinding

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateRezultatFragmentBinding.bind(view)

        binding.updateRezultatNatjecanje.setText(args.updateRezultatiArgs.natjecanjeRezultat)
        binding.updateRezultatDatum.setText(args.updateRezultatiArgs.datumRezultat)
        binding.updateRezultatDomacin.setText(args.updateRezultatiArgs.domacinRezultat)
        binding.updateRezultatGost.setText(args.updateRezultatiArgs.gostRezultat)
        binding.updateRezultatRezultat.setText(args.updateRezultatiArgs.rezultatUtakmice)
        binding.updateRezultatIshod.setText(args.updateRezultatiArgs.ishodRezultat)
        binding.updateRezultatPostave.setText(args.updateRezultatiArgs.postaveRezultati)
        binding.updateRezultatDetalji.setText(args.updateRezultatiArgs.detaljiRezultati)
        binding.updateRezultatClanak.setText(args.updateRezultatiArgs.clanakRezultat)

        binding.gumbRezultatUpdate.setOnClickListener {
            updateItemRezultat()
        }

        binding.gumbDeleteRezultat.setOnClickListener {
            deleteItemRezultat()
        }
    }

    @InternalCoroutinesApi
    private fun deleteItemRezultat() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mRezultatiViewModel.deleteRezultat(args.updateRezultatiArgs)
            Toast.makeText(requireContext(), "Brisanje uspješno!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateRezultatFragment_to_rezultatiFragment)
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete ${args.updateRezultatiArgs.domacinRezultat}?")
        builder.setMessage("Are you sure you want to delete ${args.updateRezultatiArgs.domacinRezultat}?")
        builder.create().show()
    }

    @InternalCoroutinesApi
    private fun updateItemRezultat() {

        val rezultatNatjecanje = binding.updateRezultatNatjecanje.text.toString()
        val rezultatDatum = binding.updateRezultatDatum.text.toString()
        val rezultatDomacin = binding.updateRezultatDomacin.text.toString()
        val rezultatGost = binding.updateRezultatGost.text.toString()
        val rezultatRezultat = binding.updateRezultatRezultat.text.toString()
        val rezultatIshod = binding.updateRezultatIshod.text.toString()
        val rezultatPostave = binding.updateRezultatPostave.text.toString()
        val rezultatDetalji = binding.updateRezultatDetalji.text.toString()
        val rezultatClanak = binding.updateRezultatClanak.text.toString()

        val updateRezultat = Rezultat(
            args.updateRezultatiArgs.id, rezultatNatjecanje, rezultatDatum,
            rezultatDomacin, rezultatGost, rezultatRezultat, rezultatIshod,
            rezultatPostave, rezultatDetalji, rezultatClanak
        )
        mRezultatiViewModel.updateRezultati(updateRezultat)
        findNavController().navigate(R.id.action_updateRezultatFragment_to_rezultatiFragment)

    }
}