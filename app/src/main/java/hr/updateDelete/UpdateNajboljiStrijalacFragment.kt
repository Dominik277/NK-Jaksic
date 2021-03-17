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
import hr.database.table.NajboljiStrijelci
import hr.dominik.nkjaki.R
import hr.viewModel.NajboljiStrijelciViewModel
import kotlinx.android.synthetic.main.update_strijelci_fragment.*
import kotlinx.android.synthetic.main.update_strijelci_fragment.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class UpdateNajboljiStrijalacFragment: Fragment() {

    private val args by navArgs<UpdateNajboljiStrijalacFragmentArgs>()
    @InternalCoroutinesApi
    private lateinit var mStrijeciViewModel: NajboljiStrijelciViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.update_strijelci_fragment,container,false)

        mStrijeciViewModel = ViewModelProvider(this).get(NajboljiStrijelciViewModel::class.java)

        view.updateStrijelciPozicija.setText(args.updateStrijelciArgs.pozicijaPoGolovima)
        view.updateStrijelciImePrezime.setText(args.updateStrijelciArgs.imeIgraca)
        view.updateStrijeciBrojGolova.setText(args.updateStrijelciArgs.brojGolova)

        view.gumbStrijelciUpdate.setOnClickListener {
            updateItemStrijelci()
        }

        view.gumbStrijelciDelete.setOnClickListener {
            deleteItemStrijelci()
        }

        return view
    }

    @InternalCoroutinesApi
    private fun deleteItemStrijelci() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_, _ ->
            mStrijeciViewModel.deleteNajboljiStrijelci(args.updateStrijelciArgs)
            Toast.makeText(requireContext(),"Brisanje uspješno!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateNajboljiStrijalacFragment_to_najboljiStrijelciFragment)
        }
        builder.setNegativeButton("No"){_, _ -> }
        builder.setTitle("Delete ${args.updateStrijelciArgs.imeIgraca}?")
        builder.setMessage("Are you sure you want to delete ${args.updateStrijelciArgs.imeIgraca}?")
        builder.create().show()
    }

    @InternalCoroutinesApi
    private fun updateItemStrijelci() {
        val imeStrijelca = updateStrijelciImePrezime.text.toString()
        val pozicijaStrijelca = updateStrijelciPozicija.text.toString()
        val brojGolova = updateStrijeciBrojGolova.text.toString()

        val updateStrijelac = NajboljiStrijelci(args.updateStrijelciArgs.id,pozicijaStrijelca,imeStrijelca,brojGolova)
        mStrijeciViewModel.updateNajboljiStrijalci(updateStrijelac)
        findNavController().navigate(R.id.action_updateNajboljiStrijalacFragment_to_najboljiStrijelciFragment)
    }

}