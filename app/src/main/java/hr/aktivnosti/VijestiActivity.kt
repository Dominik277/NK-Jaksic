package hr.aktivnosti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import hr.NovaVijestActivity
import hr.dominik.nkjaki.R

class VijestiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vijesti)
        setSupportActionBar(findViewById(R.id.toolbarVijesti))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title="Vijesti"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.vijesti_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.vijestiMenu -> {
                val intent = Intent(this,NovaVijestActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}