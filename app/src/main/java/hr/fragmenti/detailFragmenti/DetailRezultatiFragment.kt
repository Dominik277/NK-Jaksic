package hr.fragmenti.detailFragmenti

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.DetailRezultatiFragmentBinding

class DetailRezultatiFragment : Fragment(R.layout.detail_rezultati_fragment) {

    private val args by navArgs<DetailRezultatiFragmentArgs>()
    private lateinit var binding: DetailRezultatiFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DetailRezultatiFragmentBinding.bind(view)

        binding.detailRezultatNatjecanje.setText(args.detailRezultatArgs.natjecanjeRezultat)
        binding.detailRezultatDatum.setText(args.detailRezultatArgs.datumRezultat)
        binding.detailRezultatDomacin.setText(args.detailRezultatArgs.domacinRezultat)
        binding.detailRezultatGost.setText(args.detailRezultatArgs.gostRezultat)
        binding.detailRezultatRezultat.setText(args.detailRezultatArgs.rezultatUtakmice)
        binding.detailRezultatPostave.setText(args.detailRezultatArgs.postaveRezultati)
        binding.detailRezultatDetalji.setText(args.detailRezultatArgs.detaljiRezultati)
        binding.detailRezultatClanak.setText(args.detailRezultatArgs.clanakRezultat)
    }

}