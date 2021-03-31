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
import hr.database.table.Vijesti
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.UpdateVijestiFragmentBinding
import hr.viewModel.VijestiViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class UpdateVijestiFragment: Fragment(R.layout.update_vijesti_fragment) {

    private val args by navArgs<UpdateVijestiFragmentArgs>()
    @InternalCoroutinesApi
    private val mVijestiViewModel: VijestiViewModel by viewModels()
    private lateinit var binding: UpdateVijestiFragmentBinding

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateVijestiFragmentBinding.bind(view)

        binding.updateVijestiNaslov.setText(args.updateVijestiArgs.naslov)
        binding.updateVijestiClanak.setText(args.updateVijestiArgs.clanak)

        binding.gumbUpdateVijesti.setOnClickListener {
            updateItemVijesti()
        }

        binding.gumbDeleteVijesti.setOnClickListener {
            deleteItemVijesti()
        }
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

        val naslovVijesti = binding.updateVijestiNaslov.text.toString()
        val clanakVijesti = binding.updateVijestiClanak.text.toString()
        val vrijemeVijesti = currentDate
        val slikaVijesti = 0

        val updateVijesti = Vijesti(args.updateVijestiArgs.id,naslovVijesti,clanakVijesti,vrijemeVijesti,slikaVijesti)
        mVijestiViewModel.updateVijesti(updateVijesti)
        findNavController().navigate(R.id.action_updateVijestiFragment_to_nav_vijesti)
    }

}