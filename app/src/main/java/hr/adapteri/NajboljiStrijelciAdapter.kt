package hr.adapteri

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.NajboljiStrijelci

class NajboljiStrijelciAdapter(private val sviStrijelciUBazi: List<NajboljiStrijelci>) : RecyclerView.Adapter<NajboljiStrijelciAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NajboljiStrijelciAdapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: NajboljiStrijelciAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

}