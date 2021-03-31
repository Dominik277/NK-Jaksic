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
import hr.fragmenti.updateDelete.UpdateTablicaRezultatFragmentArgs
import hr.viewModel.TablicaRezultatiViewModel
import kotlinx.android.synthetic.main.update_tablica_rezultat_fragment.*
import kotlinx.android.synthetic.main.update_tablica_rezultat_fragment.view.*
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class UpdateTablicaRezultatFragment: Fragment() {

    private val args by navArgs<UpdateTablicaRezultatFragmentArgs>()
    @InternalCoroutinesApi
    private val mTablicaRezultat: TablicaRezultatiViewModel by viewModels()

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.update_tablica_rezultat_fragment,container,false)

        view.updateRezultatLigaBrojKola.setText(args.updateRezultatiLigaArgs.novi_brojKola)

        view.updateRezultatLigaPrviDatum.setText(args.updateRezultatiLigaArgs.novi_prvaUtakmicaDatum)
        view.updateRezultatLigaPrviDomacin.setText(args.updateRezultatiLigaArgs.novi_prvaUtakmicaDomacin)
        view.updateRezultatLigaPrviGost.setText(args.updateRezultatiLigaArgs.novi_prvaUtakmicaGost)
        view.updateRezultatLigaPrviRezultat.setText(args.updateRezultatiLigaArgs.novi_prvaUtakmicaRezultat)

        view.updateRezultatLigaDrugiDatum.setText(args.updateRezultatiLigaArgs.novi_drugaUtakmicaDatum)
        view.updateRezultatLigaDrugiDomacin.setText(args.updateRezultatiLigaArgs.novi_drugaUtakmicaDomacin)
        view.updateRezultatLigaDrugiGost.setText(args.updateRezultatiLigaArgs.novi_drugaUtakmicaGost)
        view.updateRezultatLigaDrugiRezultat.setText(args.updateRezultatiLigaArgs.novi_drugaUtakmicaRezultat)

        view.updateRezultatLigaTreciDatum.setText(args.updateRezultatiLigaArgs.novi_trecaUtakmicaDatum)
        view.updateRezultatLigaTreciDomacin.setText(args.updateRezultatiLigaArgs.novi_trecaUtakmicaDomacin)
        view.updateRezultatLigaTreciGost.setText(args.updateRezultatiLigaArgs.novi_trecaUtakmicaGost)
        view.updateRezultatLigaTreciRezultat.setText(args.updateRezultatiLigaArgs.novi_trecaUtakmicaRezultat)

        view.updateRezultatLigaCetvrtiDatum.setText(args.updateRezultatiLigaArgs.novi_cetvrtaUtakmicaDatum)
        view.updateRezultatLigaCetvrtiDomacin.setText(args.updateRezultatiLigaArgs.novi_cetvrtaUtakmicaDomacin)
        view.updateRezultatLigaCetvrtiGost.setText(args.updateRezultatiLigaArgs.novi_cetvrtaUtakmicaGost)
        view.updateRezultatLigaCetvrtiRezultat.setText(args.updateRezultatiLigaArgs.novi_cetvrtaUtakmicaRezultat)

        view.updateRezultatLigaPetiDatum.setText(args.updateRezultatiLigaArgs.novi_petaUtakmicaDatum)
        view.updateRezultatLigaPetiDomacin.setText(args.updateRezultatiLigaArgs.novi_petaUtakmicaDomacin)
        view.updateRezultatLigaPetiGost.setText(args.updateRezultatiLigaArgs.novi_petaUtakmicaGost)
        view.updateRezultatLigaPetiRezultat.setText(args.updateRezultatiLigaArgs.novi_petaUtakmicaRezultat)

        view.updateRezultatLigaSestiDatum.setText(args.updateRezultatiLigaArgs.novi_sestaUtakmicaDatum)
        view.updateRezultatLigaSestiDomacin.setText(args.updateRezultatiLigaArgs.novi_sestaUtakmicaDomacin)
        view.updateRezultatLigaSestiGost.setText(args.updateRezultatiLigaArgs.novi_sestaUtakmicaGost)
        view.updateRezultatLigaSestiRezultat.setText(args.updateRezultatiLigaArgs.novi_sestaUtakmicaRezultat)

        view.updateRezultatLigaSedmiDatum.setText(args.updateRezultatiLigaArgs.novi_sedmaUtakmicaDatum)
        view.updateRezultatLigaSedmiDomacin.setText(args.updateRezultatiLigaArgs.novi_sedmaUtakmicaDomacin)
        view.updateRezultatLigaSedmiGost.setText(args.updateRezultatiLigaArgs.novi_sedmaUtakmicaGost)
        view.updateRezultatLigaSedmiRezultat.setText(args.updateRezultatiLigaArgs.novi_sedmaUtakmicaRezultat)

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
        findNavController().navigate(R.id.action_updateTablicaRezultatFragment_to_tablicaRezultatiFragment)
    }

}