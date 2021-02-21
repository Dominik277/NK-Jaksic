package hr.adapteri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.Raspored
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.pokus_jedan_red_raspored.view.*

class TablicaRasporedAdapter(private val sviPokusRasporediUBazi: List<Raspored>): RecyclerView.Adapter<TablicaRasporedAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokus_jedan_red_raspored, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.pokusDatumRaspored.text = sviPokusRasporediUBazi[position].datum
        holder.itemView.pokusOgledRaspored.text = sviPokusRasporediUBazi[position].ogled
    }

    override fun getItemCount() = sviPokusRasporediUBazi.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val datumRasporedPokus: TextView = itemView.pokusDatumRaspored
        val ogledRasporedPokus: TextView = itemView.pokusOgledRaspored
    }
}