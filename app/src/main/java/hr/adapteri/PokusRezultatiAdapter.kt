package hr.adapteri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.Rezultat
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.jedan_red_rezultati.view.*

class PokusRezultatiAdapter(private val sviPokusRezultatiUBazi: List<Rezultat>): RecyclerView.Adapter<PokusRezultatiAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_rezultati, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.datumRezultat.text = sviPokusRezultatiUBazi[position].datumRezultat
        holder.itemView.protivniciRezultat.text = sviPokusRezultatiUBazi[position].ogledRezultat
        holder.itemView.rezultatUtakmice.text = sviPokusRezultatiUBazi[position].rezultatUtakmice
        holder.itemView.ishodRezultat.text = sviPokusRezultatiUBazi[position].ishodRezultat
    }

    override fun getItemCount() = sviPokusRezultatiUBazi.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val datumRezultatPokus: TextView = itemView.datumRezultat
        val protivniciRezultatPokus: TextView = itemView.protivniciRezultat
        val rezultatUtakmicePokus: TextView = itemView.rezultatUtakmice
        val ishodRezultatPokus: TextView = itemView.ishodRezultat
    }
}