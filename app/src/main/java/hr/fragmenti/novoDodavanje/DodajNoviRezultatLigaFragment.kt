package hr.fragmenti.novoDodavanje

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import hr.database.table.TablicaRezultati
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.FragmentNoviRezultatiLigaBinding
import hr.viewModel.TablicaRezultatiViewModel
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class DodajNoviRezultatLigaFragment : Fragment(R.layout.fragment_novi_rezultati_liga) {

    @InternalCoroutinesApi
    private val mTablicaRezultatViewModel: TablicaRezultatiViewModel by viewModels()
    private lateinit var binding: FragmentNoviRezultatiLigaBinding

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNoviRezultatiLigaBinding.bind(view)

        binding.gumbSpremiTablicaRezultat.setOnClickListener {
            val action =
                DodajNoviRezultatLigaFragmentDirections.actionDodajNoviRezultatLigaFragmentToTablicaRezultatiFragment()
            findNavController().navigate(action)
            insertDataToDatabase()
        }
    }

    @InternalCoroutinesApi
    private fun insertDataToDatabase() {
        val noviRezultatLigaBrojKola = binding.noviRezultatLigaBrojKola.text.toString()

        val noviRezultatLigaPrviDatum = binding.noviRezultatLigaPrviDatum.text.toString()
        val noviRezultatLigaPrviDomacin = binding.noviRezultatLigaPrviDomacin.text.toString()
        val noviRezultatLigaPrviGost = binding.noviRezultatLigaPrviGost.text.toString()
        val noviRezultatLigaPrvoVrijeme = binding.noviRezultatLigaPrviRezultat.text.toString()

        val noviRezultatLigaDrugiDatum = binding.noviRezultatLigaDrugiDatum.text.toString()
        val noviRezultatLigaDrugiDomacin = binding.noviRezultatLigaDrugiDomacin.text.toString()
        val noviRezultatLigaDrugiGost = binding.noviRezultatLigaDrugiGost.text.toString()
        val noviRezultatLigaDrugoVrijeme = binding.noviRezultatLigaDrugiRezultat.text.toString()

        val noviRezultatLigaTreciDatum = binding.noviRezultatLigaTreciDatum.text.toString()
        val noviRezultatLigaTreciDomacin = binding.noviRezultatLigaTreciDomacin.text.toString()
        val noviRezultatLigaTreciGost = binding.noviRezultatLigaTreciGost.text.toString()
        val noviRezultatLigaTreceVrijeme = binding.noviRezultatLigaTreciRezultat.text.toString()

        val noviRezultatLigaCetvrtiDatum = binding.noviRezultatLigaCetvrtiDatum.text.toString()
        val noviRezultatLigaCetvrtiDomacin = binding.noviRezultatLigaCetvrtiDomacin.text.toString()
        val noviRezultatLigaCetvrtiGost = binding.noviRezultatLigaCetvrtiGost.text.toString()
        val noviRezultatLigaCetvrtoVrijeme = binding.noviRezultatLigaCetvrtiRezultat.text.toString()


        val noviRezultatLigaPetiDatum = binding.noviRezultatLigaPetiDatum.text.toString()
        val noviRezultatLigaPetiDomacin = binding.noviRezultatLigaPetiDomacin.text.toString()
        val noviRezultatLigaPetiGost = binding.noviRezultatLigaPetiGost.text.toString()
        val noviRezultatLigaPetoVrijeme = binding.noviRezultatLigaPetiRezultat.text.toString()

        val noviRezultatLigaSestiDatum = binding.noviRezultatLigaSestiDatum.text.toString()
        val noviRezultatLigaSestiDomacin = binding.noviRezultatLigaSestiDomacin.text.toString()
        val noviRezultatLigaSestiGost = binding.noviRezultatLigaSestiGost.text.toString()
        val noviRezultatLigaSestoVrijeme = binding.noviRezultatLigaSestiRezultat.text.toString()

        val noviRezultatLigaSedmiDatum = binding.noviRezultatLigaSedmiDatum.text.toString()
        val noviRezultatLigaSedmiDomacin = binding.noviRezultatLigaSedmiDomacin.text.toString()
        val noviRezultatLigaSedmiGost = binding.noviRezultatLigaSedmiGost.text.toString()
        val noviRezultatLigaSedmoVrijeme = binding.noviRezultatLigaSedmiRezultat.text.toString()

        //Create object
        val tablicaRezultat = TablicaRezultati(
            0,
            noviRezultatLigaBrojKola,
            noviRezultatLigaPrviDatum,
            noviRezultatLigaPrviDomacin,
            noviRezultatLigaPrviGost,
            noviRezultatLigaPrvoVrijeme,
            noviRezultatLigaDrugiDatum,
            noviRezultatLigaDrugiDomacin,
            noviRezultatLigaDrugiGost,
            noviRezultatLigaDrugoVrijeme,
            noviRezultatLigaTreciDatum,
            noviRezultatLigaTreciDomacin,
            noviRezultatLigaTreciGost,
            noviRezultatLigaTreceVrijeme,
            noviRezultatLigaCetvrtiDatum,
            noviRezultatLigaCetvrtiDomacin,
            noviRezultatLigaCetvrtiGost,
            noviRezultatLigaCetvrtoVrijeme,
            noviRezultatLigaPetiDatum,
            noviRezultatLigaPetiDomacin,
            noviRezultatLigaPetiGost,
            noviRezultatLigaPetoVrijeme,
            noviRezultatLigaSestiDatum,
            noviRezultatLigaSestiDomacin,
            noviRezultatLigaSestiGost,
            noviRezultatLigaSestoVrijeme,
            noviRezultatLigaSedmiDatum,
            noviRezultatLigaSedmiDomacin,
            noviRezultatLigaSedmiGost,
            noviRezultatLigaSedmoVrijeme
        )

        mTablicaRezultatViewModel.addTablicaRezultat(tablicaRezultat)
        Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_LONG).show()

    }
}