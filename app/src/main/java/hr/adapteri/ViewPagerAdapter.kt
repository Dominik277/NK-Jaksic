package hr.adapteri

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(private val context: Context, private val words: List<String>) :
    RecyclerView.Adapter<ViewPagerAdapter.PageHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: PageHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class PageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}