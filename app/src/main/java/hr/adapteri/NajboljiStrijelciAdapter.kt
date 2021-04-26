package hr.adapteri

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.NajboljiStrijelci
import hr.dominik.nkjaki.databinding.JedanRedNajboljiStrijelciBinding
import hr.fragmenti.fragmenti.NajboljiStrijelciFragmentDirections

class NajboljiStrijelciAdapter : RecyclerView.Adapter<NajboljiStrijelciAdapter.ViewHolder>() {

    private var najboljiStrijelciList = emptyList<NajboljiStrijelci>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            JedanRedNajboljiStrijelciBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = najboljiStrijelciList[position]
        holder.binding.najboljiStrijelciPozicija.text = currentItem.pozicijaPoGolovima
        holder.binding.najboljiStrijelciIme.text = currentItem.imeIgraca
        holder.binding.najboljiStrijelciGolovi.text = currentItem.brojGolova

        holder.binding.jedanRedStrijelci.setOnLongClickListener {
            val action =
                NajboljiStrijelciFragmentDirections.actionNajboljiStrijelciFragmentToAdminPrijavaStrijelci(
                    currentItem
                )
            holder.itemView.findNavController().navigate(action)
            true
        }
    }

    override fun getItemCount(): Int {
        return najboljiStrijelciList.size
    }

    class ViewHolder(val binding: JedanRedNajboljiStrijelciBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    fun setData(najboljiStrijelac: List<NajboljiStrijelci>) {
        this.najboljiStrijelciList = najboljiStrijelac
        notifyDataSetChanged()
    }

}