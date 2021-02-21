package hr.aktivnosti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hr.dominik.nkjaki.R
import hr.fragmenti.PokusNajboljiStrijelciFragment
import hr.fragmenti.PokusRasporedFragment
import hr.fragmenti.PokusRezultatiFragment
import hr.fragmenti.PokusTablicaFragment
import kotlinx.android.synthetic.main.activity_pokus_tablica.*

class PokusTablicaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokus_tablica)
        setSupportActionBar(findViewById(R.id.toolbarPokusTablica))
        title = "Pokus tablica"

        val strijelciFragment = PokusNajboljiStrijelciFragment()
        val tablicaFragment = PokusTablicaFragment()
        val rasporedFragment = PokusRasporedFragment()
        val rezultatiFragment = PokusRezultatiFragment()

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