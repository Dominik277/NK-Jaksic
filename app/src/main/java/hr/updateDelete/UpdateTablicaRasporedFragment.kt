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
import hr.database.table.TablicaRaspored
import hr.dominik.nkjaki.R
import hr.viewModel.TablicaRasporedViewModel
import kotlinx.android.synthetic.main.update_tablica_raspored_fragment.*
import kotlinx.android.synthetic.main.update_tablica_raspored_fragment.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class UpdateTablicaRasporedFragment: Fragment() {

    private val args by navArgs<UpdateTablicaRasporedFragmentArgs>()
    @InternalCoroutinesApi
    private lateinit var mTablicaRasporedViewModel: TablicaRasporedViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.update_tablica_raspored_fragment,container,false)

        mTablicaRasporedViewModel = ViewModelProvider(this).get(TablicaRasporedViewModel::class.java)

        view.updateRasporedLigaBrojKola.setText(args.updateRasporedLigaArgs.brojKola)

        view.updateRasporedLigaPrviDatum.setText(args.updateRasporedLigaArgs.prvaUtakmicaDatum)
        view.updateRasporedLigaPrviDomacin.setText(args.updateRasporedLigaArgs.prvaUtakmicaDomacin)
        view.updateRasporedLigaPrviGost.setText(args.updateRasporedLigaArgs.prvaUtakmicaGost)
        view.updateRasporedLigaPrvoVrijeme.setText(args.updateRasporedLigaArgs.prvaUtakmicaVrijeme)

        view.updateRasporedLigaDrugiDatum.setText(args.updateRasporedLigaArgs.drugaUtakmicaDatum)
        view.updateRasporedLigaDrugiDomacin.setText(args.updateRasporedLigaArgs.drugaUtakmicaDomacin)
        view.updateRasporedLigaDrugiGost.setText(args.updateRasporedLigaArgs.drugaUtakmicaGost)
        view.updateRasporedLigaDrugoVrijeme.setText(args.updateRasporedLigaArgs.drugaUtakmicaVrijeme)

        view.updateRasporedLigaTreciDatum.setText(args.updateRasporedLigaArgs.trecaUtakmicaDatum)
        view.updateRasporedLigaTreciDomacin.setText(args.updateRasporedLigaArgs.trecaUtakmicaDomacin)
        view.updateRasporedLigaTreciGost.setText(args.updateRasporedLigaArgs.trecaUtakmicaGost)
        view.updateRasporedLigaTreceVrijeme.setText(args.updateRasporedLigaArgs.trecaUtakmicaVrijeme)

        view.updateRasporedLigaCetvrtiDatum.setText(args.updateRasporedLigaArgs.cetvrtaUtakmicaDatum)
        view.updateRasporedLigaCetvrtiDomacin.setText(args.updateRasporedLigaArgs.cetvrtaUtakmicaDomacin)
        view.updateRasporedLigaCetvrtiGost.setText(args.updateRasporedLigaArgs.cetvrtaUtakmicaGost)
        view.updateRasporedLigaCetvrtoVrijeme.setText(args.updateRasporedLigaArgs.cetvrtaUtakmicaVrijeme)

        view.updateRasporedLigaPetiDatum.setText(args.updateRasporedLigaArgs.petaUtakmicaDatum)
        view.updateRasporedLigaPetiDomacin.setText(args.updateRasporedLigaArgs.petaUtakmicaDomacin)
        view.updateRasporedLigaPetiGost.setText(args.updateRasporedLigaArgs.petaUtakmicaGost)
        view.updateRasporedLigaPetoVrijeme.setText(args.updateRasporedLigaArgs.petaUtakmicaVrijeme)

        view.updateRasporedLigaSestiDatum.setText(args.updateRasporedLigaArgs.sestaUtakmicaDatum)
        view.updateRasporedLigaSestiDomacin.setText(args.updateRasporedLigaArgs.sestaUtakmicaDomacin)
        view.updateRasporedLigaSestiGost.setText(args.updateRasporedLigaArgs.sestaUtakmicaGost)
        view.updateRasporedLigaSestoVrijeme.setText(args.updateRasporedLigaArgs.sestaUtakmicaVrijeme)

        view.updateRasporedLigaSedmiDatum.setText(args.updateRasporedLigaArgs.sedmaUtakmicaDatum)
        view.updateRasporedLigaSedmiDomacin.setText(args.updateRasporedLigaArgs.sedmaUtakmicaDomacin)
        view.updateRasporedLigaSedmiGost.setText(args.updateRasporedLigaArgs.sedmaUtakmicaGost)
        view.updateRasporedLigaSedmoVrijeme.setText(args.updateRasporedLigaArgs.sedmaUtakmicaVrijeme)

        view.gumbUpdateTablicaRaspored.setOnClickListener {
            updateItemTablcaRaspored()
        }

        view.gumbDeleteTablicaRaspored.setOnClickListener {
            deleteItemTablicaRaspored()
        }

        return view
    }

    @InternalCoroutinesApi
    private fun deleteItemTablicaRaspored() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_, _ ->
            mTablicaRasporedViewModel.deleteTablicaRaspored(args.updateRasporedLigaArgs)
            Toast.makeText(requireContext(),"Brisanje uspješno!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateTablicaRasporedFragment_to_tablicaRasporedFragment)
        }
        builder.setNegativeButton("No"){_, _ -> }
        builder.setTitle("Delete ?")
        builder.setMessage("Are you sure you want to delete ?")
        builder.create().show()
    }

    @InternalCoroutinesApi
    private fun updateItemTablcaRaspored() {

        val rasporedLigaBrojKola = updateRasporedLigaBrojKola.text.toString()

        val rasporedLigaPrviDatum = updateRasporedLigaPrviDatum.text.toString()
        val rasporedLigaPrviDomacin = updateRasporedLigaPrviDomacin.text.toString()
        val rasporedLigaPrviGost = updateRasporedLigaPrviGost.text.toString()
        val rasporedLigaPrvoVrijeme = updateRasporedLigaPrvoVrijeme.text.toString()

        val rasporedLigaDrugiDatum = updateRasporedLigaDrugiDatum.text.toString()
        val rasporedLigaDrugiDomacin = updateRasporedLigaDrugiDomacin.text.toString()
        val rasporedLigaDrugiGost = updateRasporedLigaDrugiGost.text.toString()
        val rasporedLigaDrugiVrijeme = updateRasporedLigaDrugoVrijeme.text.toString()

        val rasporedLigaTreciDatum = updateRasporedLigaTreciDatum.text.toString()
        val rasporedLigaTreciDomacin = updateRasporedLigaTreciDomacin.text.toString()
        val rasporedLigaTreciGost = updateRasporedLigaTreciGost.text.toString()
        val rasporedLigaTreciVrijeme = updateRasporedLigaTreceVrijeme.text.toString()

        val rasporedLigaCetvrtiDatum = updateRasporedLigaCetvrtiDatum.text.toString()
        val rasporedLigaCetvrtiDomacin = updateRasporedLigaCetvrtiDomacin.text.toString()
        val rasporedLigaCetvrtiGost = updateRasporedLigaCetvrtiGost.text.toString()
        val rasporedLigaCetvrtiVrijeme = updateRasporedLigaCetvrtoVrijeme.text.toString()

        val rasporedLigaPetiDatum = updateRasporedLigaPetiDatum.text.toString()
        val rasporedLigaPetiDomacin = updateRasporedLigaPetiDomacin.text.toString()
        val rasporedLigaPetiGost = updateRasporedLigaPetiGost.text.toString()
        val rasporedLigaPetiVrijeme = updateRasporedLigaPetoVrijeme.text.toString()

        val rasporedLigaSestiDatum = updateRasporedLigaSestiDatum.text.toString()
        val rasporedLigaSestiDomacin = updateRasporedLigaSestiDomacin.text.toString()
        val rasporedLigaSestiGost = updateRasporedLigaSestiGost.text.toString()
        val rasporedLigaSestiVrijeme = updateRasporedLigaSestoVrijeme.text.toString()

        val rasporedLigaSedmiDatum = updateRasporedLigaSedmiDatum.text.toString()
        val rasporedLigaSedmiDomacin = updateRasporedLigaSedmiDomacin.text.toString()
        val rasporedLigaSedmiGost = updateRasporedLigaSedmiGost.text.toString()
        val rasporedLigaSedmiVrijeme = updateRasporedLigaSedmoVrijeme.text.toString()

        val updateRasporedTablica = TablicaRaspored(args.updateRasporedLigaArgs.id,
            rasporedLigaBrojKola,
            rasporedLigaPrviDatum,rasporedLigaPrviDomacin,rasporedLigaPrviGost,rasporedLigaPrvoVrijeme,
            rasporedLigaDrugiDatum,rasporedLigaDrugiDomacin,rasporedLigaDrugiGost,rasporedLigaDrugiVrijeme,
            rasporedLigaTreciDatum,rasporedLigaTreciDomacin,rasporedLigaTreciGost,rasporedLigaTreciVrijeme,
            rasporedLigaCetvrtiDatum,rasporedLigaCetvrtiDomacin,rasporedLigaCetvrtiGost,rasporedLigaCetvrtiVrijeme,
            rasporedLigaPetiDatum,rasporedLigaPetiDomacin,rasporedLigaPetiGost,rasporedLigaPetiVrijeme,
            rasporedLigaSestiDatum,rasporedLigaSestiDomacin,rasporedLigaSestiGost,rasporedLigaSestiVrijeme,
            rasporedLigaSedmiDatum,rasporedLigaSedmiDomacin,rasporedLigaSedmiGost,rasporedLigaSedmiVrijeme)

        mTablicaRasporedViewModel.updateTablicaRaspored(updateRasporedTablica)
        findNavController().navigate(R.id.action_updateTablicaRasporedFragment_to_tablicaRasporedFragment)
    }

}