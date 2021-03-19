package hr.novoDodavanje

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import hr.database.table.TablicaRaspored
import hr.dominik.nkjaki.R
import hr.viewModel.TablicaRasporedViewModel
import kotlinx.android.synthetic.main.fragment_novi_raspored_liga.*
import kotlinx.android.synthetic.main.fragment_novi_raspored_liga.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class DodajNoviRasporedLigaFragment: Fragment() {

    @InternalCoroutinesApi
    private lateinit var mTablicaRasporedViewModel: TablicaRasporedViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_novi_raspored_liga,container, false)

        mTablicaRasporedViewModel = ViewModelProvider(this).get(TablicaRasporedViewModel::class.java)

        view.gumbSpremiTablicaRaspored.setOnClickListener {
            val action = DodajNoviRasporedLigaFragmentDirections.actionDodajNoviRasporedLigaFragmentToTablicaRasporedFragment()
            findNavController().navigate(action)
            insertDataToDatabase()
        }

        return view
    }

    @InternalCoroutinesApi
    private fun insertDataToDatabase() {

        val noviRasporedLigaBrojKola = noviRasporedLigaBrojKola.text.toString()

        val noviRasporedLigaPrviDatum = noviRasporedLigaPrviDatum.text.toString()
        val noviRasporedLigaPrviDomacin = noviRasporedLigaPrviDomacin.text.toString()
        val noviRasporedLigaPrviGost = noviRasporedLigaPrviGost.text.toString()
        val noviRasporedLigaPrvoVrijeme = noviRasporedLigaPrvoVrijeme.text.toString()

        val noviRasporedLigaDrugiDatum = noviRasporedLigaDrugiDatum.text.toString()
        val noviRasporedLigaDrugiDomacin = noviRasporedLigaDrugiDomacin.text.toString()
        val noviRasporedLigaDrugiGost = noviRasporedLigaDrugiGost.text.toString()
        val noviRasporedLigaDrugoVrijeme = noviRasporedLigaDrugoVrijeme.text.toString()

        val noviRasporedLigaTreciDatum = noviRasporedLigaTreciDatum.text.toString()
        val noviRasporedLigaTreciDomacin = noviRasporedLigaTreciDomacin.text.toString()
        val noviRasporedLigaTreciGost = noviRasporedLigaTreciGost.text.toString()
        val noviRasporedLigaTreceVrijeme = noviRasporedLigaTreceVrijeme.text.toString()

        val noviRasporedLigaCetvrtiDatum = noviRasporedLigaCetvrtiDatum.text.toString()
        val noviRasporedLigaCetvrtiDomacin = noviRasporedLigaCetvrtiDomacin.text.toString()
        val noviRasporedLigaCetvrtiGost = noviRasporedLigaCetvrtiGost.text.toString()
        val noviRasporedLigaCetvrtoVrijeme = noviRasporedLigaCetvrtoVrijeme.text.toString()


        val noviRasporedLigaPetiDatum = noviRasporedLigaPetiDatum.text.toString()
        val noviRasporedLigaPetiDomacin = noviRasporedLigaPetiDomacin.text.toString()
        val noviRasporedLigaPetiGost = noviRasporedLigaPetiGost.text.toString()
        val noviRasporedLigaPetoVrijeme = noviRasporedLigaPetoVrijeme.text.toString()

        val noviRasporedLigaSestiDatum = noviRasporedLigaSestiDatum.text.toString()
        val noviRasporedLigaSestiDomacin = noviRasporedLigaSestiDomacin.text.toString()
        val noviRasporedLigaSestiGost = noviRasporedLigaSestiGost.text.toString()
        val noviRasporedLigaSestoVrijeme = noviRasporedLigaSestoVrijeme.text.toString()

        val noviRasporedLigaSedmiDatum = noviRasporedLigaSedmiDatum.text.toString()
        val noviRasporedLigaSedmiDomacin = noviRasporedLigaSedmiDomacin.text.toString()
        val noviRasporedLigaSedmiGost = noviRasporedLigaSedmiGost.text.toString()
        val noviRasporedLigaSedmoVrijeme = noviRasporedLigaSedmoVrijeme.text.toString()

            //Create object
            val tablicaRaspored = TablicaRaspored(0,noviRasporedLigaBrojKola,
                noviRasporedLigaPrviDatum,noviRasporedLigaPrviDomacin,noviRasporedLigaPrviGost,noviRasporedLigaPrvoVrijeme,
                noviRasporedLigaDrugiDatum,noviRasporedLigaDrugiDomacin,noviRasporedLigaDrugiGost,noviRasporedLigaDrugoVrijeme,
                noviRasporedLigaTreciDatum,noviRasporedLigaTreciDomacin,noviRasporedLigaTreciGost,noviRasporedLigaTreceVrijeme,
                noviRasporedLigaCetvrtiDatum,noviRasporedLigaCetvrtiDomacin,noviRasporedLigaCetvrtiGost,noviRasporedLigaCetvrtoVrijeme,
                noviRasporedLigaPetiDatum,noviRasporedLigaPetiDomacin,noviRasporedLigaPetiGost,noviRasporedLigaPetoVrijeme,
                noviRasporedLigaSestiDatum,noviRasporedLigaSestiDomacin,noviRasporedLigaSestiGost,noviRasporedLigaSestoVrijeme,
                noviRasporedLigaSedmiDatum,noviRasporedLigaSedmiDomacin,noviRasporedLigaSedmiGost,noviRasporedLigaSedmoVrijeme)

            mTablicaRasporedViewModel.addTablicaRaspored(tablicaRaspored)
            Toast.makeText(requireContext(),"Successfully added", Toast.LENGTH_LONG).show()

    }
}