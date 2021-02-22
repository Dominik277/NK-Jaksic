package hr.adapteri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.Rezultat
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.jedan_red_tablica_rezultati.view.*

class TablicaRezultatiAdapter(private val sviRezultatiUBazi: List<Rezultat>): RecyclerView.Adapter<TablicaRezultatiAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_tablica_rezultati, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tablicaDatumRezultat.text = sviRezultatiUBazi[position].datumRezultat
        holder.itemView.tablicaProtivniciRezultat.text = sviRezultatiUBazi[position].ogledRezultat
        holder.itemView.tablicaRezultatUtakmice.text = sviRezultatiUBazi[position].rezultatUtakmice
        holder.itemView.tablicaIshodRezultat.text = sviRezultatiUBazi[position].ishodRezultat
    }

    override fun getItemCount() = sviRezultatiUBazi.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val datumRezultat: TextView = itemView.tablicaDatumRezultat
        val protivniciRezultat: TextView = itemView.tablicaProtivniciRezultat
        val rezultatUtakmice: TextView = itemView.tablicaRezultatUtakmice
        val ishodRezultat: TextView = itemView.tablicaIshodRezultat
    }
}