package hr.aktivnosti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hr.dominik.nkjaki.R

class NoviRezultatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novi_rezultat)
        setSupportActionBar(findViewById(R.id.toolbarNoviRezultat))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Dodaj novi rezultat"
    }
}