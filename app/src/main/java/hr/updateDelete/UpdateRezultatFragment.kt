package hr.updateDelete

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import hr.database.table.Rezultat
import hr.dominik.nkjaki.R
import hr.viewModel.RezultatViewModel
import kotlinx.android.synthetic.main.update_rezultat_fragment.*
import kotlinx.android.synthetic.main.update_rezultat_fragment.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class UpdateRezultatFragment : Fragment() {

    private val args by navArgs<UpdateRezultatFragmentArgs>()

    @InternalCoroutinesApi
    private lateinit var mRezultatiViewModel: RezultatViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.update_rezultat_fragment, container, false)

        mRezultatiViewModel = ViewModelProvider(this).get(RezultatViewModel::class.java)

        view.updateRezultatNatjecanje.setText(args.updateRezultatiArgs.natjecanjeRezultat)
        view.updateRezultatDatum.setText(args.updateRezultatiArgs.datumRezultat)
        view.updateRezultatDomacin.setText(args.updateRezultatiArgs.domacinRezultat)
        view.updateRezultatGost.setText(args.updateRezultatiArgs.gostRezultat)
        view.updateRezultatRezultat.setText(args.updateRezultatiArgs.rezultatUtakmice)
        view.updateRezultatIshod.setText(args.updateRezultatiArgs.ishodRezultat)

        view.gumbRezultatUpdate.setOnClickListener {
            updateItemRezultat()
        }

        view.gumbDeleteRezultat.setOnClickListener {
            deleteItemRezultat()
        }

        return view
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

        val rezultatNatjecanje = updateRezultatNatjecanje.text.toString()
        val rezultatDatum = updateRezultatDatum.text.toString()
        val rezultatDomacin = updateRezultatDomacin.text.toString()
        val rezultatGost = updateRezultatGost.text.toString()
        val rezultatRezultat = updateRezultatRezultat.text.toString()
        val rezultatIshod = updateRezultatIshod.text.toString()

        val updateRezultat = Rezultat(
            args.updateRezultatiArgs.id, rezultatNatjecanje, rezultatDatum,
            rezultatDomacin, rezultatGost, rezultatRezultat, rezultatIshod
        )
        mRezultatiViewModel.updateRezultati(updateRezultat)
        findNavController().navigate(R.id.action_updateRezultatFragment_to_rezultatiFragment)

    }

}