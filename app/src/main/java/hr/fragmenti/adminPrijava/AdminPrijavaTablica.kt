package hr.fragmenti.adminPrijava

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import hr.dominik.nkjaki.R
import hr.dominik.nkjaki.databinding.AdminPrijavaTablicaBinding

class AdminPrijavaTablica: Fragment(R.layout.admin_prijava_tablica) {

    private lateinit var binding: AdminPrijavaTablicaBinding
    private val args by navArgs<AdminPrijavaTablicaArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AdminPrijavaTablicaBinding.bind(view)

        binding.gumbPrijavaAdminPrijaviSe.setOnClickListener {  }
    }

}