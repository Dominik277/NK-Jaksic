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
import hr.database.table.TablicaRaspored
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.UpdateTablicaRasporedFragmentBinding
import hr.viewModel.TablicaRasporedViewModel
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class UpdateTablicaRasporedFragment : Fragment(R.layout.update_tablica_raspored_fragment) {

    private val args by navArgs<UpdateTablicaRasporedFragmentArgs>()

    @InternalCoroutinesApi
    private val mTablicaRasporedViewModel: TablicaRasporedViewModel by viewModels()
    private lateinit var binding: UpdateTablicaRasporedFragmentBinding

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = UpdateTablicaRasporedFragmentBinding.bind(view)

        binding.updateRasporedLigaBrojKola.setText(args.updateRasporedLigaArgs.brojKola)

        binding.updateRasporedLigaPrviDatum.setText(args.updateRasporedLigaArgs.prvaUtakmicaDatum)
        binding.updateRasporedLigaPrviDomacin.setText(args.updateRasporedLigaArgs.prvaUtakmicaDomacin)
        binding.updateRasporedLigaPrviGost.setText(args.updateRasporedLigaArgs.prvaUtakmicaGost)
        binding.updateRasporedLigaPrvoVrijeme.setText(args.updateRasporedLigaArgs.prvaUtakmicaVrijeme)

        binding.updateRasporedLigaDrugiDatum.setText(args.updateRasporedLigaArgs.drugaUtakmicaDatum)
        binding.updateRasporedLigaDrugiDomacin.setText(args.updateRasporedLigaArgs.drugaUtakmicaDomacin)
        binding.updateRasporedLigaDrugiGost.setText(args.updateRasporedLigaArgs.drugaUtakmicaGost)
        binding.updateRasporedLigaDrugoVrijeme.setText(args.updateRasporedLigaArgs.drugaUtakmicaVrijeme)

        binding.updateRasporedLigaTreciDatum.setText(args.updateRasporedLigaArgs.trecaUtakmicaDatum)
        binding.updateRasporedLigaTreciDomacin.setText(args.updateRasporedLigaArgs.trecaUtakmicaDomacin)
        binding.updateRasporedLigaTreciGost.setText(args.updateRasporedLigaArgs.trecaUtakmicaGost)
        binding.updateRasporedLigaTreceVrijeme.setText(args.updateRasporedLigaArgs.trecaUtakmicaVrijeme)

        binding.updateRasporedLigaCetvrtiDatum.setText(args.updateRasporedLigaArgs.cetvrtaUtakmicaDatum)
        binding.updateRasporedLigaCetvrtiDomacin.setText(args.updateRasporedLigaArgs.cetvrtaUtakmicaDomacin)
        binding.updateRasporedLigaCetvrtiGost.setText(args.updateRasporedLigaArgs.cetvrtaUtakmicaGost)
        binding.updateRasporedLigaCetvrtoVrijeme.setText(args.updateRasporedLigaArgs.cetvrtaUtakmicaVrijeme)

        binding.updateRasporedLigaPetiDatum.setText(args.updateRasporedLigaArgs.petaUtakmicaDatum)
        binding.updateRasporedLigaPetiDomacin.setText(args.updateRasporedLigaArgs.petaUtakmicaDomacin)
        binding.updateRasporedLigaPetiGost.setText(args.updateRasporedLigaArgs.petaUtakmicaGost)
        binding.updateRasporedLigaPetoVrijeme.setText(args.updateRasporedLigaArgs.petaUtakmicaVrijeme)

        binding.updateRasporedLigaSestiDatum.setText(args.updateRasporedLigaArgs.sestaUtakmicaDatum)
        binding.updateRasporedLigaSestiDomacin.setText(args.updateRasporedLigaArgs.sestaUtakmicaDomacin)
        binding.updateRasporedLigaSestiGost.setText(args.updateRasporedLigaArgs.sestaUtakmicaGost)
        binding.updateRasporedLigaSestoVrijeme.setText(args.updateRasporedLigaArgs.sestaUtakmicaVrijeme)

        binding.updateRasporedLigaSedmiDatum.setText(args.updateRasporedLigaArgs.sedmaUtakmicaDatum)
        binding.updateRasporedLigaSedmiDomacin.setText(args.updateRasporedLigaArgs.sedmaUtakmicaDomacin)
        binding.updateRasporedLigaSedmiGost.setText(args.updateRasporedLigaArgs.sedmaUtakmicaGost)
        binding.updateRasporedLigaSedmoVrijeme.setText(args.updateRasporedLigaArgs.sedmaUtakmicaVrijeme)

        binding.gumbUpdateTablicaRaspored.setOnClickListener {
            updateItemTablcaRaspored()
        }

        binding.gumbDeleteTablicaRaspored.setOnClickListener {
            deleteItemTablicaRaspored()
        }
    }

    @InternalCoroutinesApi
    private fun deleteItemTablicaRaspored() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Da") { _, _ ->
            mTablicaRasporedViewModel.deleteTablicaRaspored(args.updateRasporedLigaArgs)
            Toast.makeText(requireContext(), "Brisanje uspješno!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateTablicaRasporedFragment_to_tablicaRasporedFragment)
        }
        builder.setNegativeButton("Ne") { _, _ -> }
        builder.setTitle("Obrisati?")
        builder.setMessage("Jeste li sigurni da želite obrisati?")
        builder.create().show()
    }

    @InternalCoroutinesApi
    private fun updateItemTablcaRaspored() {

        val rasporedLigaBrojKola = binding.updateRasporedLigaBrojKola.text.toString()

        val rasporedLigaPrviDatum = binding.updateRasporedLigaPrviDatum.text.toString()
        val rasporedLigaPrviDomacin = binding.updateRasporedLigaPrviDomacin.text.toString()
        val rasporedLigaPrviGost = binding.updateRasporedLigaPrviGost.text.toString()
        val rasporedLigaPrvoVrijeme = binding.updateRasporedLigaPrvoVrijeme.text.toString()

        val rasporedLigaDrugiDatum = binding.updateRasporedLigaDrugiDatum.text.toString()
        val rasporedLigaDrugiDomacin = binding.updateRasporedLigaDrugiDomacin.text.toString()
        val rasporedLigaDrugiGost = binding.updateRasporedLigaDrugiGost.text.toString()
        val rasporedLigaDrugiVrijeme = binding.updateRasporedLigaDrugoVrijeme.text.toString()

        val rasporedLigaTreciDatum = binding.updateRasporedLigaTreciDatum.text.toString()
        val rasporedLigaTreciDomacin = binding.updateRasporedLigaTreciDomacin.text.toString()
        val rasporedLigaTreciGost = binding.updateRasporedLigaTreciGost.text.toString()
        val rasporedLigaTreciVrijeme = binding.updateRasporedLigaTreceVrijeme.text.toString()

        val rasporedLigaCetvrtiDatum = binding.updateRasporedLigaCetvrtiDatum.text.toString()
        val rasporedLigaCetvrtiDomacin = binding.updateRasporedLigaCetvrtiDomacin.text.toString()
        val rasporedLigaCetvrtiGost = binding.updateRasporedLigaCetvrtiGost.text.toString()
        val rasporedLigaCetvrtiVrijeme = binding.updateRasporedLigaCetvrtoVrijeme.text.toString()

        val rasporedLigaPetiDatum = binding.updateRasporedLigaPetiDatum.text.toString()
        val rasporedLigaPetiDomacin = binding.updateRasporedLigaPetiDomacin.text.toString()
        val rasporedLigaPetiGost = binding.updateRasporedLigaPetiGost.text.toString()
        val rasporedLigaPetiVrijeme = binding.updateRasporedLigaPetoVrijeme.text.toString()

        val rasporedLigaSestiDatum = binding.updateRasporedLigaSestiDatum.text.toString()
        val rasporedLigaSestiDomacin = binding.updateRasporedLigaSestiDomacin.text.toString()
        val rasporedLigaSestiGost = binding.updateRasporedLigaSestiGost.text.toString()
        val rasporedLigaSestiVrijeme = binding.updateRasporedLigaSestoVrijeme.text.toString()

        val rasporedLigaSedmiDatum = binding.updateRasporedLigaSedmiDatum.text.toString()
        val rasporedLigaSedmiDomacin = binding.updateRasporedLigaSedmiDomacin.text.toString()
        val rasporedLigaSedmiGost = binding.updateRasporedLigaSedmiGost.text.toString()
        val rasporedLigaSedmiVrijeme = binding.updateRasporedLigaSedmoVrijeme.text.toString()

        val updateRasporedTablica = TablicaRaspored(
            args.updateRasporedLigaArgs.id,
            rasporedLigaBrojKola,
            rasporedLigaPrviDatum,
            rasporedLigaPrviDomacin,
            rasporedLigaPrviGost,
            rasporedLigaPrvoVrijeme,
            rasporedLigaDrugiDatum,
            rasporedLigaDrugiDomacin,
            rasporedLigaDrugiGost,
            rasporedLigaDrugiVrijeme,
            rasporedLigaTreciDatum,
            rasporedLigaTreciDomacin,
            rasporedLigaTreciGost,
            rasporedLigaTreciVrijeme,
            rasporedLigaCetvrtiDatum,
            rasporedLigaCetvrtiDomacin,
            rasporedLigaCetvrtiGost,
            rasporedLigaCetvrtiVrijeme,
            rasporedLigaPetiDatum,
            rasporedLigaPetiDomacin,
            rasporedLigaPetiGost,
            rasporedLigaPetiVrijeme,
            rasporedLigaSestiDatum,
            rasporedLigaSestiDomacin,
            rasporedLigaSestiGost,
            rasporedLigaSestiVrijeme,
            rasporedLigaSedmiDatum,
            rasporedLigaSedmiDomacin,
            rasporedLigaSedmiGost,
            rasporedLigaSedmiVrijeme
        )

        mTablicaRasporedViewModel.updateTablicaRaspored(updateRasporedTablica)
        findNavController().navigate(R.id.action_updateTablicaRasporedFragment_to_tablicaRasporedFragment)
    }

}