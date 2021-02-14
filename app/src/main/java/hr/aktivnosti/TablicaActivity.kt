package hr.aktivnosti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hr.dominik.nkjaki.R
import hr.fragmenti.RezultatiFragment
import hr.fragmenti.StrijelciFragment
import hr.fragmenti.TablicaFragment
import kotlinx.android.synthetic.main.activity_tablica.*

class TablicaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tablica)
        setSupportActionBar(findViewById(R.id.toolbarTablica))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Tablica"

        val rezultatiFragment = RezultatiFragment()
        val strijelciFragment = StrijelciFragment()
        val tablicaFragment = TablicaFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayoutTablica, tablicaFragment)
            commit()
        }

        gumbTablica.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayoutTablica, tablicaFragment)
                addToBackStack(null)
                commit()
            }
        }

        gumbNajboljiStrijelci.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayoutTablica, strijelciFragment)
                addToBackStack(null)
                commit()
            }
        }

        gumbRezultati.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayoutTablica,rezultatiFragment)
                addToBackStack(null)
                commit()
            }
        }

    }
}