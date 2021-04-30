package hr.fragmenti.fragmenti

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import hr.adapteri.ViewPagerAdapter
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.FragmentTablicaBinding

@AndroidEntryPoint
class TablicaFragment : Fragment(R.layout.fragment_tablica) {

    private lateinit var binding: FragmentTablicaBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTablicaBinding.bind(view)

        setUpTabs()

    }

    private fun setUpTabs() {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(TablicaRasporedFragment(), "Raspored")
        adapter.addFragment(TablicaRezultatiFragment(), "Rezultati")
        adapter.addFragment(NajboljiStrijelciFragment(), "Strijelci")
        adapter.addFragment(TablicaFragment(), "Strijelci")
        binding.viewPager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.viewPager)
    }
}