package hr.adapteri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.Rezultat
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.jedan_red_pokus_rezultati.view.*

class PokusRezultatiAdapter(private val sviPokusRezultatiUBazi: List<Rezultat>): RecyclerView.Adapter<PokusRezultatiAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_pokus_rezultati, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.datumRezultatPokus.text = sviPokusRezultatiUBazi[position].datumRezultat
        holder.itemView.protivniciRezultatPokus.text = sviPokusRezultatiUBazi[position].ogledRezultat
        holder.itemView.rezultatUtakmicePokus.text = sviPokusRezultatiUBazi[position].rezultatUtakmice
        holder.itemView.ishodRezultatPokus.text = sviPokusRezultatiUBazi[position].ishodRezultat
    }

    override fun getItemCount() = sviPokusRezultatiUBazi.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val datumRezultatPokus: TextView = itemView.datumRezultatPokus
        val protivniciRezultatPokus: TextView = itemView.protivniciRezultatPokus
        val rezultatUtakmicePokus: TextView = itemView.rezultatUtakmicePokus
        val ishodRezultatPokus: TextView = itemView.ishodRezultatPokus
    }
}