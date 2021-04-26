package hr.adapteri

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.Rezultat
import hr.dominik.nkjaki.databinding.JedanRedRezultatiBinding
import hr.fragmenti.fragmenti.RezultatiFragmentDirections

class RezultatiAdapter : RecyclerView.Adapter<RezultatiAdapter.ViewHolder>() {

    private var rezultatiList = emptyList<Rezultat>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            JedanRedRezultatiBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = rezultatiList[position]
        holder.binding.natjecanjeRezultati.text = currentItem.natjecanjeRezultat
        holder.binding.datumRezultati.text = currentItem.datumRezultat
        holder.binding.domacinRezultati.text = currentItem.domacinRezultat
        holder.binding.gostRezultati.text = currentItem.gostRezultat
        holder.binding.rezultatRezultati.text = currentItem.rezultatUtakmice

        holder.binding.jedanRedRezultat.setOnLongClickListener {
            val action =
                RezultatiFragmentDirections.actionNavRezultatiToAdminPrijavaRezultati(currentItem)
            holder.itemView.findNavController().navigate(action)
            true
        }

        holder.binding.jedanRedRezultat.setOnClickListener {
            val action =
                RezultatiFragmentDirections.actionNavRezultatiToDetailRezultatiFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return rezultatiList.size
    }

    inner class ViewHolder(val binding: JedanRedRezultatiBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    fun setData(rezultat: List<Rezultat>) {
        this.rezultatiList = rezultat
        notifyDataSetChanged()
    }
}