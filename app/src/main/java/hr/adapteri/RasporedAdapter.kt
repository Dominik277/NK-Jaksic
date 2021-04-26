package hr.adapteri

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.Raspored
import hr.dominik.nkjaki.databinding.JedanRedRasporedBinding
import hr.fragmenti.fragmenti.RasporedFragmentDirections

class RasporedAdapter: RecyclerView.Adapter<RasporedAdapter.ViewHolder>() {

    private var rasporedList = emptyList<Raspored>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(JedanRedRasporedBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = rasporedList[position]
        holder.binding.rasporedNatjecanje.text = currentItem.natjecanje
        holder.binding.rasporedDatum.text = currentItem.datum
        holder.binding.rasporedDomacin.text = currentItem.domacin
        holder.binding.rasporedGost.text = currentItem.gost
        holder.binding.rasporedVrijeme.text = currentItem.vrijeme

        holder.binding.jedanRedRaspored.setOnLongClickListener {
            val action = RasporedFragmentDirections.actionNavRasporedToAdminPrijavaRaspored(currentItem)
            holder.itemView.findNavController().navigate(action)
            true
        }

        holder.binding.jedanRedRaspored.setOnClickListener {
            val action = RasporedFragmentDirections.actionNavRasporedToDetailRasporedFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int{
        return rasporedList.size
    }

    inner class ViewHolder(val binding: JedanRedRasporedBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    fun setData(raspored: List<Raspored>){
        this.rasporedList = raspored
        notifyDataSetChanged()
    }
}