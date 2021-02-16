package hr.adapteri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.database.TablicaTablica
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.jedan_red_tablica.view.*

class TablicaTablicaAdapter(private val tablicaList: List<TablicaTablica>) :
    RecyclerView.Adapter<TablicaTablicaAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TablicaTablicaAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_tablica,parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TablicaTablicaAdapter.ViewHolder, position: Int) {
        holder.tablicaPozicija.text = tablicaList[position].bodovi.toString()
        holder.tablicaIme.text = tablicaList[position].imeTima
        holder.tablicaSusreti.text = tablicaList[position].odigraniSusreti.toString()
        holder.tablicaGolovi.text = tablicaList[position].golRazlika.toString()
        holder.tablicaBodovi.text = tablicaList[position].bodovi.toString()
    }

    override fun getItemCount() = tablicaList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tablicaPozicija: TextView = itemView.tablica_pozicija
        val tablicaIme: TextView = itemView.tablica_ime
        val tablicaSusreti: TextView = itemView.tablica_susreti
        val tablicaGolovi: TextView = itemView.tablica_golovi
        val tablicaBodovi: TextView = itemView.tablica_bodovi
    }

}