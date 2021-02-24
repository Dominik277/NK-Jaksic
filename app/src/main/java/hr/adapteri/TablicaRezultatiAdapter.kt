package hr.adapteri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.NoviRezultati
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.jedan_red_tablica_raspored.view.*
import kotlinx.android.synthetic.main.novi_red_rezultati.view.*

class TablicaRezultatiAdapter(private val sviNoviRezultatiUBazi: List<NoviRezultati>): RecyclerView.Adapter<TablicaRezultatiAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jedan_red_tablica_rezultati, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.novi_tv_brojKola.text = sviNoviRezultatiUBazi[position].novi_brojKola.toString()
        holder.itemView.novi_tv_prvaUtakmica_datum.text = sviNoviRezultatiUBazi[position].novi_prvaUtakmicaDatum
        holder.itemView.novi_tv_domacinPrvaUtakmica.text = sviNoviRezultatiUBazi[position].novi_prvaUtakmicaDomacin
        holder.itemView.novi_tv_gostPrvaUtakmica.text = sviNoviRezultatiUBazi[position].novi_prvaUtakmicaGost
        holder.itemView.novi_tv_rezultatPrvaUtakmica.text = sviNoviRezultatiUBazi[position].novi_prvaUtakmicaRezultat
        holder.itemView.novi_tv_drugaUtakmica_datum.text = sviNoviRezultatiUBazi[position].novi_drugaUtakmicaDatum
        holder.itemView.novi_tv_domacinDrugaUtakmica.text = sviNoviRezultatiUBazi[position].novi_drugaUtakmicaDomacin
        holder.itemView.novi_tv_gostDrugaUtakmica.text = sviNoviRezultatiUBazi[position].novi_drugaUtakmicaGost
        holder.itemView.novi_tv_rezultatDrugaUtakmica.text = sviNoviRezultatiUBazi[position].novi_drugaUtakmicaRezultat
        holder.itemView.novi_tv_trecaUtakmica_datum.text = sviNoviRezultatiUBazi[position].novi_trecaUtakmicaDatum
        holder.itemView.novi_tv_domacinTrecaUtakmica.text = sviNoviRezultatiUBazi[position].novi_trecaUtakmicaDomacin
        holder.itemView.novi_tv_gostTrecaUtakmica.text = sviNoviRezultatiUBazi[position].novi_trecaUtakmicaGost
        holder.itemView.novi_tv_rezultatTrecaUtakmica.text = sviNoviRezultatiUBazi[position].novi_trecaUtakmicaRezultat
        holder.itemView.novi_tv_cetvrtaUtakmica_datum.text = sviNoviRezultatiUBazi[position].novi_cetvrtaUtakmicaDatum
        holder.itemView.novi_tv_domacinCetvrtaUtakmica.text = sviNoviRezultatiUBazi[position].novi_cetvrtaUtakmicaDomacin
        holder.itemView.novi_tv_gostCetvrtaUtakmica.text = sviNoviRezultatiUBazi[position].novi_cetvrtaUtakmicaGost
        holder.itemView.novi_tv_rezultatCetvrtaUtakmica.text = sviNoviRezultatiUBazi[position].novi_cetvrtaUtakmicaRezultat
        holder.itemView.novi_tv_petaUtakmica_datum.text = sviNoviRezultatiUBazi[position].novi_petaUtakmicaDatum
        holder.itemView.novi_tv_domacinPetaUtakmica.text = sviNoviRezultatiUBazi[position].novi_petaUtakmicaDomacin
        holder.itemView.novi_tv_gostPetaUtakmica.text = sviNoviRezultatiUBazi[position].novi_petaUtakmicaGost
        holder.itemView.novi_tv_rezultatPetaUtakmica.text = sviNoviRezultatiUBazi[position].novi_petaUtakmicaRezultat
        holder.itemView.novi_tv_sestaUtakmica_datum.text = sviNoviRezultatiUBazi[position].novi_sestaUtakmicaDatum
        holder.itemView.novi_tv_domacinSestaUtakmica.text = sviNoviRezultatiUBazi[position].novi_sestaUtakmicaDomacin
        holder.itemView.novi_tv_gostSestaUtakmica.text = sviNoviRezultatiUBazi[position].novi_sestaUtakmicaGost
        holder.itemView.novi_tv_rezultatSestaUtakmica.text = sviNoviRezultatiUBazi[position].novi_sestaUtakmicaRezultat
        holder.itemView.novi_tv_sedmaUtakmica_datum.text = sviNoviRezultatiUBazi[position].novi_sedmaUtakmicaDatum
        holder.itemView.novi_tv_domacinSedmaUtakmica.text = sviNoviRezultatiUBazi[position].novi_sedmaUtakmicaDomacin
        holder.itemView.novi_tv_gostSedmaUtakmica.text = sviNoviRezultatiUBazi[position].novi_sedmaUtakmicaGost
        holder.itemView.novi_tv_rezultatSedmaUtakmica.text = sviNoviRezultatiUBazi[position].novi_sedmaUtakmicaRezultat
    }

    override fun getItemCount() = sviNoviRezultatiUBazi.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

}