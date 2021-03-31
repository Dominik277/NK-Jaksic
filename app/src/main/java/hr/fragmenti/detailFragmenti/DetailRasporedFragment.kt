package hr.fragmenti.detailFragmenti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import hr.fragmenti.detailFragmenti.DetailRasporedFragmentArgs
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.detail_raspored_fragment.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class DetailRasporedFragment: Fragment() {

    private val args by navArgs<DetailRasporedFragmentArgs>()

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.detail_raspored_fragment,container,false)

        view.detailRasporedNatjecanje.setText(args.detailRasporedArgs.natjecanje)
        view.detailRasporedDatum.setText(args.detailRasporedArgs.datum)
        view.detailRasporedDomacin.setText(args.detailRasporedArgs.domacin)
        view.detailRasporedGost.setText(args.detailRasporedArgs.gost)
        view.detailRasporedVrijeme.setText(args.detailRasporedArgs.vrijeme)
        view.detailRasporedNedostaju.setText(args.detailRasporedArgs.nedostaju)
        view.detailRasporedClanak.setText(args.detailRasporedArgs.clanak)

        return view
    }

}