package hr.pokusRaspored

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hr.dominik.nkjaki.R

class PokusRasporedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokus_raspored)
        setSupportActionBar(findViewById(R.id.toolbarPokusRaspored))
        title = "Pokus Raspored"
    }
}