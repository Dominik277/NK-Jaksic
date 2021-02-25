package hr.adapteri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        holder.itemView.natjecanjeRezultati.text = sviRezultatiUBazi[position].natjecanjeRezultat
        holder.itemView.datumRezultati.text = sviRezultatiUBazi[position].datumRezultat
        holder.itemView.domacinRezultati.text = sviRezultatiUBazi[position].domacinRezultat
        holder.itemView.gostRezultati.text = sviRezultatiUBazi[position].gostRezultat
        holder.itemView.rezultatRezultati.text = sviRezultatiUBazi[position].rezultatUtakmice
        holder.itemView.ishodRezultati.text = sviRezultatiUBazi[position].ishodRezultat
    }

    override fun getItemCount() = sviRezultatiUBazi.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }
}