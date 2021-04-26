package hr.adapteri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.Vijesti
import hr.dominik.nkjaki.databinding.JedanRedVijestiBinding
import hr.fragmenti.fragmenti.VijestiFragmentDirections

class VijestiAdapter : RecyclerView.Adapter<VijestiAdapter.ViewHolder>() {

    private var listVijesti = emptyList<Vijesti>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            JedanRedVijestiBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = listVijesti[position]
        holder.binding.textViewVijesti.text = currentItem.naslov
        holder.binding.textViewVijestiVrijeme.text = currentItem.vrijeme

        holder.binding.jedanRedVijesti.setOnLongClickListener {
            val action =
                VijestiFragmentDirections.actionNavVijestiToAdminPrijavaVijesti(currentItem)
            holder.itemView.findNavController().navigate(action)
            true
        }

        holder.binding.jedanRedVijesti.setOnClickListener {
            val action =
                VijestiFragmentDirections.actionNavVijestiToDetailVijestiFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return listVijesti.size
    }

    inner class ViewHolder(val binding: JedanRedVijestiBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    fun setData(vijesti: List<Vijesti>) {
        this.listVijesti = vijesti
        notifyDataSetChanged()
    }

}