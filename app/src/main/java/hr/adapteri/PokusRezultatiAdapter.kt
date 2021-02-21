package hr.adapteri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.Rezultat
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.jedan_red_rezultati.view.*
import kotlinx.android.synthetic.main.pokus_jedan_red_rezultati.view.*

class PokusRezultatiAdapter(private val sviPokusRezultatiUBazi: List<Rezultat>): RecyclerView.Adapter<PokusRezultatiAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokus_jedan_red_rezultati, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.pokusDatumRezultat.text = sviPokusRezultatiUBazi[position].datumRezultat
        holder.itemView.pokusProtivniciRezultat.text = sviPokusRezultatiUBazi[position].ogledRezultat
        holder.itemView.pokusRezultatUtakmice.text = sviPokusRezultatiUBazi[position].rezultatUtakmice
        holder.itemView.pokusIshodRezultat.text = sviPokusRezultatiUBazi[position].ishodRezultat
    }

    override fun getItemCount() = sviPokusRezultatiUBazi.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val datumRezultatPokus: TextView = itemView.pokusDatumRezultat
        val protivniciRezultatPokus: TextView = itemView.pokusProtivniciRezultat
        val rezultatUtakmicePokus: TextView = itemView.pokusRezultatUtakmice
        val ishodRezultatPokus: TextView = itemView.pokusIshodRezultat
    }
}