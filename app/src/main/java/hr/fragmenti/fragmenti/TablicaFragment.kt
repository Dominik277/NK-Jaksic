package hr.fragmenti.fragmenti

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint
import hr.adapteri.ViewPagerAdapter
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.FragmentTablicaBinding

@AndroidEntryPoint
class TablicaFragment : Fragment(R.layout.fragment_tablica) {

    private lateinit var binding: FragmentTablicaBinding
    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTablicaBinding.bind(view)

        tabLayout?.newTab()?.setText("Tablica")?.let { binding.tabs.addTab(it) }
        tabLayout?.newTab()?.setText("Raspored")?.let { binding.tabs.addTab(it) }
        tabLayout?.newTab()?.setText("Rezultati")?.let { binding.tabs.addTab(it) }
        tabLayout?.newTab()?.setText("Strijelci")?.let { binding.tabs.addTab(it) }
        tabLayout?.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = ViewPagerAdapter(childFragmentManager)
        binding.viewPager.adapter = adapter

        viewPager?.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabs))

        tabLayout?.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewPager!!.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

    }
/*
    private fun setUpTabs() {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(TablicaTablicaFragment(), "Tablica")
        adapter.addFragment(TablicaRasporedFragment(), "Raspored")
        adapter.addFragment(TablicaRezultatiFragment(), "Rezultati")
        adapter.addFragment(NajboljiStrijelciFragment(), "Strijelci")
        binding.viewPager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.viewPager)

    }
 */
}