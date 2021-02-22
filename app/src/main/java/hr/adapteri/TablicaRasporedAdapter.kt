package hr.adapteri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.TablicaRaspored
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.jedan_red_tablica_raspored.view.*

class TablicaRasporedAdapter(private val sviNoviRasporediUBazi: List<TablicaRaspored>): RecyclerView.Adapter<TablicaRasporedAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TablicaRasporedAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_tablica_raspored, parent, false)
        return TablicaRasporedAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: TablicaRasporedAdapter.ViewHolder, position: Int) {
        holder.itemView.tv_brojKola.text = sviNoviRasporediUBazi[position].brojKola.toString()
        holder.itemView.tv_prvaUtakmica_datum.text = sviNoviRasporediUBazi[position].prvaUtakmicaDatum
        holder.itemView.tv_domacinPrvaUtakmica.text = sviNoviRasporediUBazi[position].prvaUtakmicaDomacin
        holder.itemView.tv_gostPrvaUtakmica.text = sviNoviRasporediUBazi[position].prvaUtakmicaGost
        holder.itemView.tv_drugaUtakmica_datum.text = sviNoviRasporediUBazi[position].drugaUtakmicaDatum
        holder.itemView.tv_domacinDrugaUtakmica.text = sviNoviRasporediUBazi[position].drugaUtakmicaDomacin
        holder.itemView.tv_gostDrugaUtakmica.text = sviNoviRasporediUBazi[position].drugaUtakmicaGost
        holder.itemView.tv_vrijemeDrugaUtakmica.text = sviNoviRasporediUBazi[position].drugaUtakmicaVrijeme
        holder.itemView.tv_trecaUtakmica_datum.text = sviNoviRasporediUBazi[position].trecaUtakmicaDatum
        holder.itemView.tv_domacinTrecaUtakmica.text = sviNoviRasporediUBazi[position].trecaUtakmicaDomacin
        holder.itemView.tv_gostTrecaUtakmica.text = sviNoviRasporediUBazi[position].trecaUtakmicaGost
        holder.itemView.tv_vrijemeTrecaUtakmica.text = sviNoviRasporediUBazi[position].trecaUtakmicaVrijeme
        holder.itemView.tv_cetvrtaUtakmica_datum.text = sviNoviRasporediUBazi[position].cetvrtaUtakmicaDatum
        holder.itemView.tv_domacinCetvrtaUtakmica.text = sviNoviRasporediUBazi[position].cetvrtaUtakmicaDomacin
        holder.itemView.tv_gostCetvrtaUtakmica.text = sviNoviRasporediUBazi[position].cetvrtaUtakmicaGost
        holder.itemView.tv_vrijemeCetvrtaUtakmica.text = sviNoviRasporediUBazi[position].cetvrtaUtakmicaVrijeme
        holder.itemView.tv_petaUtakmica_datum.text = sviNoviRasporediUBazi[position].petaUtakmicaDatum
        holder.itemView.tv_domacinPetaUtakmica.text = sviNoviRasporediUBazi[position].petaUtakmicaDomacin
        holder.itemView.tv_gostPetaUtakmica.text = sviNoviRasporediUBazi[position].petaUtakmicaGost
        holder.itemView.tv_vrijemePetaUtakmica.text = sviNoviRasporediUBazi[position].petaUtakmicaVrijeme
        holder.itemView.tv_sestaUtakmica_datum.text = sviNoviRasporediUBazi[position].sestaUtakmicaDatum
        holder.itemView.tv_domacinSestaUtakmica.text = sviNoviRasporediUBazi[position].sestaUtakmicaDomacin
        holder.itemView.tv_gostSestaUtakmica.text = sviNoviRasporediUBazi[position].sestaUtakmicaGost
        holder.itemView.tv_vrijemeSestaUtakmica.text = sviNoviRasporediUBazi[position].sestaUtakmicaVrijeme
        holder.itemView.tv_sedmaUtakmica_datum.text = sviNoviRasporediUBazi[position].sedmaUtakmicaDatum
        holder.itemView.tv_domacinSedmaUtakmica.text = sviNoviRasporediUBazi[position].sedmaUtakmicaDomacin
        holder.itemView.tv_gostSedmaUtakmica.text = sviNoviRasporediUBazi[position].sedmaUtakmicaGost
        holder.itemView.tv_vrijemeSedmaUtakmica.text = sviNoviRasporediUBazi[position].sedmaUtakmicaVrijeme

    }

    override fun getItemCount() = sviNoviRasporediUBazi.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

}