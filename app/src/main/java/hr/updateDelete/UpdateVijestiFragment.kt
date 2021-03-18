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
import hr.database.table.Vijesti
import hr.dominik.nkjaki.R
import hr.viewModel.VijestiViewModel
import kotlinx.android.synthetic.main.update_vijesti_fragment.*
import kotlinx.android.synthetic.main.update_vijesti_fragment.view.*
import kotlinx.coroutines.InternalCoroutinesApi
import java.text.SimpleDateFormat
import java.util.*

class UpdateVijestiFragment: Fragment() {

    private val args by navArgs<UpdateVijestiFragmentArgs>()
    @InternalCoroutinesApi
    private lateinit var mVijestiViewModel: VijestiViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.update_vijesti_fragment,container,false)

        mVijestiViewModel = ViewModelProvider(this).get(VijestiViewModel::class.java)

        view.updateVijestiNaslov.setText(args.updateVijestiArgs.naslov)
        view.updateVijestiClanak.setText(args.updateVijestiArgs.clanak)

        view.gumbUpdateVijesti.setOnClickListener {
            updateItemVijesti()
        }

        view.gumbDeleteVijesti.setOnClickListener {
            deleteItemVijesti()
        }

        return view
    }

    @InternalCoroutinesApi
    private fun deleteItemVijesti() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_, _ ->
            mVijestiViewModel.deleteVijesti(args.updateVijestiArgs)
            Toast.makeText(requireContext(),"Brisanje uspješno!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateVijestiFragment_to_nav_vijesti)
        }
        builder.setNegativeButton("No"){_, _ -> }
        builder.setTitle("Delete ?")
        builder.setMessage("Are you sure you want to delete ?")
        builder.create().show()
    }

    @InternalCoroutinesApi
    private fun updateItemVijesti() {
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        val naslovVijesti = updateVijestiNaslov.text.toString()
        val clanakVijesti = updateVijestiClanak.text.toString()
        val vrijemeVijesti = currentDate
        val slikaVijesti = 0

        val updateVijesti = Vijesti(args.updateVijestiArgs.id,naslovVijesti,clanakVijesti,vrijemeVijesti,slikaVijesti)
        mVijestiViewModel.updateVijesti(updateVijesti)
        findNavController().navigate(R.id.action_updateVijestiFragment_to_nav_vijesti)
    }

}