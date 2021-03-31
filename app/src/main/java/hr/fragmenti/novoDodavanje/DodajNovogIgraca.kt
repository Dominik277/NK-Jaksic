package hr.fragmenti.novoDodavanje

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import hr.database.table.Igraci
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.FragmentNoviIgracBinding
import hr.viewModel.MomcadViewModel
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class DodajNovogIgraca : Fragment(R.layout.fragment_novi_igrac) {

    @InternalCoroutinesApi
    private val mMomcadViewModel: MomcadViewModel by viewModels()
    private lateinit var binding: FragmentNoviIgracBinding

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNoviIgracBinding.bind(view)

        binding.gumbSpremiNoviIgrac.setOnClickListener {
            val action = DodajNovogIgracaDirections.actionDodajNovogIgraca2ToMomcadFragment()
            findNavController().navigate(action)
            insertDataToDatabase()
        }
    }

    @InternalCoroutinesApi
    private fun insertDataToDatabase() {
        val igracIme = binding.noviIgracIme.text.toString()
        val igracPrezime = binding.noviIgracPrezime.text.toString()
        val igracPozicija = binding.noviIgracPozicija.text.toString()
        val igracOdigraniSusreti = binding.noviIgracOdigraniSusreti.text.toString()
        val igracGolovi = binding.noviIgracGolovi.text.toString()
        val igracAsistencije = binding.noviIgracAsistencije.text.toString()
        val igracOdigraneMinute = binding.noviIgracOdigraneMinute.text.toString()
        val igracZutiKartoni = binding.noviIgracZutiKartoni.text.toString()
        val igracCrveniKartoni = binding.noviIgracCrveniKartoni.text.toString()
        val igracOpis = binding.noviIgracOpis.text.toString()
        val igracBroj = binding.noviIgracBroj.text.toString()

        val igracSlika = R.drawable.face

        val igrac = Igraci(
            0,
            igracIme,
            igracPrezime,
            igracPozicija,
            igracOdigraniSusreti,
            igracGolovi,
            igracAsistencije,
            igracOdigraneMinute,
            igracZutiKartoni,
            igracCrveniKartoni,
            igracBroj,
            igracOpis,
            igracSlika
        )
        mMomcadViewModel.addMomcad(igrac)
    }
}