package hr.adapteri

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.Igraci
import hr.dominik.nkjaki.databinding.JedanRedMomcadBinding
import hr.fragmenti.fragmenti.MomcadFragmentDirections

class MomcadAdapter : RecyclerView.Adapter<MomcadAdapter.ViewHolder>() {

    private var igraciList = emptyList<Igraci>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            JedanRedMomcadBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = igraciList[position]
        holder.binding.momcadBroj.text = currentItem.broj
        holder.binding.momcadIme.text = currentItem.ime
        holder.binding.momcadPrezime.text = currentItem.prezime

        holder.binding.jedanRedMomcad.setOnLongClickListener {
            val action = MomcadFragmentDirections.actionNavMomcadToAdminPrijavaMomcad(currentItem)
            holder.itemView.findNavController().navigate(action)
            true
        }

        holder.binding.jedanRedMomcad.setOnClickListener {
            val action = MomcadFragmentDirections.actionNavMomcadToDetailMomcadFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

    }

    inner class ViewHolder(val binding: JedanRedMomcadBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun getItemCount(): Int {
        return igraciList.size
    }

    fun setData(igraci: List<Igraci>) {
        this.igraciList = igraci
        notifyDataSetChanged()
    }
}