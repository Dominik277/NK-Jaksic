package hr.adapteri

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import hr.database.table.TablicaRezultati
import hr.dominik.nkjaki.databinding.JedanRedTablicaRezultatiBinding
import hr.fragmenti.fragmenti.TablicaRezultatiFragmentDirections

class TablicaRezultatiAdapter : RecyclerView.Adapter<TablicaRezultatiAdapter.ViewHolder>() {

    private var tablicaRezultatList = emptyList<TablicaRezultati>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            JedanRedTablicaRezultatiBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = tablicaRezultatList[position]
        holder.binding.tablicaRezultatiBrojKola.text = currentItem.novi_brojKola.toString()
        holder.binding.tablicaRezultatiPrvaUtakmicaDatum.text = currentItem.novi_prvaUtakmicaDatum
        holder.binding.tablicaRezultatiDomacinPrvaUtakmica.text = currentItem.novi_prvaUtakmicaDomacin
        holder.binding.tablicaRezultatiGostPrvaUtakmica.text = currentItem.novi_prvaUtakmicaGost
        holder.binding.tablicaRezultatiRezultatPrvaUtakmica.text = currentItem.novi_prvaUtakmicaRezultat
        holder.binding.tablicaRezultatiDrugaUtakmicaDatum.text = currentItem.novi_drugaUtakmicaDatum
        holder.binding.tablicaRezultatiDomacinDrugaUtakmica.text = currentItem.novi_drugaUtakmicaDomacin
        holder.binding.tablicaRezultatiGostDrugaUtakmica.text = currentItem.novi_drugaUtakmicaGost
        holder.binding.tablicaRezultatiRezultatDrugaUtakmica.text = currentItem.novi_drugaUtakmicaRezultat
        holder.binding.tablicaRezultatiTrecaUtakmicaDatum.text = currentItem.novi_trecaUtakmicaDatum
        holder.binding.tablicaRezultatiDomacinTrecaUtakmica.text = currentItem.novi_trecaUtakmicaDomacin
        holder.binding.tablicaRezultatiGostTrecaUtakmica.text = currentItem.novi_trecaUtakmicaGost
        holder.binding.tablicaRezultatiRezultatTrecaUtakmica.text = currentItem.novi_trecaUtakmicaRezultat
        holder.binding.tablicaRezultatiCetvrtaUtakmicaDatum.text = currentItem.novi_cetvrtaUtakmicaDatum
        holder.binding.tablicaRezultatiDomacinCetvrtaUtakmica.text = currentItem.novi_cetvrtaUtakmicaDomacin
        holder.binding.tablicaRezultatiGostCetvrtaUtakmica.text = currentItem.novi_cetvrtaUtakmicaGost
        holder.binding.tablicaRezultatiRezultatCetvrtaUtakmica.text = currentItem.novi_cetvrtaUtakmicaRezultat
        holder.binding.tablicaRezultatiPetaUtakmicaDatum.text = currentItem.novi_petaUtakmicaDatum
        holder.binding.tablicaRezultatiDomacinPetaUtakmica.text = currentItem.novi_petaUtakmicaDomacin
        holder.binding.tablicaRezultatiGostPetaUtakmica.text = currentItem.novi_petaUtakmicaGost
        holder.binding.tablicaRezultatiRezultatPetaUtakmica.text = currentItem.novi_petaUtakmicaRezultat
        holder.binding.tablicaRezultatiSestaUtakmicaDatum.text = currentItem.novi_sestaUtakmicaDatum
        holder.binding.tablicaRezultatiDomacinSestaUtakmica.text = currentItem.novi_sestaUtakmicaDomacin
        holder.binding.tablicaRezultatiGostSestaUtakmica.text = currentItem.novi_sestaUtakmicaGost
        holder.binding.tablicaRezultatiRezultatSestaUtakmica.text = currentItem.novi_sestaUtakmicaRezultat
        holder.binding.tablicaRezultatiSedmaUtakmicaDatum.text = currentItem.novi_sedmaUtakmicaDatum
        holder.binding.tablicaRezultatiDomacinSedmaUtakmica.text = currentItem.novi_sedmaUtakmicaDomacin
        holder.binding.tablicaRezultatiGostSedmaUtakmica.text = currentItem.novi_sedmaUtakmicaGost
        holder.binding.tablicaRezultatiRezultatSedmaUtakmica.text = currentItem.novi_sedmaUtakmicaRezultat

        holder.binding.jedanRedTablicaRezultati.setOnLongClickListener {
            val action =
                TablicaRezultatiFragmentDirections.actionTablicaRezultatiFragmentToAdminPrijavaRezultatiLiga(
                    currentItem
                )
            holder.itemView.findNavController().navigate(action)
            true
        }

    }

    override fun getItemCount(): Int {
        return tablicaRezultatList.size
    }

    inner class ViewHolder(val binding: JedanRedTablicaRezultatiBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    fun setData(tablicaRezultat: List<TablicaRezultati>) {
        this.tablicaRezultatList = tablicaRezultat
        notifyDataSetChanged()
    }

}