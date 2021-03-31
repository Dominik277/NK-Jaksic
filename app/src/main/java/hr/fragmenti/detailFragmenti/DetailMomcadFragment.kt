package hr.fragmenti.detailFragmenti

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.DetailMomcadFragmentBinding

class DetailMomcadFragment : Fragment(R.layout.detail_momcad_fragment) {

    private val args by navArgs<DetailMomcadFragmentArgs>()
    private lateinit var binding: DetailMomcadFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DetailMomcadFragmentBinding.bind(view)

        binding.detailIgracIme.setText(args.detailMomcadArgs.ime)
        binding.detailIgracPrezime.setText(args.detailMomcadArgs.prezime)
        binding.detailIgracPozicija.setText(args.detailMomcadArgs.pozicija)
        binding.detailIgracOdigraniSusreti.setText(args.detailMomcadArgs.odigranihSusreta)
        binding.detailIgracGolovi.setText(args.detailMomcadArgs.golova)
        binding.detailIgracAsistencije.setText(args.detailMomcadArgs.asistencija)
        binding.detailIgracOdigraneMinute.setText(args.detailMomcadArgs.odigranihMinuta)
        binding.detailIgracZutiKartoni.setText(args.detailMomcadArgs.zutiKartoni)
        binding.detailIgracCrveniKartoni.setText(args.detailMomcadArgs.crveniKartoni)
        binding.detailIgracBroj.setText(args.detailMomcadArgs.broj)
        binding.detailIgracOpis.setText(args.detailMomcadArgs.opis)
    }

}