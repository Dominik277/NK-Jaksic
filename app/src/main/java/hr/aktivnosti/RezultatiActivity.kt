package hr.aktivnosti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.activity_rezultati.*

class RezultatiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rezultati)
        setSupportActionBar(findViewById(R.id.toolbarRezultati))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Rezultati"

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_novi_rezultat,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menuNoviRezultat -> {
                val intent = Intent(this, NoviRezultatActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}

