package hr.adapteri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

        holder.itemView.jedanRedRaspored.setOnLongClickListener {
            val action = RasporedFragmentDirections.actionRasporedFragmentToUpdateRasporedFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
            true
        }
    }

    override fun getItemCount(): Int{
        return rasporedList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    fun setData(raspored: List<Raspored>){
        this.rasporedList = raspored
        notifyDataSetChanged()
    }
}