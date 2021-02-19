package hr.pokus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.ActivityMainBinding

class NajboljiStrijelciActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_najbolji_strijelci)
        setSupportActionBar(findViewById(R.id.toolbarNajboljiStrijelci))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Najbolji Strijelci"
    }
}