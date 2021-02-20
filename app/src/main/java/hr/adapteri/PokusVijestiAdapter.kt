package hr.adapteri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.Vijesti
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.jedan_red_pokus_vijesti.view.*

class PokusVijestiAdapter(private val svePokusVijestiUBazi: List<Vijesti>): RecyclerView.Adapter<PokusVijestiAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_pokus_vijesti, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val trenutniItem = svePokusVijestiUBazi[position]
        holder.itemView.textViewPokusVijesti.text = svePokusVijestiUBazi[position].naslov
        holder.itemView.imageViewPokusVijesti.setImageResource(trenutniItem.slika)
    }

    override fun getItemCount() = svePokusVijestiUBazi.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textViewPokusVijesti: TextView = itemView.textViewPokusVijesti
        val imageViewPokusVijesti: ImageView = itemView.imageViewPokusVijesti
    }


}