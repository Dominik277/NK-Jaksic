package hr.fragmenti.detailFragmenti

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.DetailVijestiFragmentBinding

class DetailVijestiFragment : Fragment(R.layout.detail_vijesti_fragment) {

    private val args by navArgs<DetailVijestiFragmentArgs>()
    private lateinit var binding: DetailVijestiFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DetailVijestiFragmentBinding.bind(view)

        binding.detailVijestiNaslov.setText(args.detailVijestiArgs.naslov)
        binding.detailVijestiClanak.setText(args.detailVijestiArgs.clanak)
    }

}