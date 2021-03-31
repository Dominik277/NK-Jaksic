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
import hr.fragmenti.novoDodavanje.DodajNovogIgracaDirections
import hr.viewModel.MomcadViewModel
import kotlinx.android.synthetic.main.fragment_novi_igrac.*
import kotlinx.android.synthetic.main.fragment_novi_igrac.view.*
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class DodajNovogIgraca: Fragment() {

    @InternalCoroutinesApi
    private val mMomcadViewModel: MomcadViewModel by viewModels()

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_novi_igrac,container, false)

        view.gumbSpremiNoviIgrac.setOnClickListener {
            val action = DodajNovogIgracaDirections.actionDodajNovogIgraca2ToMomcadFragment()
            findNavController().navigate(action)
            insertDataToDatabase()
        }

        return view
    }

    @InternalCoroutinesApi
    private fun insertDataToDatabase() {
        val igracIme = noviIgracIme.text.toString()
        val igracPrezime = noviIgracPrezime.text.toString()
        val igracPozicija = noviIgracPozicija.text.toString()
        val igracOdigraniSusreti = noviIgracOdigraniSusreti.text.toString()
        val igracGolovi = noviIgracGolovi.text.toString()
        val igracAsistencije = noviIgracAsistencije.text.toString()
        val igracOdigraneMinute = noviIgracOdigraneMinute.text.toString()
        val igracZutiKartoni = noviIgracZutiKartoni.text.toString()
        val igracCrveniKartoni = noviIgracCrveniKartoni.text.toString()
        val igracOpis = noviIgracOpis.text.toString()
        val igracBroj = noviIgracBroj.text.toString()

        val igracSlika = R.drawable.face

        val igrac = Igraci(0,igracIme,igracPrezime,igracPozicija,igracOdigraniSusreti,igracGolovi,
            igracAsistencije,igracOdigraneMinute,igracZutiKartoni,igracCrveniKartoni,igracBroj,igracOpis,igracSlika)
        mMomcadViewModel.addMomcad(igrac)
    }
}