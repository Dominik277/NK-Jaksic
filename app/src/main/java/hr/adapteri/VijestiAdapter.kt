package hr.adapteri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.database.Vijesti
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.jedan_red_vijesti.view.*

class VijestiAdapter constructor(private val sveVijestiUBazi: List<Vijesti>) :
    RecyclerView.Adapter<VijestiAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewVijesti: TextView = itemView.textViewVijesti
        val imageViewVijesti: ImageView = itemView.imageViewVijesti
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VijestiAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_vijesti, parent, false)
        return VijestiAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: VijestiAdapter.ViewHolder, position: Int) {
        holder.itemView.textViewVijesti.text = sveVijestiUBazi[position].naslov
    }

    override fun getItemCount() = sveVijestiUBazi.size

}