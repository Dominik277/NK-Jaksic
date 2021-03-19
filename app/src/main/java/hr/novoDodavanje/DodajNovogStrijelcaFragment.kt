package hr.novoDodavanje

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import hr.database.table.NajboljiStrijelci
import hr.dominik.nkjaki.R
import hr.viewModel.NajboljiStrijelciViewModel
import kotlinx.android.synthetic.main.fragment_novi_strijelac.*
import kotlinx.android.synthetic.main.fragment_novi_strijelac.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class DodajNovogStrijelcaFragment: Fragment() {

    @InternalCoroutinesApi
    private lateinit var mNajboljiStrijelacViewModel: NajboljiStrijelciViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view = inflater.inflate(R.layout.fragment_novi_strijelac,container, false)

        mNajboljiStrijelacViewModel = ViewModelProvider(this).get(NajboljiStrijelciViewModel::class.java)

        view.gumbSpremiNovogStrijelca.setOnClickListener {
            val action = DodajNovogStrijelcaFragmentDirections.actionDodajNovogStrijelcaFragmentToNajboljiStrijelciFragment()
            findNavController().navigate(action)
            insertDataToDatabase()
        }

        return view
    }

    @InternalCoroutinesApi
    private fun insertDataToDatabase() {
        val noviStrijelacPozicija = noviStrijelacPozicija.text.toString()
        val noviStrijelacImePrezime = noviStrijelacImePrezime.text.toString()
        val noviStrijelacBrojGolova = noviStrijelacBrojGolova.text.toString()

            val najboljiStrijelac = NajboljiStrijelci(0,noviStrijelacPozicija,noviStrijelacImePrezime,noviStrijelacBrojGolova)
            mNajboljiStrijelacViewModel.addNajboljiStrijelac(najboljiStrijelac)
            Toast.makeText(requireContext(),"Successfully added", Toast.LENGTH_LONG).show()

    }
}