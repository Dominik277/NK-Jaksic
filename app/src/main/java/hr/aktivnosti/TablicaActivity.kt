package hr.aktivnosti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.activity_tablica.*

class TablicaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tablica)
        setSupportActionBar(findViewById(R.id.toolbarTablica))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Tablica"


    }
}