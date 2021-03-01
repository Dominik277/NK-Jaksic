package hr.adapteri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.Raspored
import hr.dominik.nkjaki.R
import hr.fragmenti.RasporedFragmentDirections
import kotlinx.android.synthetic.main.jedan_red_raspored.view.*

class RasporedAdapter: RecyclerView.Adapter<RasporedAdapter.ViewHolder>() {

    private var rasporedList = emptyList<Raspored>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_raspored, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = rasporedList[position]
        holder.itemView.rasporedNatjecanje.text = currentItem.natjecanje
        holder.itemView.rasporedDatum.text = currentItem.datum
        holder.itemView.rasporedDomacin.text = currentItem.domacin
        holder.itemView.rasporedGost.text = currentItem.gost
        holder.itemView.rasporedVrijeme.text = currentItem.vrijeme
/*
        holder.itemView.jedanRedRaspored.setOnClickListener {
            findNavController().navigate(R.id.action_rasporedFragment_to_updateRaspored)
        }
*/
    }

    override fun getItemCount(): Int{
        return rasporedList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                val position: Int = adapterPosition
                Toast.makeText(itemView.context,"You clicked ${position + 1}",Toast.LENGTH_LONG).show()
            }
        }
    }

    fun setData(raspored: List<Raspored>){
        this.rasporedList = raspored
        notifyDataSetChanged()
    }

}