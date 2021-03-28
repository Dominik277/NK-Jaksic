package hr.fragmenti.detailFragmenti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import hr.detailFragmenti.DetailRezultatiFragmentArgs
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.detail_rezultati_fragment.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class DetailRezultatiFragment : Fragment(){

    private val args by navArgs<DetailRezultatiFragmentArgs>()

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.detail_rezultati_fragment,container,false)

        view.detailRezultatNatjecanje.setText(args.detailRezultatArgs.natjecanjeRezultat)
        view.detailRezultatDatum.setText(args.detailRezultatArgs.datumRezultat)
        view.detailRezultatDomacin.setText(args.detailRezultatArgs.domacinRezultat)
        view.detailRezultatGost.setText(args.detailRezultatArgs.gostRezultat)
        view.detailRezultatRezultat.setText(args.detailRezultatArgs.rezultatUtakmice)
        view.detailRezultatIshod.setText(args.detailRezultatArgs.ishodRezultat)
        view.detailRezultatPostave.setText(args.detailRezultatArgs.postaveRezultati)
        view.detailRezultatDetalji.setText(args.detailRezultatArgs.detaljiRezultati)
        view.detailRezultatClanak.setText(args.detailRezultatArgs.clanakRezultat)

        return view
    }

}