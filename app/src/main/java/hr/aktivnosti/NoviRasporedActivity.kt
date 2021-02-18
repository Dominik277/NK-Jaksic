package hr.aktivnosti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import hr.NovaVijestActivity
import hr.dominik.nkjaki.R

class NoviRasporedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novi_raspored)
        setSupportActionBar(findViewById(R.id.toolbarNoviRaspored))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Dodaj novi raspored"
    }
}