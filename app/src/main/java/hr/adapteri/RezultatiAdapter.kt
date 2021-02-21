package hr.adapteri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.Rezultat
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.jedan_red_rezultati.view.*

class RezultatiAdapter(private val sviRezultatiUBazi: List<Rezultat>): RecyclerView.Adapter<RezultatiAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_rezultati, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.datumRezultat.text = sviRezultatiUBazi[position].datumRezultat
        holder.itemView.protivniciRezultat.text = sviRezultatiUBazi[position].ogledRezultat
        holder.itemView.rezultatUtakmice.text = sviRezultatiUBazi[position].rezultatUtakmice
        holder.itemView.ishodRezultat.text = sviRezultatiUBazi[position].ishodRezultat
    }

    override fun getItemCount() = sviRezultatiUBazi.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val datumRezultat: TextView = itemView.datumRezultat
        val protivniciRezultat: TextView = itemView.protivniciRezultat
        val rezultatUtakmice: TextView = itemView.rezultatUtakmice
        val ishodRezultat: TextView = itemView.ishodRezultat
    }
}