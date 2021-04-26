package hr.adapteri

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.TablicaTablica
import hr.dominik.nkjaki.databinding.JedanRedTablicaTablicaBinding
import hr.fragmenti.fragmenti.TablicaTablicaFragmentDirections

class TablicaTablicaAdapter : RecyclerView.Adapter<TablicaTablicaAdapter.ViewHolder>() {

    private var tablicaTablicaList = emptyList<TablicaTablica>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            JedanRedTablicaTablicaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = tablicaTablicaList[position]
        holder.binding.tablicaTablicaGolovi.text = currentItem.pozicija
        holder.binding.tablicaTablicaIme.text = currentItem.imeTima
        holder.binding.tablicaTablicaSusreti.text = currentItem.odigraniSusreti
        holder.binding.tablicaTablicaGolovi.text = currentItem.golRazlika
        holder.binding.tablicaTablicaBodovi.text = currentItem.bodovi

        holder.binding.jedanRedTablicaTablica.setOnLongClickListener {
            val action =
                TablicaTablicaFragmentDirections.actionTablicaTablicaFragmentToAdminPrijavaTablica(
                    currentItem
                )
            holder.itemView.findNavController().navigate(action)
            true
        }

    }

    override fun getItemCount(): Int {
        return tablicaTablicaList.size
    }


    inner class ViewHolder(val binding: JedanRedTablicaTablicaBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    fun setData(tablicaTablica: List<TablicaTablica>) {
        this.tablicaTablicaList = tablicaTablica
        notifyDataSetChanged()
    }
}