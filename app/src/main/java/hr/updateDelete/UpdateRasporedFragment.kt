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
import hr.database.table.Raspored
import hr.dominik.nkjaki.R
import hr.viewModel.RasporedViewModel
import kotlinx.android.synthetic.main.update_raspored_fragment.*
import kotlinx.android.synthetic.main.update_raspored_fragment.view.*
import kotlinx.android.synthetic.main.update_tablica_raspored_fragment.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class UpdateRasporedFragment: Fragment() {

    private val args by navArgs<UpdateRasporedFragmentArgs>()
    @InternalCoroutinesApi
    private lateinit var mRasporedViewModel: RasporedViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.update_raspored_fragment,container, false)

        mRasporedViewModel = ViewModelProvider(this).get(RasporedViewModel::class.java)

        view.updateRasporedNatjecanje.setText(args.updateRasporedArgs.natjecanje)
        view.updateRasporedDatum.setText(args.updateRasporedArgs.datum)
        view.updateRasporedDomacin.setText(args.updateRasporedArgs.domacin)
        view.updateRasporedGost.setText(args.updateRasporedArgs.gost)
        view.updateRasporedVrijeme.setText(args.updateRasporedArgs.vrijeme)
        view.updateRasporedNedostaje.setText(args.updateRasporedArgs.nedostaju)
        view.updateRasporedClanak.setText(args.updateRasporedArgs.clanak)

        view.gumbUpdateRaspored.setOnClickListener {
            updateItemRaspored()
        }

        view.gumbDeleteRaspored.setOnClickListener {
            deleteItemRaspored()
        }

        return view
    }

    @InternalCoroutinesApi
    private fun deleteItemRaspored() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_, _ ->
            mRasporedViewModel.deleteRaspored(args.updateRasporedArgs)
            Toast.makeText(requireContext(),"Brisanje uspješno!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateRasporedFragment_to_rasporedFragment)
        }
        builder.setNegativeButton("No"){_, _ -> }
        builder.setTitle("Delete ${args.updateRasporedArgs.domacin}?")
        builder.setMessage("Are you sure you want to delete ${args.updateRasporedArgs.domacin}?")
        builder.create().show()
    }

    @InternalCoroutinesApi
    private fun updateItemRaspored() {
        val natjecanjeRaspored = updateRasporedNatjecanje.text.toString()
        val datumRaspored = updateRasporedDatum.text.toString()
        val domacinRaspored = updateRasporedDomacin.text.toString()
        val gostRaspored = updateRasporedGost.text.toString()
        val vrijemeRaspored = updateRasporedVrijeme.text.toString()
        val nedostajeRaspored = updateRasporedNedostaje.text.toString()
        val clanakRaspored = updateRasporedClanak.text.toString()

        val updateRaspored = Raspored(args.updateRasporedArgs.id,natjecanjeRaspored,datumRaspored,domacinRaspored,gostRaspored,vrijemeRaspored,nedostajeRaspored,clanakRaspored)
        mRasporedViewModel.updateRaspored(updateRaspored)
        findNavController().navigate(R.id.action_updateRasporedFragment_to_rasporedFragment)
    }

}