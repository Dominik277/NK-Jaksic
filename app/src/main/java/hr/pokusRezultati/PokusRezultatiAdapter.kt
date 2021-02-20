package hr.pokusRezultati

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.Rezultat
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.jedan_red_pokus_raspored.view.*
import kotlinx.android.synthetic.main.jedan_red_rezultat.view.*

class PokusRezultatiAdapter(private val sviPokusRezultatiUBazi: List<Rezultat>): RecyclerView.Adapter<PokusRezultatiAdapter.ViewHolder> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_pokus_raspored, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.datumRasporedPokus.text = sviPokusRasporediUBazi[position].datum
        holder.itemView.ogledRasporedPokus.text = sviPokusRasporediUBazi[position].ogled
    }

    override fun getItemCount() = sviPokusRezultatiUBazi.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val datumRasporedPokus: TextView = itemView.datumRezultat
        val ogledRasporedPokus: TextView = itemView.ogledRasporedPokus
    }

}