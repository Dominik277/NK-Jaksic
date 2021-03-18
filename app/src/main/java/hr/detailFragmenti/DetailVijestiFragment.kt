package hr.detailFragmenti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import hr.dominik.nkjaki.R
import hr.viewModel.VijestiViewModel
import kotlinx.android.synthetic.main.detail_vijesti_fragment.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class DetailVijestiFragment: Fragment() {

    private val args by navArgs<DetailVijestiFragmentArgs>()
    @InternalCoroutinesApi
    private lateinit var mVijestiViewModel: VijestiViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.detail_vijesti_fragment,container,false)

        mVijestiViewModel = ViewModelProvider(this).get(VijestiViewModel::class.java)

        view.detailVijestiNaslov.setText(args.detailVijestiArgs.naslov)
        view.detailVijestiClanak.setText(args.detailVijestiArgs.clanak)

        return view
    }

}