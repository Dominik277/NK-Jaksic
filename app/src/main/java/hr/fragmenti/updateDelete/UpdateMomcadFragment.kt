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
import hr.database.table.Igraci
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.UpdateMomcadFragmentBinding
import hr.viewModel.MomcadViewModel
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class UpdateMomcadFragment : Fragment(R.layout.update_momcad_fragment) {

    private val args by navArgs<UpdateMomcadFragmentArgs>()
    @InternalCoroutinesApi
    private val mMomcadViewModel: MomcadViewModel by viewModels()
    private lateinit var binding: UpdateMomcadFragmentBinding

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateMomcadFragmentBinding.bind(view)

        binding.updateMomcadIme.setText(args.updateMomcadArgs.ime)
        binding.updateMomcadPrezime.setText(args.updateMomcadArgs.prezime)
        binding.updateMomcadPozicija.setText(args.updateMomcadArgs.pozicija)
        binding.updateMomcadOdigraniSusreti.setText(args.updateMomcadArgs.odigranihSusreta)
        binding.updateMomcadGolovi.setText(args.updateMomcadArgs.golova)
        binding.updateMomcadAsistencije.setText(args.updateMomcadArgs.asistencija)
        binding.updateMomcadOdigraneMinute.setText(args.updateMomcadArgs.odigranihMinuta)
        binding.updateMomcadZutiKartoni.setText(args.updateMomcadArgs.zutiKartoni)
        binding.updateMomcadCrveniKartoni.setText(args.updateMomcadArgs.crveniKartoni)
        binding.updateMomcadBroj.setText(args.updateMomcadArgs.broj)
        binding.updateMomcadOpis.setText(args.updateMomcadArgs.opis)

        binding.gumbUpdateMomcad.setOnClickListener {
            updateItemMomcad()
        }

        binding.gumbDeleteMomcad.setOnClickListener {
            deleteItemMomcad()
        }
    }

    @InternalCoroutinesApi
    private fun deleteItemMomcad() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mMomcadViewModel.deleteMomcad(args.updateMomcadArgs)
            Toast.makeText(requireContext(), "Brisanje uspješno!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateMomcadFragment_to_momcadFragment)
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete ${args.updateMomcadArgs.ime}?")
        builder.setMessage("Are you sure you want to delete ${args.updateMomcadArgs.ime}?")
        builder.create().show()
    }

    @InternalCoroutinesApi
    private fun updateItemMomcad() {
        val imeMomcad = binding.updateMomcadIme.text.toString()
        val prezimeMomcad = binding.updateMomcadPrezime.text.toString()
        val pozicijaMomcad = binding.updateMomcadPozicija.text.toString()
        val odigraniSusretiMomcad = binding.updateMomcadOdigraniSusreti.text.toString()
        val goloviMomcad = binding.updateMomcadGolovi.text.toString()
        val asistencijeMomcad = binding.updateMomcadAsistencije.text.toString()
        val odigraneMinuteMomcad = binding.updateMomcadOdigraneMinute.text.toString()
        val zutiKartoniMomcad = binding.updateMomcadZutiKartoni.text.toString()
        val crveniKartoniMomcad = binding.updateMomcadCrveniKartoni.text.toString()
        val brojMomcad = binding.updateMomcadBroj.text.toString()
        val opisMomcad = binding.updateMomcadOpis.text.toString()
        val slikaMomcad = 0

        val updateMomcad = Igraci(
            args.updateMomcadArgs.id, imeMomcad, prezimeMomcad, pozicijaMomcad,
            odigraniSusretiMomcad, goloviMomcad, asistencijeMomcad, odigraneMinuteMomcad,
            zutiKartoniMomcad, crveniKartoniMomcad, brojMomcad, opisMomcad, slikaMomcad
        )
        mMomcadViewModel.updateMomcad(updateMomcad)
        findNavController().navigate(R.id.action_updateMomcadFragment_to_momcadFragment)
    }

}