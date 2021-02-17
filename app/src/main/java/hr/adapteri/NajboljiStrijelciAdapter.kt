package hr.adapteri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.NajboljiStrijelci
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.jedan_red_najbolji_strijelci.view.*

class NajboljiStrijelciAdapter(private val sviStrijelciUBazi: List<NajboljiStrijelci>) : RecyclerView.Adapter<NajboljiStrijelciAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NajboljiStrijelciAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_najbolji_strijelci, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: NajboljiStrijelciAdapter.ViewHolder, position: Int) {
        holder.itemView.strijelci_pozicija.text = sviStrijelciUBazi[position].pozicijaPoGolovima.toString()
        holder.itemView.strijecli_ime.text = sviStrijelciUBazi[position].imeIgraca
        holder.itemView.strijelci_golovi.text = sviStrijelciUBazi[position].brojGolova
    }

    override fun getItemCount() = sviStrijelciUBazi.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val strijelciPozicija: TextView = itemView.strijelci_pozicija
        val strijelciIme: TextView = itemView.strijecli_ime
        val strijelciGolovi: TextView = itemView.strijelci_golovi
    }

}