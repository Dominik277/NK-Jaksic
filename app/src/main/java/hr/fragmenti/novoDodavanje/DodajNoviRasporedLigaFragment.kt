package hr.fragmenti.novoDodavanje

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import hr.database.table.TablicaRaspored
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.FragmentNoviRasporedLigaBinding
import hr.viewModel.TablicaRasporedViewModel
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class DodajNoviRasporedLigaFragment : Fragment(R.layout.fragment_novi_raspored_liga) {

    @InternalCoroutinesApi
    private val mTablicaRasporedViewModel: TablicaRasporedViewModel by viewModels()
    private lateinit var binding: FragmentNoviRasporedLigaBinding

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNoviRasporedLigaBinding.bind(view)

        binding.gumbSpremiTablicaRaspored.setOnClickListener {
            val action =
                DodajNoviRasporedLigaFragmentDirections.actionDodajNoviRasporedLigaFragmentToTablicaRasporedFragment()
            findNavController().navigate(action)
            insertDataToDatabase()
        }
    }

    @InternalCoroutinesApi
    private fun insertDataToDatabase() {

        val noviRasporedLigaBrojKola = binding.noviRasporedLigaBrojKola.text.toString()

        val noviRasporedLigaPrviDatum = binding.noviRasporedLigaPrviDatum.text.toString()
        val noviRasporedLigaPrviDomacin = binding.noviRasporedLigaPrviDomacin.text.toString()
        val noviRasporedLigaPrviGost = binding.noviRasporedLigaPrviGost.text.toString()
        val noviRasporedLigaPrvoVrijeme = binding.noviRasporedLigaPrvoVrijeme.text.toString()

        val noviRasporedLigaDrugiDatum = binding.noviRasporedLigaDrugiDatum.text.toString()
        val noviRasporedLigaDrugiDomacin = binding.noviRasporedLigaDrugiDomacin.text.toString()
        val noviRasporedLigaDrugiGost = binding.noviRasporedLigaDrugiGost.text.toString()
        val noviRasporedLigaDrugoVrijeme = binding.noviRasporedLigaDrugoVrijeme.text.toString()

        val noviRasporedLigaTreciDatum = binding.noviRasporedLigaTreciDatum.text.toString()
        val noviRasporedLigaTreciDomacin = binding.noviRasporedLigaTreciDomacin.text.toString()
        val noviRasporedLigaTreciGost = binding.noviRasporedLigaTreciGost.text.toString()
        val noviRasporedLigaTreceVrijeme = binding.noviRasporedLigaTreceVrijeme.text.toString()

        val noviRasporedLigaCetvrtiDatum = binding.noviRasporedLigaCetvrtiDatum.text.toString()
        val noviRasporedLigaCetvrtiDomacin = binding.noviRasporedLigaCetvrtiDomacin.text.toString()
        val noviRasporedLigaCetvrtiGost = binding.noviRasporedLigaCetvrtiGost.text.toString()
        val noviRasporedLigaCetvrtoVrijeme = binding.noviRasporedLigaCetvrtoVrijeme.text.toString()


        val noviRasporedLigaPetiDatum = binding.noviRasporedLigaPetiDatum.text.toString()
        val noviRasporedLigaPetiDomacin = binding.noviRasporedLigaPetiDomacin.text.toString()
        val noviRasporedLigaPetiGost = binding.noviRasporedLigaPetiGost.text.toString()
        val noviRasporedLigaPetoVrijeme = binding.noviRasporedLigaPetoVrijeme.text.toString()

        val noviRasporedLigaSestiDatum = binding.noviRasporedLigaSestiDatum.text.toString()
        val noviRasporedLigaSestiDomacin = binding.noviRasporedLigaSestiDomacin.text.toString()
        val noviRasporedLigaSestiGost = binding.noviRasporedLigaSestiGost.text.toString()
        val noviRasporedLigaSestoVrijeme = binding.noviRasporedLigaSestoVrijeme.text.toString()

        val noviRasporedLigaSedmiDatum = binding.noviRasporedLigaSedmiDatum.text.toString()
        val noviRasporedLigaSedmiDomacin = binding.noviRasporedLigaSedmiDomacin.text.toString()
        val noviRasporedLigaSedmiGost = binding.noviRasporedLigaSedmiGost.text.toString()
        val noviRasporedLigaSedmoVrijeme = binding.noviRasporedLigaSedmoVrijeme.text.toString()

        //Create object
        val tablicaRaspored = TablicaRaspored(
            0,
            noviRasporedLigaBrojKola,
            noviRasporedLigaPrviDatum,
            noviRasporedLigaPrviDomacin,
            noviRasporedLigaPrviGost,
            noviRasporedLigaPrvoVrijeme,
            noviRasporedLigaDrugiDatum,
            noviRasporedLigaDrugiDomacin,
            noviRasporedLigaDrugiGost,
            noviRasporedLigaDrugoVrijeme,
            noviRasporedLigaTreciDatum,
            noviRasporedLigaTreciDomacin,
            noviRasporedLigaTreciGost,
            noviRasporedLigaTreceVrijeme,
            noviRasporedLigaCetvrtiDatum,
            noviRasporedLigaCetvrtiDomacin,
            noviRasporedLigaCetvrtiGost,
            noviRasporedLigaCetvrtoVrijeme,
            noviRasporedLigaPetiDatum,
            noviRasporedLigaPetiDomacin,
            noviRasporedLigaPetiGost,
            noviRasporedLigaPetoVrijeme,
            noviRasporedLigaSestiDatum,
            noviRasporedLigaSestiDomacin,
            noviRasporedLigaSestiGost,
            noviRasporedLigaSestoVrijeme,
            noviRasporedLigaSedmiDatum,
            noviRasporedLigaSedmiDomacin,
            noviRasporedLigaSedmiGost,
            noviRasporedLigaSedmoVrijeme
        )

        mTablicaRasporedViewModel.addTablicaRaspored(tablicaRaspored)
        Toast.makeText(requireContext(), "Uspješno dodano", Toast.LENGTH_LONG).show()

    }
}