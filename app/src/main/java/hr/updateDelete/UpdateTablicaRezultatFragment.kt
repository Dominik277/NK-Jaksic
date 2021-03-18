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
import hr.database.table.TablicaRezultati
import hr.dominik.nkjaki.R
import hr.viewModel.TablicaRezultatiViewModel
import kotlinx.android.synthetic.main.update_tablica_raspored_fragment.*
import kotlinx.android.synthetic.main.update_tablica_raspored_fragment.updateRasporedLigaBrojKola
import kotlinx.android.synthetic.main.update_tablica_raspored_fragment.view.*
import kotlinx.android.synthetic.main.update_tablica_rezultat_fragment.*
import kotlinx.android.synthetic.main.update_tablica_rezultat_fragment.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class UpdateTablicaRezultatFragment: Fragment() {

    private val args by navArgs<UpdateTablicaRezultatFragmentArgs>()
    @InternalCoroutinesApi
    private lateinit var mTablicaRezultat: TablicaRezultatiViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.update_tablica_rezultat_fragment,container,false)

        mTablicaRezultat = ViewModelProvider(this).get(TablicaRezultatiViewModel::class.java)

        view.updateRasporedLigaBrojKola.setText(args.updateRezultatiLigaArgs.novi_brojKola)

        view.updateRasporedLigaPrviDatum.setText(args.updateRezultatiLigaArgs.novi_prvaUtakmicaDatum)
        view.updateRasporedLigaPrviDomacin.setText(args.updateRezultatiLigaArgs.novi_prvaUtakmicaDomacin)
        view.updateRasporedLigaPrviGost.setText(args.updateRezultatiLigaArgs.novi_prvaUtakmicaGost)
        view.updateRasporedLigaPrvoVrijeme.setText(args.updateRezultatiLigaArgs.novi_prvaUtakmicaRezultat)

        view.updateRasporedLigaDrugiDatum.setText(args.updateRezultatiLigaArgs.novi_drugaUtakmicaDatum)
        view.updateRasporedLigaDrugiDomacin.setText(args.updateRezultatiLigaArgs.novi_drugaUtakmicaDomacin)
        view.updateRasporedLigaDrugiGost.setText(args.updateRezultatiLigaArgs.novi_drugaUtakmicaGost)
        view.updateRasporedLigaDrugoVrijeme.setText(args.updateRezultatiLigaArgs.novi_drugaUtakmicaRezultat)

        view.updateRasporedLigaTreciDatum.setText(args.updateRezultatiLigaArgs.novi_trecaUtakmicaDatum)
        view.updateRasporedLigaTreciDomacin.setText(args.updateRezultatiLigaArgs.novi_trecaUtakmicaDomacin)
        view.updateRasporedLigaTreciGost.setText(args.updateRezultatiLigaArgs.novi_trecaUtakmicaGost)
        view.updateRasporedLigaTreceVrijeme.setText(args.updateRezultatiLigaArgs.novi_trecaUtakmicaRezultat)

        view.updateRasporedLigaCetvrtiDatum.setText(args.updateRezultatiLigaArgs.novi_cetvrtaUtakmicaDatum)
        view.updateRasporedLigaCetvrtiDomacin.setText(args.updateRezultatiLigaArgs.novi_cetvrtaUtakmicaDomacin)
        view.updateRasporedLigaCetvrtiGost.setText(args.updateRezultatiLigaArgs.novi_cetvrtaUtakmicaGost)
        view.updateRasporedLigaCetvrtoVrijeme.setText(args.updateRezultatiLigaArgs.novi_cetvrtaUtakmicaRezultat)

        view.updateRasporedLigaPetiDatum.setText(args.updateRezultatiLigaArgs.novi_petaUtakmicaDatum)
        view.updateRasporedLigaPetiDomacin.setText(args.updateRezultatiLigaArgs.novi_petaUtakmicaDomacin)
        view.updateRasporedLigaPetiGost.setText(args.updateRezultatiLigaArgs.novi_petaUtakmicaGost)
        view.updateRasporedLigaPetoVrijeme.setText(args.updateRezultatiLigaArgs.novi_petaUtakmicaRezultat)

        view.updateRasporedLigaSestiDatum.setText(args.updateRezultatiLigaArgs.novi_sestaUtakmicaDatum)
        view.updateRasporedLigaSestiDomacin.setText(args.updateRezultatiLigaArgs.novi_sestaUtakmicaDomacin)
        view.updateRasporedLigaSestiGost.setText(args.updateRezultatiLigaArgs.novi_sestaUtakmicaGost)
        view.updateRasporedLigaSestoVrijeme.setText(args.updateRezultatiLigaArgs.novi_sestaUtakmicaRezultat)

        view.updateRasporedLigaSedmiDatum.setText(args.updateRezultatiLigaArgs.novi_sedmaUtakmicaDatum)
        view.updateRasporedLigaSedmiDomacin.setText(args.updateRezultatiLigaArgs.novi_sedmaUtakmicaDomacin)
        view.updateRasporedLigaSedmiGost.setText(args.updateRezultatiLigaArgs.novi_sedmaUtakmicaGost)
        view.updateRasporedLigaSedmoVrijeme.setText(args.updateRezultatiLigaArgs.novi_sedmaUtakmicaRezultat)

        view.gumbUpdateTablicaRezultat.setOnClickListener {
            updateItemTablicaRezultat()
        }

        view.gumbDeleteTablicaRezultat.setOnClickListener {
            deleteItemTablicaRezultat()
        }

        return view
    }

    @InternalCoroutinesApi
    private fun deleteItemTablicaRezultat() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_, _ ->
            mTablicaRezultat.deleteTablicaRezultat(args.updateRezultatiLigaArgs)
            Toast.makeText(requireContext(),"Brisanje uspješno!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateTablicaRezultatFragment_to_tablicaRezultatiFragment)
        }
        builder.setNegativeButton("No"){_, _ -> }
        builder.setTitle("Delete ?")
        builder.setMessage("Are you sure you want to delete ?")
        builder.create().show()
    }

    @InternalCoroutinesApi
    private fun updateItemTablicaRezultat() {
        val rezultatLigaBrojKola = updateRezultatLigaBrojKola.text.toString()

        val rezultatLigaPrviDatum = updateRezultatLigaPrviDatum.text.toString()
        val rezultatLigaPrviDomacin = updateRezultatLigaPrviDomacin.text.toString()
        val rezultatLigaPrviGost = updateRezultatLigaPrviGost.text.toString()
        val rezultatLigaPrviRezultat = updateRezultatLigaPrviRezultat.text.toString()

        val rezultatLigaDrugiDatum = updateRezultatLigaDrugiDatum.text.toString()
        val rezultatLigaDrugiDomacin = updateRezultatLigaDrugiDomacin.text.toString()
        val rezultatLigaDrugiGost = updateRezultatLigaDrugiGost.text.toString()
        val rezultatLigaDrugiRezultat = updateRezultatLigaDrugiRezultat.text.toString()

        val rezultatLigaTreciDatum = updateRezultatLigaTreciDatum.text.toString()
        val rezultatLigaTreciDomacin = updateRezultatLigaTreciDomacin.text.toString()
        val rezultatLigaTreciGost = updateRezultatLigaTreciGost.text.toString()
        val rezultatLigaTreciRezultat = updateRezultatLigaTreciRezultat.text.toString()

        val rezultatLigaCetvrtiDatum = updateRezultatLigaCetvrtiDatum.text.toString()
        val rezultatLigaCetvrtiDomacin = updateRezultatLigaCetvrtiDomacin.text.toString()
        val rezultatLigaCetvrtiGost = updateRezultatLigaCetvrtiGost.text.toString()
        val rezultatLigaCetvrtiRezultat = updateRezultatLigaCetvrtiRezultat.text.toString()

        val rezultatLigaPetiDatum = updateRezultatLigaPetiDatum.text.toString()
        val rezultatLigaPetiDomacin = updateRezultatLigaPetiDomacin.text.toString()
        val rezultatLigaPetiGost = updateRezultatLigaPetiGost.text.toString()
        val rezultatLigaPetiRezultat = updateRezultatLigaPetiRezultat.text.toString()

        val rezultatLigaSestiDatum = updateRezultatLigaSestiDatum.text.toString()
        val rezultatLigaSestiDomacin = updateRezultatLigaSestiDomacin.text.toString()
        val rezultatLigaSestiGost = updateRezultatLigaSestiGost.text.toString()
        val rezultatLigaSestiRezultat = updateRezultatLigaSestiRezultat.text.toString()

        val rezultatLigaSedmiDatum = updateRezultatLigaSedmiDatum.text.toString()
        val rezultatLigaSedmiDomacin = updateRezultatLigaSedmiDomacin.text.toString()
        val rezultatLigaSedmiGost = updateRezultatLigaSedmiGost.text.toString()
        val rezultatLigaSedmiRezultat = updateRezultatLigaSedmiRezultat.text.toString()

        val updateRezultatTablica = TablicaRezultati(args.updateRezultatiLigaArgs.novi_id,
            rezultatLigaBrojKola,
            rezultatLigaPrviDatum,rezultatLigaPrviDomacin,rezultatLigaPrviGost,rezultatLigaPrviRezultat,
            rezultatLigaDrugiDatum,rezultatLigaDrugiDomacin,rezultatLigaDrugiGost,rezultatLigaDrugiRezultat,
            rezultatLigaTreciDatum,rezultatLigaTreciDomacin,rezultatLigaTreciGost,rezultatLigaTreciRezultat,
            rezultatLigaCetvrtiDatum,rezultatLigaCetvrtiDomacin,rezultatLigaCetvrtiGost,rezultatLigaCetvrtiRezultat,
            rezultatLigaPetiDatum,rezultatLigaPetiDomacin,rezultatLigaPetiGost,rezultatLigaPetiRezultat,
            rezultatLigaSestiDatum,rezultatLigaSestiDomacin,rezultatLigaSestiGost,rezultatLigaSestiRezultat,
            rezultatLigaSedmiDatum,rezultatLigaSedmiDomacin,rezultatLigaSedmiGost,rezultatLigaSedmiRezultat)

        mTablicaRezultat.updateTablicaRezultat(updateRezultatTablica)
        findNavController().navigate(R.id.action_updateTablicaRasporedFragment_to_tablicaRasporedFragment)
    }

}