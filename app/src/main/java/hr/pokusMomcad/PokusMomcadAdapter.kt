package hr.pokusMomcad

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.adapteri.MomcadAdapter
import hr.database.table.Igraci
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.jedan_red_momcad.view.*
import kotlinx.android.synthetic.main.jedan_red_pokus_momcad.view.*

class PokusMomcadAdapter constructor(private val sviPokusIgraciUBazi: List<Igraci>) : RecyclerView.Adapter<PokusMomcadAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val brojIgracaPokus: TextView = itemView.brojIgracaPokus
        val imeIgracaPokus: TextView = itemView.imeIgracaPokus
        val prezimeIgracaPokus: TextView = itemView.prezimeIgracaPokus
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_pokus_momcad, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.brojIgracaPokus.text = sviPokusIgraciUBazi[position].ime
        holder.itemView.imeIgracaPokus.text = sviPokusIgraciUBazi[position].prezime
        holder.itemView.prezimeIgracaPokus.text = sviPokusIgraciUBazi[position].broj.toString()

    }
    override fun getItemCount() = sviPokusIgraciUBazi.size
}