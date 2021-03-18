package hr.adapteri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.Igraci
import hr.dominik.nkjaki.R
import hr.fragmenti.MomcadFragmentDirections
import kotlinx.android.synthetic.main.jedan_red_momcad.view.*

class MomcadAdapter: RecyclerView.Adapter<MomcadAdapter.ViewHolder>() {

    private var igraciList =  emptyList<Igraci>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_momcad, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = igraciList[position]
        holder.itemView.momcadBroj.text = currentItem.broj
        holder.itemView.momcadIme.text = currentItem.ime
        holder.itemView.momcadPrezime.text = currentItem.prezime

        holder.itemView.jedanRedMomcad.setOnLongClickListener {
            val action = MomcadFragmentDirections.actionMomcadFragmentToUpdateMomcadFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
            true
        }

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun getItemCount(): Int{
        return igraciList.size
    }

    fun setData(igraci: List<Igraci>){
        this.igraciList = igraci
        notifyDataSetChanged()
    }
}