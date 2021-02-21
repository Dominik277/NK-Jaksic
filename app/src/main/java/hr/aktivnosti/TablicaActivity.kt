package hr.aktivnosti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hr.dominik.nkjaki.R
import hr.fragmenti.NajboljiStrijelciFragment
import hr.fragmenti.TablicaRasporedFragment
import hr.fragmenti.TablicaRezultatiFragment
import hr.fragmenti.TablicaTablicaFragment
import kotlinx.android.synthetic.main.activity_pokus_tablica.*

class TablicaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokus_tablica)
        setSupportActionBar(findViewById(R.id.toolbarPokusTablica))
        title = "Pokus tablica"

        val strijelciFragment = NajboljiStrijelciFragment()
        val tablicaFragment = TablicaTablicaFragment()
        val rasporedFragment = TablicaRasporedFragment()
        val rezultatiFragment = TablicaRezultatiFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.pokusFragmentTablica,tablicaFragment)
            commit()
        }

        pokusGumbNajboljiStrijelci.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.pokusFragmentTablica,strijelciFragment)
                addToBackStack(null)
                commit()
            }
        }

        pokusGumbTablica.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.pokusFragmentTablica,tablicaFragment)
                addToBackStack(null)
                commit()
            }
        }

        pokusGumbRaspored.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.pokusFragmentTablica,rasporedFragment)
                addToBackStack(null)
                commit()
            }
        }

        pokusGumbRezultati.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.pokusFragmentTablica,rezultatiFragment)
                addToBackStack(null)
                commit()
            }
        }

    }
}