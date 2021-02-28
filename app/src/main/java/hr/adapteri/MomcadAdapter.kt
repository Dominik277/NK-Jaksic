package hr.adapteri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.Igraci
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.jedan_red_momcad.view.*

class MomcadAdapter constructor(private val sviIgraciUBazi: List<Igraci>) : RecyclerView.Adapter<MomcadAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_momcad, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.momcadBroj.text = sviIgraciUBazi[position].broj.toString()
        holder.itemView.momcadIme.text = sviIgraciUBazi[position].ime
        holder.itemView.momcadPrezime.text = sviIgraciUBazi[position].prezime
        //holder.itemView.momcadSlika.setImageResource(sviIgraciUBazi[position].slika)

    }
    override fun getItemCount() = sviIgraciUBazi.size
}