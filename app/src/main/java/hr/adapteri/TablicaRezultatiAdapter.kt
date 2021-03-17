package hr.adapteri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.TablicaRaspored
import hr.database.table.TablicaRezultati
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.jedan_red_tablica_rezultati.view.*

class TablicaRezultatiAdapter: RecyclerView.Adapter<TablicaRezultatiAdapter.ViewHolder>() {

    private var tablicaRezultatList = emptyList<TablicaRezultati>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_tablica_rezultati, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = tablicaRezultatList[position]
        holder.itemView.tablicaRezultati_brojKola.text = currentItem.novi_brojKola.toString()
        holder.itemView.tablicaRezultati_prvaUtakmica_datum.text = currentItem.novi_prvaUtakmicaDatum
        holder.itemView.tablicaRezultati_domacinPrvaUtakmica.text = currentItem.novi_prvaUtakmicaDomacin
        holder.itemView.tablicaRezultati_gostPrvaUtakmica.text = currentItem.novi_prvaUtakmicaGost
        holder.itemView.tablicaRezultati_rezultatPrvaUtakmica.text = currentItem.novi_prvaUtakmicaRezultat
        holder.itemView.tablicaRezultati_drugaUtakmica_datum.text = currentItem.novi_drugaUtakmicaDatum
        holder.itemView.tablicaRezultati_domacinDrugaUtakmica.text = currentItem.novi_drugaUtakmicaDomacin
        holder.itemView.tablicaRezultati_gostDrugaUtakmica.text = currentItem.novi_drugaUtakmicaGost
        holder.itemView.tablicaRezultati_rezultatDrugaUtakmica.text = currentItem.novi_drugaUtakmicaRezultat
        holder.itemView.tablicaRezultati_trecaUtakmica_datum.text = currentItem.novi_trecaUtakmicaDatum
        holder.itemView.tablicaRezultati_domacinTrecaUtakmica.text = currentItem.novi_trecaUtakmicaDomacin
        holder.itemView.tablicaRezultati_gostTrecaUtakmica.text = currentItem.novi_trecaUtakmicaGost
        holder.itemView.tablicaRezultati_rezultatTrecaUtakmica.text = currentItem.novi_trecaUtakmicaRezultat
        holder.itemView.tablicaRezultati_cetvrtaUtakmica_datum.text = currentItem.novi_cetvrtaUtakmicaDatum
        holder.itemView.tablicaRezultati_domacinCetvrtaUtakmica.text = currentItem.novi_cetvrtaUtakmicaDomacin
        holder.itemView.tablicaRezultati_gostCetvrtaUtakmica.text = currentItem.novi_cetvrtaUtakmicaGost
        holder.itemView.tablicaRezultati_rezultatCetvrtaUtakmica.text = currentItem.novi_cetvrtaUtakmicaRezultat
        holder.itemView.tablicaRezultati_petaUtakmica_datum.text = currentItem.novi_petaUtakmicaDatum
        holder.itemView.tablicaRezultati_domacinPetaUtakmica.text = currentItem.novi_petaUtakmicaDomacin
        holder.itemView.tablicaRezultati_gostPetaUtakmica.text = currentItem.novi_petaUtakmicaGost
        holder.itemView.tablicaRezultati_rezultatPetaUtakmica.text = currentItem.novi_petaUtakmicaRezultat
        holder.itemView.tablicaRezultati_sestaUtakmica_datum.text = currentItem.novi_sestaUtakmicaDatum
        holder.itemView.tablicaRezultati_domacinSestaUtakmica.text = currentItem.novi_sestaUtakmicaDomacin
        holder.itemView.tablicaRezultati_gostSestaUtakmica.text = currentItem.novi_sestaUtakmicaGost
        holder.itemView.tablicaRezultati_rezultatSestaUtakmica.text = currentItem.novi_sestaUtakmicaRezultat
        holder.itemView.tablicaRezultati_sedmaUtakmica_datum.text = currentItem.novi_sedmaUtakmicaDatum
        holder.itemView.tablicaRezultati_domacinSedmaUtakmica.text = currentItem.novi_sedmaUtakmicaDomacin
        holder.itemView.tablicaRezultati_gostSedmaUtakmica.text = currentItem.novi_sedmaUtakmicaGost
        holder.itemView.tablicaRezultati_rezultatSedmaUtakmica.text = currentItem.novi_sedmaUtakmicaRezultat
    }

    override fun getItemCount(): Int{
        return tablicaRezultatList.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    fun setData(tablicaRezultat: List<TablicaRezultati>){
        this.tablicaRezultatList = tablicaRezultat
        notifyDataSetChanged()
    }

}