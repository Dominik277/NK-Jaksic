package hr.adapteri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.Raspored
import hr.database.table.TablicaRaspored
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.jedan_red_tablica_raspored.view.*

class TablicaRasporedAdapter: RecyclerView.Adapter<TablicaRasporedAdapter.ViewHolder>() {

    private var tablicaRasporedList = emptyList<TablicaRaspored>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_tablica_raspored, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = tablicaRasporedList[position]
        holder.itemView.tablicaRaspored_brojKola.text = currentItem.brojKola.toString()
        holder.itemView.tablicaRaspored_prvaUtakmica_datum.text = currentItem.prvaUtakmicaDatum
        holder.itemView.tablicaRaspored_domacinPrvaUtakmica.text = currentItem.prvaUtakmicaDomacin
        holder.itemView.tablicaRaspored_gostPrvaUtakmica.text = currentItem.prvaUtakmicaGost
        holder.itemView.tablicaRaspored_drugaUtakmica_datum.text = currentItem.drugaUtakmicaDatum
        holder.itemView.tablicaRaspored_domacinDrugaUtakmica.text = currentItem.drugaUtakmicaDomacin
        holder.itemView.tablicaRaspored_gostDrugaUtakmica.text = currentItem.drugaUtakmicaGost
        holder.itemView.tablicaRaspored_vrijemeDrugaUtakmica.text = currentItem.drugaUtakmicaVrijeme
        holder.itemView.tablicaRaspored_trecaUtakmica_datum.text = currentItem.trecaUtakmicaDatum
        holder.itemView.tablicaRaspored_domacinTrecaUtakmica.text = currentItem.trecaUtakmicaDomacin
        holder.itemView.tablicaRaspored_gostTrecaUtakmica.text = currentItem.trecaUtakmicaGost
        holder.itemView.tablicaRaspored_vrijemeTrecaUtakmica.text = currentItem.trecaUtakmicaVrijeme
        holder.itemView.tablicaRaspored_cetvrtaUtakmica_datum.text = currentItem.cetvrtaUtakmicaDatum
        holder.itemView.tablicaRaspored_domacinCetvrtaUtakmica.text = currentItem.cetvrtaUtakmicaDomacin
        holder.itemView.tablicaRaspored_gostCetvrtaUtakmica.text = currentItem.cetvrtaUtakmicaGost
        holder.itemView.tablicaRaspored_vrijemeCetvrtaUtakmica.text = currentItem.cetvrtaUtakmicaVrijeme
        holder.itemView.tablicaRaspored_petaUtakmica_datum.text = currentItem.petaUtakmicaDatum
        holder.itemView.tablicaRaspored_domacinPetaUtakmica.text = currentItem.petaUtakmicaDomacin
        holder.itemView.tablicaRaspored_gostPetaUtakmica.text = currentItem.petaUtakmicaGost
        holder.itemView.tablicaRaspored_vrijemePetaUtakmica.text = currentItem.petaUtakmicaVrijeme
        holder.itemView.tablicaRaspored_sestaUtakmica_datum.text = currentItem.sestaUtakmicaDatum
        holder.itemView.tablicaRaspored_domacinSestaUtakmica.text = currentItem.sestaUtakmicaDomacin
        holder.itemView.tablicaRaspored_gostSestaUtakmica.text = currentItem.sestaUtakmicaGost
        holder.itemView.tablicaRaspored_vrijemeSestaUtakmica.text = currentItem.sestaUtakmicaVrijeme
        holder.itemView.tablicaRaspored_sedmaUtakmica_datum.text = currentItem.sedmaUtakmicaDatum
        holder.itemView.tablicaRaspored_domacinSedmaUtakmica.text = currentItem.sedmaUtakmicaDomacin
        holder.itemView.tablicaRaspored_gostSedmaUtakmica.text = currentItem.sedmaUtakmicaGost
        holder.itemView.tablicaRaspored_vrijemeSedmaUtakmica.text = currentItem.sedmaUtakmicaVrijeme

    }

    override fun getItemCount(): Int{
        return tablicaRasporedList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    fun setData(tablicaRaspored: List<TablicaRaspored>){
        this.tablicaRasporedList = tablicaRaspored
        notifyDataSetChanged()
    }

}