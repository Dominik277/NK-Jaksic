package hr.aktivnosti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
}

