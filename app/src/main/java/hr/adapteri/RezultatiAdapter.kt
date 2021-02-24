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
        holder.itemView.bzvz_natjecanjeRezultati.text = sviRezultatiUBazi[position].natjecanjeRezultat
        holder.itemView.bzvz_datumRezultati.text = sviRezultatiUBazi[position].datumRezultat
        holder.itemView.bzvz_domacinRezultati.text = sviRezultatiUBazi[position].domacinRezultat
        holder.itemView.bzvz_gostRezultati.text = sviRezultatiUBazi[position].gostRezultat
        holder.itemView.bzvz_rezultatRezultati.text = sviRezultatiUBazi[position].rezultatUtakmice
        holder.itemView.bzvz_ishodRezultati.text = sviRezultatiUBazi[position].ishodRezultat
    }

    override fun getItemCount() = sviRezultatiUBazi.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }
}