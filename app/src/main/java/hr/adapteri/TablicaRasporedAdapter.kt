package hr.adapteri

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.TablicaRaspored
import hr.dominik.nkjaki.databinding.JedanRedTablicaRasporedBinding
import hr.fragmenti.fragmenti.TablicaRasporedFragmentDirections

class TablicaRasporedAdapter : RecyclerView.Adapter<TablicaRasporedAdapter.ViewHolder>() {

    private var tablicaRasporedList = emptyList<TablicaRaspored>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            JedanRedTablicaRasporedBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = tablicaRasporedList[position]
        holder.binding.tablicaRasporedBrojKola.text = currentItem.brojKola
        holder.binding.tablicaRasporedPrvaUtakmicaDatum.text = currentItem.prvaUtakmicaDatum
        holder.binding.tablicaRasporedDomacinPrvaUtakmica.text = currentItem.prvaUtakmicaDomacin
        holder.binding.tablicaRasporedGostPrvaUtakmica.text = currentItem.prvaUtakmicaGost
        holder.binding.tablicaRasporedVrijemePrvaUtakmica.text = currentItem.prvaUtakmicaVrijeme
        holder.binding.tablicaRasporedDrugaUtakmicaDatum.text = currentItem.drugaUtakmicaDatum
        holder.binding.tablicaRasporedDomacinDrugaUtakmica.text = currentItem.drugaUtakmicaDomacin
        holder.binding.tablicaRasporedGostDrugaUtakmica.text = currentItem.drugaUtakmicaGost
        holder.binding.tablicaRasporedVrijemeDrugaUtakmica.text = currentItem.drugaUtakmicaVrijeme
        holder.binding.tablicaRasporedTrecaUtakmicaDatum.text = currentItem.trecaUtakmicaDatum
        holder.binding.tablicaRasporedDomacinTrecaUtakmica.text = currentItem.trecaUtakmicaDomacin
        holder.binding.tablicaRasporedGostTrecaUtakmica.text = currentItem.trecaUtakmicaGost
        holder.binding.tablicaRasporedVrijemeTrecaUtakmica.text = currentItem.trecaUtakmicaVrijeme
        holder.binding.tablicaRasporedCetvrtaUtakmicaDatum.text = currentItem.cetvrtaUtakmicaDatum
        holder.binding.tablicaRasporedDomacinCetvrtaUtakmica.text = currentItem.cetvrtaUtakmicaDomacin
        holder.binding.tablicaRasporedGostCetvrtaUtakmica.text = currentItem.cetvrtaUtakmicaGost
        holder.binding.tablicaRasporedVrijemeCetvrtaUtakmica.text = currentItem.cetvrtaUtakmicaVrijeme
        holder.binding.tablicaRasporedPetaUtakmicaDatum.text = currentItem.petaUtakmicaDatum
        holder.binding.tablicaRasporedDomacinPetaUtakmica.text = currentItem.petaUtakmicaDomacin
        holder.binding.tablicaRasporedGostPetaUtakmica.text = currentItem.petaUtakmicaGost
        holder.binding.tablicaRasporedVrijemePetaUtakmica.text = currentItem.petaUtakmicaVrijeme
        holder.binding.tablicaRasporedSestaUtakmicaDatum.text = currentItem.sestaUtakmicaDatum
        holder.binding.tablicaRasporedDomacinSestaUtakmica.text = currentItem.sestaUtakmicaDomacin
        holder.binding.tablicaRasporedGostSestaUtakmica.text = currentItem.sestaUtakmicaGost
        holder.binding.tablicaRasporedVrijemeSestaUtakmica.text = currentItem.sestaUtakmicaVrijeme
        holder.binding.tablicaRasporedSedmaUtakmicaDatum.text = currentItem.sedmaUtakmicaDatum
        holder.binding.tablicaRasporedDomacinSedmaUtakmica.text = currentItem.sedmaUtakmicaDomacin
        holder.binding.tablicaRasporedGostSedmaUtakmica.text = currentItem.sedmaUtakmicaGost
        holder.binding.tablicaRasporedVrijemeSedmaUtakmica.text = currentItem.sedmaUtakmicaVrijeme

        holder.binding.jedanRedTablicaRaspored.setOnLongClickListener {
            val action =
                TablicaRasporedFragmentDirections.actionTablicaRasporedFragmentToAdminPrijavaRasporedLiga(
                    currentItem
                )
            holder.itemView.findNavController().navigate(action)
            true
        }

    }

    override fun getItemCount(): Int {
        return tablicaRasporedList.size
    }

    inner class ViewHolder(val binding: JedanRedTablicaRasporedBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    fun setData(tablicaRaspored: List<TablicaRaspored>) {
        this.tablicaRasporedList = tablicaRaspored
        notifyDataSetChanged()
    }
}