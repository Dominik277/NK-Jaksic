package hr.pokus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hr.dominik.nkjaki.R

class NajboljiStrijelciActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_najbolji_strijelci)
        setSupportActionBar(findViewById(R.id.toolbarNajboljiStrijelci))
        title = "Najbolji Strijelci"

    }
}