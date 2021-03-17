package hr.updateDelete

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import hr.dominik.nkjaki.R
import hr.viewModel.MomcadViewModel
import kotlinx.coroutines.InternalCoroutinesApi

class UpdateMomcadFragment: Fragment() {

    private val args by navArgs<UpdateMomcadFragmentArgs>()
    @InternalCoroutinesApi
    private lateinit var mMomcadViewModel: MomcadViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.update_momcad_fragment,container,false)

        mMomcadViewModel = ViewModelProvider(this).get(MomcadViewModel::class.java)

        return view
    }

}