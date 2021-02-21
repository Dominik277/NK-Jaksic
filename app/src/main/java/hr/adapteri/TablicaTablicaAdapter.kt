package hr.adapteri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.TablicaTablica
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.jedan_red_tablica_tablica.view.*

class TablicaTablicaAdapter (private val sveTabliceUBazi: List<TablicaTablica>) : RecyclerView.Adapter<TablicaTablicaAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_tablica_tablica, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.pokus_tablica_pozicija.text = sveTabliceUBazi[position].pozicija.toString()
        holder.itemView.pokus_tablica_ime.text = sveTabliceUBazi[position].imeTima
        holder.itemView.pokus_tablica_susreti.text = sveTabliceUBazi[position].odigraniSusreti.toString()
        holder.itemView.pokus_tablica_golovi.text = sveTabliceUBazi[position].golRazlika.toString()
        holder.itemView.pokus_tablica_bodovi.text = sveTabliceUBazi[position].bodovi.toString()
    }

    override fun getItemCount() = sveTabliceUBazi.size


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tablicaPozicija: TextView = itemView.pokus_tablica_pozicija
        val tablicaIme: TextView = itemView.pokus_tablica_ime
        val tablicaSusreti: TextView = itemView.pokus_tablica_susreti
        val tablicaGolovi: TextView = itemView.pokus_tablica_golovi
        val tablicaBodovi: TextView = itemView.pokus_tablica_bodovi
    }

}