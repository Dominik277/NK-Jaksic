package hr.novoDodavanje

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import hr.database.table.Igraci
import hr.dominik.nkjaki.R
import hr.viewModel.MomcadViewModel
import kotlinx.android.synthetic.main.fragment_nova_vijest.*
import kotlinx.android.synthetic.main.fragment_novi_igrac.*
import kotlinx.android.synthetic.main.fragment_novi_igrac.view.*
import kotlinx.coroutines.InternalCoroutinesApi
import java.util.jar.Manifest

class DodajNovogIgraca: Fragment() {

    @InternalCoroutinesApi
    private lateinit var mMomcadViewModel: MomcadViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_novi_igrac,container, false)

        mMomcadViewModel = ViewModelProvider(this).get(MomcadViewModel::class.java)

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

        val igrac = Igraci(0,igracIme,igracPrezime,igracPozicija,igracOdigraniSusreti,igracGolovi,igracAsistencije,igracOdigraneMinute,igracZutiKartoni,igracCrveniKartoni,igracBroj,igracOpis,igracSlika)
        mMomcadViewModel.addMomcad(igrac)
    }
}