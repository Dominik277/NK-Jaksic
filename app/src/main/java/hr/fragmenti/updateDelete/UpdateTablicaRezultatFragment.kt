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
import hr.database.table.TablicaRezultati
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.UpdateTablicaRezultatFragmentBinding
import hr.viewModel.TablicaRezultatiViewModel
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class UpdateTablicaRezultatFragment : Fragment(R.layout.update_tablica_rezultat_fragment) {

    private val args by navArgs<UpdateTablicaRezultatFragmentArgs>()

    @InternalCoroutinesApi
    private val mTablicaRezultat: TablicaRezultatiViewModel by viewModels()
    private lateinit var binding: UpdateTablicaRezultatFragmentBinding

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateTablicaRezultatFragmentBinding.bind(view)

        binding.updateRezultatLigaBrojKola.setText(args.updateRezultatiLigaArgs.novi_brojKola)

        binding.updateRezultatLigaPrviDatum.setText(args.updateRezultatiLigaArgs.novi_prvaUtakmicaDatum)
        binding.updateRezultatLigaPrviDomacin.setText(args.updateRezultatiLigaArgs.novi_prvaUtakmicaDomacin)
        binding.updateRezultatLigaPrviGost.setText(args.updateRezultatiLigaArgs.novi_prvaUtakmicaGost)
        binding.updateRezultatLigaPrviRezultat.setText(args.updateRezultatiLigaArgs.novi_prvaUtakmicaRezultat)

        binding.updateRezultatLigaDrugiDatum.setText(args.updateRezultatiLigaArgs.novi_drugaUtakmicaDatum)
        binding.updateRezultatLigaDrugiDomacin.setText(args.updateRezultatiLigaArgs.novi_drugaUtakmicaDomacin)
        binding.updateRezultatLigaDrugiGost.setText(args.updateRezultatiLigaArgs.novi_drugaUtakmicaGost)
        binding.updateRezultatLigaDrugiRezultat.setText(args.updateRezultatiLigaArgs.novi_drugaUtakmicaRezultat)

        binding.updateRezultatLigaTreciDatum.setText(args.updateRezultatiLigaArgs.novi_trecaUtakmicaDatum)
        binding.updateRezultatLigaTreciDomacin.setText(args.updateRezultatiLigaArgs.novi_trecaUtakmicaDomacin)
        binding.updateRezultatLigaTreciGost.setText(args.updateRezultatiLigaArgs.novi_trecaUtakmicaGost)
        binding.updateRezultatLigaTreciRezultat.setText(args.updateRezultatiLigaArgs.novi_trecaUtakmicaRezultat)

        binding.updateRezultatLigaCetvrtiDatum.setText(args.updateRezultatiLigaArgs.novi_cetvrtaUtakmicaDatum)
        binding.updateRezultatLigaCetvrtiDomacin.setText(args.updateRezultatiLigaArgs.novi_cetvrtaUtakmicaDomacin)
        binding.updateRezultatLigaCetvrtiGost.setText(args.updateRezultatiLigaArgs.novi_cetvrtaUtakmicaGost)
        binding.updateRezultatLigaCetvrtiRezultat.setText(args.updateRezultatiLigaArgs.novi_cetvrtaUtakmicaRezultat)

        binding.updateRezultatLigaPetiDatum.setText(args.updateRezultatiLigaArgs.novi_petaUtakmicaDatum)
        binding.updateRezultatLigaPetiDomacin.setText(args.updateRezultatiLigaArgs.novi_petaUtakmicaDomacin)
        binding.updateRezultatLigaPetiGost.setText(args.updateRezultatiLigaArgs.novi_petaUtakmicaGost)
        binding.updateRezultatLigaPetiRezultat.setText(args.updateRezultatiLigaArgs.novi_petaUtakmicaRezultat)

        binding.updateRezultatLigaSestiDatum.setText(args.updateRezultatiLigaArgs.novi_sestaUtakmicaDatum)
        binding.updateRezultatLigaSestiDomacin.setText(args.updateRezultatiLigaArgs.novi_sestaUtakmicaDomacin)
        binding.updateRezultatLigaSestiGost.setText(args.updateRezultatiLigaArgs.novi_sestaUtakmicaGost)
        binding.updateRezultatLigaSestiRezultat.setText(args.updateRezultatiLigaArgs.novi_sestaUtakmicaRezultat)

        binding.updateRezultatLigaSedmiDatum.setText(args.updateRezultatiLigaArgs.novi_sedmaUtakmicaDatum)
        binding.updateRezultatLigaSedmiDomacin.setText(args.updateRezultatiLigaArgs.novi_sedmaUtakmicaDomacin)
        binding.updateRezultatLigaSedmiGost.setText(args.updateRezultatiLigaArgs.novi_sedmaUtakmicaGost)
        binding.updateRezultatLigaSedmiRezultat.setText(args.updateRezultatiLigaArgs.novi_sedmaUtakmicaRezultat)

        binding.gumbUpdateTablicaRezultat.setOnClickListener {
            updateItemTablicaRezultat()
        }

        binding.gumbDeleteTablicaRezultat.setOnClickListener {
            deleteItemTablicaRezultat()
        }
    }

    @InternalCoroutinesApi
    private fun deleteItemTablicaRezultat() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mTablicaRezultat.deleteTablicaRezultat(args.updateRezultatiLigaArgs)
            Toast.makeText(requireContext(), "Brisanje uspješno!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateTablicaRezultatFragment_to_tablicaRezultatiFragment)
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete ?")
        builder.setMessage("Are you sure you want to delete ?")
        builder.create().show()
    }

    @InternalCoroutinesApi
    private fun updateItemTablicaRezultat() {
        val rezultatLigaBrojKola = binding.updateRezultatLigaBrojKola.text.toString()

        val rezultatLigaPrviDatum = binding.updateRezultatLigaPrviDatum.text.toString()
        val rezultatLigaPrviDomacin = binding.updateRezultatLigaPrviDomacin.text.toString()
        val rezultatLigaPrviGost = binding.updateRezultatLigaPrviGost.text.toString()
        val rezultatLigaPrviRezultat = binding.updateRezultatLigaPrviRezultat.text.toString()

        val rezultatLigaDrugiDatum = binding.updateRezultatLigaDrugiDatum.text.toString()
        val rezultatLigaDrugiDomacin = binding.updateRezultatLigaDrugiDomacin.text.toString()
        val rezultatLigaDrugiGost = binding.updateRezultatLigaDrugiGost.text.toString()
        val rezultatLigaDrugiRezultat = binding.updateRezultatLigaDrugiRezultat.text.toString()

        val rezultatLigaTreciDatum = binding.updateRezultatLigaTreciDatum.text.toString()
        val rezultatLigaTreciDomacin = binding.updateRezultatLigaTreciDomacin.text.toString()
        val rezultatLigaTreciGost = binding.updateRezultatLigaTreciGost.text.toString()
        val rezultatLigaTreciRezultat = binding.updateRezultatLigaTreciRezultat.text.toString()

        val rezultatLigaCetvrtiDatum = binding.updateRezultatLigaCetvrtiDatum.text.toString()
        val rezultatLigaCetvrtiDomacin = binding.updateRezultatLigaCetvrtiDomacin.text.toString()
        val rezultatLigaCetvrtiGost = binding.updateRezultatLigaCetvrtiGost.text.toString()
        val rezultatLigaCetvrtiRezultat = binding.updateRezultatLigaCetvrtiRezultat.text.toString()

        val rezultatLigaPetiDatum = binding.updateRezultatLigaPetiDatum.text.toString()
        val rezultatLigaPetiDomacin = binding.updateRezultatLigaPetiDomacin.text.toString()
        val rezultatLigaPetiGost = binding.updateRezultatLigaPetiGost.text.toString()
        val rezultatLigaPetiRezultat = binding.updateRezultatLigaPetiRezultat.text.toString()

        val rezultatLigaSestiDatum = binding.updateRezultatLigaSestiDatum.text.toString()
        val rezultatLigaSestiDomacin = binding.updateRezultatLigaSestiDomacin.text.toString()
        val rezultatLigaSestiGost = binding.updateRezultatLigaSestiGost.text.toString()
        val rezultatLigaSestiRezultat = binding.updateRezultatLigaSestiRezultat.text.toString()

        val rezultatLigaSedmiDatum = binding.updateRezultatLigaSedmiDatum.text.toString()
        val rezultatLigaSedmiDomacin = binding.updateRezultatLigaSedmiDomacin.text.toString()
        val rezultatLigaSedmiGost = binding.updateRezultatLigaSedmiGost.text.toString()
        val rezultatLigaSedmiRezultat = binding.updateRezultatLigaSedmiRezultat.text.toString()

        val updateRezultatTablica = TablicaRezultati(
            args.updateRezultatiLigaArgs.novi_id,
            rezultatLigaBrojKola,
            rezultatLigaPrviDatum,
            rezultatLigaPrviDomacin,
            rezultatLigaPrviGost,
            rezultatLigaPrviRezultat,
            rezultatLigaDrugiDatum,
            rezultatLigaDrugiDomacin,
            rezultatLigaDrugiGost,
            rezultatLigaDrugiRezultat,
            rezultatLigaTreciDatum,
            rezultatLigaTreciDomacin,
            rezultatLigaTreciGost,
            rezultatLigaTreciRezultat,
            rezultatLigaCetvrtiDatum,
            rezultatLigaCetvrtiDomacin,
            rezultatLigaCetvrtiGost,
            rezultatLigaCetvrtiRezultat,
            rezultatLigaPetiDatum,
            rezultatLigaPetiDomacin,
            rezultatLigaPetiGost,
            rezultatLigaPetiRezultat,
            rezultatLigaSestiDatum,
            rezultatLigaSestiDomacin,
            rezultatLigaSestiGost,
            rezultatLigaSestiRezultat,
            rezultatLigaSedmiDatum,
            rezultatLigaSedmiDomacin,
            rezultatLigaSedmiGost,
            rezultatLigaSedmiRezultat
        )

        mTablicaRezultat.updateTablicaRezultat(updateRezultatTablica)
        findNavController().navigate(R.id.action_updateTablicaRezultatFragment_to_tablicaRezultatiFragment)
    }

}