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
        holder.itemView.svastara_rasporedNatjecanje.text = sviRasporediUBazi[position].natjecanje
        holder.itemView.svastara_rasporedDatum.text = sviRasporediUBazi[position].datum
        holder.itemView.svastara_rasporedDomacin.text = sviRasporediUBazi[position].domacin
        holder.itemView.svastara_rasporedGost.text = sviRasporediUBazi[position].gost
        holder.itemView.svastara_rasporedVrijeme.text = sviRasporediUBazi[position].vrijeme

    }

    override fun getItemCount() = sviRasporediUBazi.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}