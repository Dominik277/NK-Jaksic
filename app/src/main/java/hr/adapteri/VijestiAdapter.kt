package hr.adapteri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.Vijesti
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.jedan_red_vijesti.view.*

class VijestiAdapter: RecyclerView.Adapter<VijestiAdapter.ViewHolder>() {

    private var sveVijestiUBazi = emptyList<Vijesti>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_vijesti, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val trenutniItem = sveVijestiUBazi[position]
        holder.itemView.textViewVijesti.text = sveVijestiUBazi[position].naslov
        holder.itemView.imageViewVijesti.setImageResource(trenutniItem.slika)
    }

    override fun getItemCount(): Int{
        return sveVijestiUBazi.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    fun setData(vijesti: List<Vijesti>){
        this.sveVijestiUBazi = vijesti
        notifyDataSetChanged()
    }

}