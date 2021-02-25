package hr.adapteri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.TablicaRezultati
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.jedan_red_tablica_rezultati.view.*

class TablicaRezultatiAdapter(private val sviNoviRezultatiUBazi: List<TablicaRezultati>): RecyclerView.Adapter<TablicaRezultatiAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_tablica_rezultati, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tablicaRezultati_brojKola.text = sviNoviRezultatiUBazi[position].novi_brojKola.toString()
        holder.itemView.tablicaRezultati_prvaUtakmica_datum.text = sviNoviRezultatiUBazi[position].novi_prvaUtakmicaDatum
        holder.itemView.tablicaRezultati_domacinPrvaUtakmica.text = sviNoviRezultatiUBazi[position].novi_prvaUtakmicaDomacin
        holder.itemView.tablicaRezultati_gostPrvaUtakmica.text = sviNoviRezultatiUBazi[position].novi_prvaUtakmicaGost
        holder.itemView.tablicaRezultati_rezultatPrvaUtakmica.text = sviNoviRezultatiUBazi[position].novi_prvaUtakmicaRezultat
        holder.itemView.tablicaRezultati_drugaUtakmica_datum.text = sviNoviRezultatiUBazi[position].novi_drugaUtakmicaDatum
        holder.itemView.tablicaRezultati_domacinDrugaUtakmica.text = sviNoviRezultatiUBazi[position].novi_drugaUtakmicaDomacin
        holder.itemView.tablicaRezultati_gostDrugaUtakmica.text = sviNoviRezultatiUBazi[position].novi_drugaUtakmicaGost
        holder.itemView.tablicaRezultati_rezultatDrugaUtakmica.text = sviNoviRezultatiUBazi[position].novi_drugaUtakmicaRezultat
        holder.itemView.tablicaRezultati_trecaUtakmica_datum.text = sviNoviRezultatiUBazi[position].novi_trecaUtakmicaDatum
        holder.itemView.tablicaRezultati_domacinTrecaUtakmica.text = sviNoviRezultatiUBazi[position].novi_trecaUtakmicaDomacin
        holder.itemView.tablicaRezultati_gostTrecaUtakmica.text = sviNoviRezultatiUBazi[position].novi_trecaUtakmicaGost
        holder.itemView.tablicaRezultati_rezultatTrecaUtakmica.text = sviNoviRezultatiUBazi[position].novi_trecaUtakmicaRezultat
        holder.itemView.tablicaRezultati_cetvrtaUtakmica_datum.text = sviNoviRezultatiUBazi[position].novi_cetvrtaUtakmicaDatum
        holder.itemView.tablicaRezultati_domacinCetvrtaUtakmica.text = sviNoviRezultatiUBazi[position].novi_cetvrtaUtakmicaDomacin
        holder.itemView.tablicaRezultati_gostCetvrtaUtakmica.text = sviNoviRezultatiUBazi[position].novi_cetvrtaUtakmicaGost
        holder.itemView.tablicaRezultati_rezultatCetvrtaUtakmica.text = sviNoviRezultatiUBazi[position].novi_cetvrtaUtakmicaRezultat
        holder.itemView.tablicaRezultati_petaUtakmica_datum.text = sviNoviRezultatiUBazi[position].novi_petaUtakmicaDatum
        holder.itemView.tablicaRezultati_domacinPetaUtakmica.text = sviNoviRezultatiUBazi[position].novi_petaUtakmicaDomacin
        holder.itemView.tablicaRezultati_gostPetaUtakmica.text = sviNoviRezultatiUBazi[position].novi_petaUtakmicaGost
        holder.itemView.tablicaRezultati_rezultatPetaUtakmica.text = sviNoviRezultatiUBazi[position].novi_petaUtakmicaRezultat
        holder.itemView.tablicaRezultati_sestaUtakmica_datum.text = sviNoviRezultatiUBazi[position].novi_sestaUtakmicaDatum
        holder.itemView.tablicaRezultati_domacinSestaUtakmica.text = sviNoviRezultatiUBazi[position].novi_sestaUtakmicaDomacin
        holder.itemView.tablicaRezultati_gostSestaUtakmica.text = sviNoviRezultatiUBazi[position].novi_sestaUtakmicaGost
        holder.itemView.tablicaRezultati_rezultatSestaUtakmica.text = sviNoviRezultatiUBazi[position].novi_sestaUtakmicaRezultat
        holder.itemView.tablicaRezultati_sedmaUtakmica_datum.text = sviNoviRezultatiUBazi[position].novi_sedmaUtakmicaDatum
        holder.itemView.tablicaRezultati_domacinSedmaUtakmica.text = sviNoviRezultatiUBazi[position].novi_sedmaUtakmicaDomacin
        holder.itemView.tablicaRezultati_gostSedmaUtakmica.text = sviNoviRezultatiUBazi[position].novi_sedmaUtakmicaGost
        holder.itemView.tablicaRezultati_rezultatSedmaUtakmica.text = sviNoviRezultatiUBazi[position].novi_sedmaUtakmicaRezultat
    }

    override fun getItemCount() = sviNoviRezultatiUBazi.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

}