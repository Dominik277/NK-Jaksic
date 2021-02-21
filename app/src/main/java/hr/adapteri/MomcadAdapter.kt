package hr.adapteri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.Igraci
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.jedan_red_momcad.view.*

class MomcadAdapter constructor(private val sviPokusIgraciUBazi: List<Igraci>) : RecyclerView.Adapter<MomcadAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val brojIgracaPokus: TextView = itemView.brojIgraca
        val imeIgracaPokus: TextView = itemView.imeIgraca
        val prezimeIgracaPokus: TextView = itemView.prezimeIgraca
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_momcad, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.brojIgraca.text = sviPokusIgraciUBazi[position].ime
        holder.itemView.imeIgraca.text = sviPokusIgraciUBazi[position].prezime
        holder.itemView.prezimeIgraca.text = sviPokusIgraciUBazi[position].broj.toString()

    }
    override fun getItemCount() = sviPokusIgraciUBazi.size
}