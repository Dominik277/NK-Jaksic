package hr.adapteri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.NajboljiStrijelci
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.jedan_red_najbolji_strijelci.view.*

class NajboljiStrijelciAdapter(private val sviNajboljiStrijelciUBazi: List<NajboljiStrijelci>): RecyclerView.Adapter<NajboljiStrijelciAdapter.ExampleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_najbolji_strijelci, parent, false)
        return ExampleViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        holder.najboljiStrijelciPozicija.text = sviNajboljiStrijelciUBazi[position].pozicijaPoGolovima.toString()
        holder.najboljiStrijelciIme.text = sviNajboljiStrijelciUBazi[position].imeIgraca
        holder.najboljiStrijelciGolovi.text = sviNajboljiStrijelciUBazi[position].brojGolova
    }

    override fun getItemCount() = sviNajboljiStrijelciUBazi.size

    class ExampleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val najboljiStrijelciPozicija: TextView = itemView.najboljiStrijelciPozicija
        val najboljiStrijelciIme: TextView = itemView.najboljiStrijelciIme
        val najboljiStrijelciGolovi: TextView = itemView.najboljiStrijelciGolovi
    }
}