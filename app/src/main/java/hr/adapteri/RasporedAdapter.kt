package hr.adapteri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.Raspored
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.jedan_red_raspored.view.*

class RasporedAdapter(private val sviRasporediUBazi: List<Raspored>): RecyclerView.Adapter<RasporedAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_raspored, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.datumRaspored.text = sviRasporediUBazi[position].datum
        holder.itemView.ogledRaspored.text = sviRasporediUBazi[position].ogled
    }

    override fun getItemCount() = sviRasporediUBazi.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val datumRaspored: TextView = itemView.datumRaspored
        val ogledRaspored: TextView = itemView.ogledRaspored
    }
}