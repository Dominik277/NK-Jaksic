package hr.pokusTablicaFragmenti

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.NajboljiStrijelci
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.jedan_red_najbolji_strijelci.view.*
import kotlinx.android.synthetic.main.pokus_jedan_red_najbolji_strijelci.view.*
import kotlinx.android.synthetic.main.pokus_jedan_red_najbolji_strijelci.view.pokusNajboljiStrijelciGolovi
import kotlinx.android.synthetic.main.pokus_jedan_red_najbolji_strijelci.view.pokusNajboljiStrijelciIme
import kotlinx.android.synthetic.main.pokus_jedan_red_najbolji_strijelci.view.pokusNajboljiStrijelciPozicija
import kotlinx.android.synthetic.main.pokus_jedan_red_strijelci.view.*

class PokusNajboljiStrijelciAdapter(private val sviPokusNajboljiStrijelciUBazi: List<NajboljiStrijelci>): RecyclerView.Adapter<PokusNajboljiStrijelciAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.pokus_jedan_red_najbolji_strijelci, parent, false)
        return ViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pokusNajboljiStrijelciPozicija.text = sviPokusNajboljiStrijelciUBazi[position].pozicijaPoGolovima.toString()
        holder.pokusNajboljiStrijelciIme.text = sviPokusNajboljiStrijelciUBazi[position].imeIgraca
        holder.pokusNajboljiStrijelciGolovi.text = sviPokusNajboljiStrijelciUBazi[position].brojGolova
    }

    override fun getItemCount() = sviPokusNajboljiStrijelciUBazi.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val pokusNajboljiStrijelciPozicija: TextView = itemView.pokusNajboljiStrijelciPozicija
        val pokusNajboljiStrijelciIme: TextView = itemView.pokusNajboljiStrijelciIme
        val pokusNajboljiStrijelciGolovi: TextView = itemView.pokusNajboljiStrijelciGolovi
    }
}