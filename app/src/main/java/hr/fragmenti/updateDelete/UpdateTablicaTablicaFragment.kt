package hr.fragmenti.updateDelete

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import hr.database.table.TablicaTablica
import hr.dominik.nkjaki.R
import hr.fragmenti.updateDelete.UpdateTablicaTablicaFragmentArgs
import hr.viewModel.TablicaTablicaViewModel
import kotlinx.android.synthetic.main.update_tablica_tablica_fragment.*
import kotlinx.android.synthetic.main.update_tablica_tablica_fragment.view.*
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class UpdateTablicaTablicaFragment: Fragment() {

    private val args by navArgs<UpdateTablicaTablicaFragmentArgs>()
    @InternalCoroutinesApi
    private val mTablicaTablicaViewModel: TablicaTablicaViewModel by viewModels()

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.update_tablica_tablica_fragment,container,false)

        view.updateTablicaPozicija.setText(args.updateTablicaArgs.pozicija)
        view.updateTablicaImeTima.setText(args.updateTablicaArgs.imeTima)
        view.updateTablicaOdigraniSusreti.setText(args.updateTablicaArgs.odigraniSusreti)
        view.updateTablicaGolRazlika.setText(args.updateTablicaArgs.golRazlika)
        view.updateTablicaBodovi.setText(args.updateTablicaArgs.bodovi)

        view.gumbUpdateTablica.setOnClickListener {
            updateItemTablica()
        }

        view.gumbDeleteTablica.setOnClickListener {
            deleteItemTablica()
        }

        return view
    }

    @InternalCoroutinesApi
    private fun deleteItemTablica() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_, _ ->
            mTablicaTablicaViewModel.deleteTablicaTablica(args.updateTablicaArgs)
            Toast.makeText(requireContext(),"Brisanje uspješno!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateTablicaTablicaFragment_to_tablicaTablicaFragment)
        }
        builder.setNegativeButton("No"){_, _ -> }
        builder.setTitle("Delete ?")
        builder.setMessage("Are you sure you want to delete ?")
        builder.create().show()
    }

    @InternalCoroutinesApi
    private fun updateItemTablica() {

        val pozicijaTablica = updateTablicaPozicija.text.toString()
        val imeTimaTablica = updateTablicaImeTima.text.toString()
        val odigraniSusretiTablica = updateTablicaOdigraniSusreti.text.toString()
        val golRazlikaTablica = updateTablicaGolRazlika.text.toString()
        val bodovi = updateTablicaBodovi.text.toString()

        val updateTablica = TablicaTablica(args.updateTablicaArgs.id,pozicijaTablica,imeTimaTablica,odigraniSusretiTablica,golRazlikaTablica,bodovi)
        mTablicaTablicaViewModel.updateTablicaTablica(updateTablica)
        findNavController().navigate(R.id.action_updateTablicaTablicaFragment_to_tablicaTablicaFragment)

    }
}