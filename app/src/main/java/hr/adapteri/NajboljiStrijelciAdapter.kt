package hr.adapteri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.NajboljiStrijelci
import hr.database.table.Raspored
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.jedan_red_najbolji_strijelci.view.najboljiStrijelciGolovi
import kotlinx.android.synthetic.main.jedan_red_najbolji_strijelci.view.najboljiStrijelciIme
import kotlinx.android.synthetic.main.jedan_red_najbolji_strijelci.view.najboljiStrijelciPozicija

class NajboljiStrijelciAdapter: RecyclerView.Adapter<NajboljiStrijelciAdapter.ViewHolder>() {

    private var najboljiStrijelciList = emptyList<NajboljiStrijelci>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_najbolji_strijelci, parent, false)
        return ViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = najboljiStrijelciList[position]
        holder.itemView.najboljiStrijelciPozicija.text = currentItem.pozicijaPoGolovima
        holder.itemView.najboljiStrijelciIme.text = currentItem.imeIgraca
        holder.itemView.najboljiStrijelciGolovi.text = currentItem.brojGolova
    }

    override fun getItemCount(): Int{
        return  najboljiStrijelciList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    fun setData(najboljiStrijelac: List<NajboljiStrijelci>){
        this.najboljiStrijelciList = najboljiStrijelac
        notifyDataSetChanged()
    }

}