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
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: TablicaRasporedAdapter.ViewHolder, position: Int) {
        holder.itemView.tablicaRaspored_brojKola.text = sviNoviRasporediUBazi[position].brojKola.toString()
        holder.itemView.tablicaRaspored_prvaUtakmica_datum.text = sviNoviRasporediUBazi[position].prvaUtakmicaDatum
        holder.itemView.tablicaRaspored_domacinPrvaUtakmica.text = sviNoviRasporediUBazi[position].prvaUtakmicaDomacin
        holder.itemView.tablicaRaspored_gostPrvaUtakmica.text = sviNoviRasporediUBazi[position].prvaUtakmicaGost
        holder.itemView.tablicaRaspored_drugaUtakmica_datum.text = sviNoviRasporediUBazi[position].drugaUtakmicaDatum
        holder.itemView.tablicaRaspored_domacinDrugaUtakmica.text = sviNoviRasporediUBazi[position].drugaUtakmicaDomacin
        holder.itemView.tablicaRaspored_gostDrugaUtakmica.text = sviNoviRasporediUBazi[position].drugaUtakmicaGost
        holder.itemView.tablicaRaspored_vrijemeDrugaUtakmica.text = sviNoviRasporediUBazi[position].drugaUtakmicaVrijeme
        holder.itemView.tablicaRaspored_trecaUtakmica_datum.text = sviNoviRasporediUBazi[position].trecaUtakmicaDatum
        holder.itemView.tablicaRaspored_domacinTrecaUtakmica.text = sviNoviRasporediUBazi[position].trecaUtakmicaDomacin
        holder.itemView.tablicaRaspored_gostTrecaUtakmica.text = sviNoviRasporediUBazi[position].trecaUtakmicaGost
        holder.itemView.tablicaRaspored_vrijemeTrecaUtakmica.text = sviNoviRasporediUBazi[position].trecaUtakmicaVrijeme
        holder.itemView.tablicaRaspored_cetvrtaUtakmica_datum.text = sviNoviRasporediUBazi[position].cetvrtaUtakmicaDatum
        holder.itemView.tablicaRaspored_domacinCetvrtaUtakmica.text = sviNoviRasporediUBazi[position].cetvrtaUtakmicaDomacin
        holder.itemView.tablicaRaspored_gostCetvrtaUtakmica.text = sviNoviRasporediUBazi[position].cetvrtaUtakmicaGost
        holder.itemView.tablicaRaspored_vrijemeCetvrtaUtakmica.text = sviNoviRasporediUBazi[position].cetvrtaUtakmicaVrijeme
        holder.itemView.tablicaRaspored_petaUtakmica_datum.text = sviNoviRasporediUBazi[position].petaUtakmicaDatum
        holder.itemView.tablicaRaspored_domacinPetaUtakmica.text = sviNoviRasporediUBazi[position].petaUtakmicaDomacin
        holder.itemView.tablicaRaspored_gostPetaUtakmica.text = sviNoviRasporediUBazi[position].petaUtakmicaGost
        holder.itemView.tablicaRaspored_vrijemePetaUtakmica.text = sviNoviRasporediUBazi[position].petaUtakmicaVrijeme
        holder.itemView.tablicaRaspored_sestaUtakmica_datum.text = sviNoviRasporediUBazi[position].sestaUtakmicaDatum
        holder.itemView.tablicaRaspored_domacinSestaUtakmica.text = sviNoviRasporediUBazi[position].sestaUtakmicaDomacin
        holder.itemView.tablicaRaspored_gostSestaUtakmica.text = sviNoviRasporediUBazi[position].sestaUtakmicaGost
        holder.itemView.tablicaRaspored_vrijemeSestaUtakmica.text = sviNoviRasporediUBazi[position].sestaUtakmicaVrijeme
        holder.itemView.tablicaRaspored_sedmaUtakmica_datum.text = sviNoviRasporediUBazi[position].sedmaUtakmicaDatum
        holder.itemView.tablicaRaspored_domacinSedmaUtakmica.text = sviNoviRasporediUBazi[position].sedmaUtakmicaDomacin
        holder.itemView.tablicaRaspored_gostSedmaUtakmica.text = sviNoviRasporediUBazi[position].sedmaUtakmicaGost
        holder.itemView.tablicaRaspored_vrijemeSedmaUtakmica.text = sviNoviRasporediUBazi[position].sedmaUtakmicaVrijeme

    }

    override fun getItemCount() = sviNoviRasporediUBazi.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

}