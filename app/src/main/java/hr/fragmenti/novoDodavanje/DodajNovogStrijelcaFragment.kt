package hr.fragmenti.novoDodavanje

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import hr.database.table.NajboljiStrijelci
import hr.dominik.nkjaki.R
import hr.novoDodavanje.DodajNovogStrijelcaFragmentDirections
import hr.viewModel.NajboljiStrijelciViewModel
import kotlinx.android.synthetic.main.fragment_novi_strijelac.*
import kotlinx.android.synthetic.main.fragment_novi_strijelac.view.*
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class DodajNovogStrijelcaFragment: Fragment() {

    @InternalCoroutinesApi
    private val mNajboljiStrijelacViewModel: NajboljiStrijelciViewModel by viewModels()

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view = inflater.inflate(R.layout.fragment_novi_strijelac,container, false)

        view.gumbSpremiNovogStrijelca.setOnClickListener {
            val action =
                DodajNovogStrijelcaFragmentDirections.actionDodajNovogStrijelcaFragmentToNajboljiStrijelciFragment()
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