package hr.fragmenti.detailFragmenti

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.DetailRasporedFragmentBinding

class DetailRasporedFragment: Fragment(R.layout.detail_raspored_fragment) {

    private val args by navArgs<DetailRasporedFragmentArgs>()
    private lateinit var binding: DetailRasporedFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DetailRasporedFragmentBinding.bind(view)

        binding.detailRasporedNatjecanje.setText(args.detailRasporedArgs.natjecanje)
        binding.detailRasporedDatum.setText(args.detailRasporedArgs.datum)
        binding.detailRasporedDomacin.setText(args.detailRasporedArgs.domacin)
        binding.detailRasporedGost.setText(args.detailRasporedArgs.gost)
        binding.detailRasporedVrijeme.setText(args.detailRasporedArgs.vrijeme)
        binding.detailRasporedNedostaju.setText(args.detailRasporedArgs.nedostaju)
        binding.detailRasporedClanak.setText(args.detailRasporedArgs.clanak)
    }

}