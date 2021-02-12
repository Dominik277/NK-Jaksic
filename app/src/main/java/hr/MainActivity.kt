package hr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import hr.dominik.nkjaki.R
import hr.fragmenti.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        val momcadFragment = MomcadFragment()
        val rasporedFragment = RasporedFragment()
        val rezultatiFragment = RezultatiFragment()
        val tablicaFragment = TablicaFragment()
        val vijestiFragment = VijestiFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout,rasporedFragment)
            commit()
        }

        button1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout,rasporedFragment)
                addToBackStack(null)
                commit()
            }
        }

        button2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout,rezultatiFragment)
                addToBackStack(null)
                commit()
            }
        }

        button3.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout,tablicaFragment)
                addToBackStack(null)
                commit()
            }
        }

        val drawerToggle = ActionBarDrawerToggle(this,drawer, R.string.open, R.string.close)
        drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home ->{
                drawer.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }
}