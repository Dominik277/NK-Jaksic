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
import hr.database.table.Igraci
import hr.dominik.nkjaki.R
import hr.updateDelete.UpdateMomcadFragmentArgs
import hr.viewModel.MomcadViewModel
import kotlinx.android.synthetic.main.update_momcad_fragment.*
import kotlinx.android.synthetic.main.update_momcad_fragment.view.*
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class UpdateMomcadFragment: Fragment() {

    private val args by navArgs<UpdateMomcadFragmentArgs>()
    @InternalCoroutinesApi
    private val mMomcadViewModel: MomcadViewModel by viewModels()

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.update_momcad_fragment,container,false)

        view.updateMomcadIme.setText(args.updateMomcadArgs.ime)
        view.updateMomcadPrezime.setText(args.updateMomcadArgs.prezime)
        view.updateMomcadPozicija.setText(args.updateMomcadArgs.pozicija)
        view.updateMomcadOdigraniSusreti.setText(args.updateMomcadArgs.odigranihSusreta)
        view.updateMomcadGolovi.setText(args.updateMomcadArgs.golova)
        view.updateMomcadAsistencije.setText(args.updateMomcadArgs.asistencija)
        view.updateMomcadOdigraneMinute.setText(args.updateMomcadArgs.odigranihMinuta)
        view.updateMomcadZutiKartoni.setText(args.updateMomcadArgs.zutiKartoni)
        view.updateMomcadCrveniKartoni.setText(args.updateMomcadArgs.crveniKartoni)
        view.updateMomcadBroj.setText(args.updateMomcadArgs.broj)
        view.updateMomcadOpis.setText(args.updateMomcadArgs.opis)

        view.gumbUpdateMomcad.setOnClickListener {
            updateItemMomcad()
        }

        view.gumbDeleteMomcad.setOnClickListener {
            deleteItemMomcad()
        }

        return view
    }

    @InternalCoroutinesApi
    private fun deleteItemMomcad() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_,_ ->
            mMomcadViewModel.deleteMomcad(args.updateMomcadArgs)
            Toast.makeText(requireContext(),"Brisanje uspješno!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateMomcadFragment_to_momcadFragment)
        }
        builder.setNegativeButton("No"){_, _ -> }
        builder.setTitle("Delete ${args.updateMomcadArgs.ime}?")
        builder.setMessage("Are you sure you want to delete ${args.updateMomcadArgs.ime}?")
        builder.create().show()
    }

    @InternalCoroutinesApi
    private fun updateItemMomcad() {
        val imeMomcad = updateMomcadIme.text.toString()
        val prezimeMomcad = updateMomcadPrezime.text.toString()
        val pozicijaMomcad = updateMomcadPozicija.text.toString()
        val odigraniSusretiMomcad = updateMomcadOdigraniSusreti.text.toString()
        val goloviMomcad = updateMomcadGolovi.text.toString()
        val asistencijeMomcad = updateMomcadAsistencije.text.toString()
        val odigraneMinuteMomcad = updateMomcadOdigraneMinute.text.toString()
        val zutiKartoniMomcad = updateMomcadZutiKartoni.text.toString()
        val crveniKartoniMomcad = updateMomcadCrveniKartoni.text.toString()
        val brojMomcad = updateMomcadBroj.text.toString()
        val opisMomcad = updateMomcadOpis.text.toString()
        val slikaMomcad = 0

        val updateMomcad = Igraci(args.updateMomcadArgs.id,imeMomcad,prezimeMomcad,pozicijaMomcad,
            odigraniSusretiMomcad,goloviMomcad,asistencijeMomcad,odigraneMinuteMomcad,
            zutiKartoniMomcad,crveniKartoniMomcad,brojMomcad,opisMomcad,slikaMomcad)
        mMomcadViewModel.updateMomcad(updateMomcad)
        findNavController().navigate(R.id.action_updateMomcadFragment_to_momcadFragment)
    }

}