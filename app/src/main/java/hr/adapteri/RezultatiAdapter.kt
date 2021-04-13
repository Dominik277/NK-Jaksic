package hr.adapteri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.Raspored
import hr.database.table.Rezultat
import hr.dominik.nkjaki.R
import hr.fragmenti.fragmenti.RezultatiFragmentDirections
import kotlinx.android.synthetic.main.jedan_red_rezultati.view.*

class RezultatiAdapter: RecyclerView.Adapter<RezultatiAdapter.ViewHolder>() {

    private var rezultatiList = emptyList<Rezultat>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_rezultati, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = rezultatiList[position]
        holder.itemView.natjecanjeRezultati.text = currentItem.natjecanjeRezultat
        holder.itemView.datumRezultati.text = currentItem.datumRezultat
        holder.itemView.domacinRezultati.text = currentItem.domacinRezultat
        holder.itemView.gostRezultati.text = currentItem.gostRezultat
        holder.itemView.rezultatRezultati.text = currentItem.rezultatUtakmice
        holder.itemView.ishodRezultati.text = currentItem.ishodRezultat

        holder.itemView.jedanRedRezultat.setOnLongClickListener {
            val action = RezultatiFragmentDirections.actionNavRezultatiToAdminPrijavaRezultati(currentItem)
            holder.itemView.findNavController().navigate(action)
            true
        }

        holder.itemView.jedanRedRezultat.setOnClickListener {
            val action = RezultatiFragmentDirections.actionNavRezultatiToDetailRezultatiFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int{
        return rezultatiList.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    fun setData(rezultat: List<Rezultat>){
        this.rezultatiList = rezultat
        notifyDataSetChanged()
    }
}