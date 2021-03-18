package hr.adapteri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.Vijesti
import hr.dominik.nkjaki.R
import hr.fragmenti.VijestiFragmentDirections
import kotlinx.android.synthetic.main.jedan_red_vijesti.view.*

class VijestiAdapter: RecyclerView.Adapter<VijestiAdapter.ViewHolder>() {

    private var listVijesti = emptyList<Vijesti>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_vijesti, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = listVijesti[position]
        holder.itemView.textViewVijesti.text = currentItem.naslov
        holder.itemView.textViewVijestiVrijeme.text = currentItem.vrijeme

        holder.itemView.jedanRedVijesti.setOnLongClickListener {
            val action = VijestiFragmentDirections.actionNavVijestiToUpdateVijestiFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
            true
        }
    }

    override fun getItemCount(): Int{
        return listVijesti.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    fun setData(vijesti: List<Vijesti>){
        this.listVijesti = vijesti
        notifyDataSetChanged()
    }

}