package hr.adapteri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.database.Igraci
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.jedan_red.view.*

class MomcadAdapter constructor(private val sviIgraciUBazi: List<Igraci>): RecyclerView.Adapter<MomcadAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val brojIgraca: TextView = itemView.brojIgraca
        val imeIgraca: TextView = itemView.imeIgraca
        val prezimeIgraca: TextView = itemView.prezimeIgraca

        init {
            itemView.setOnClickListener {this}
        }

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.brojIgraca.text = sviIgraciUBazi[position].ime
        holder.itemView.imeIgraca.text = sviIgraciUBazi[position].prezime
        holder.itemView.prezimeIgraca.text = sviIgraciUBazi[position].broj.toString()

    }
    override fun getItemCount() = sviIgraciUBazi.size
}