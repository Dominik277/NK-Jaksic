package hr.aktivnosti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hr.dominik.nkjaki.R

class NovaVijestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nova_vijest)
        setSupportActionBar(findViewById(R.id.toolbarNovaVijest))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title="Dodajte novu vijest"
    }
}