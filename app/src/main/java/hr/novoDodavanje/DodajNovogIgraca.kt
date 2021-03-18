package hr.novoDodavanje

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import hr.database.table.Igraci
import hr.dominik.nkjaki.R
import hr.viewModel.MomcadViewModel
import kotlinx.android.synthetic.main.fragment_nova_vijest.*
import kotlinx.android.synthetic.main.fragment_novi_igrac.*
import kotlinx.android.synthetic.main.fragment_novi_igrac.view.*
import kotlinx.coroutines.InternalCoroutinesApi
import java.util.jar.Manifest

class DodajNovogIgraca: Fragment() {

    private val REQUEST_PERMISSION = 100
    private val REQUEST_IMAGE_CAPTURE = 1
    private val REQUEST_PICK_IMAGE = 2

    @InternalCoroutinesApi
    private lateinit var mMomcadViewModel: MomcadViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_novi_igrac,container, false)

        mMomcadViewModel = ViewModelProvider(this).get(MomcadViewModel::class.java)

        view.gumbSpremiNoviIgrac.setOnClickListener {
            val action = DodajNovogIgracaDirections.actionDodajNovogIgraca2ToMomcadFragment()
            findNavController().navigate(action)
            insertDataToDatabase()
        }

        /*
        view.gumbIgracUslikaj.setOnClickListener {
            openCamera()
        }

        view.gumbIgracGalerija.setOnClickListener {
            openGallery()
        }
        */
        return view
    }

    @InternalCoroutinesApi
    private fun insertDataToDatabase() {
        val igracIme = noviIgracIme.text.toString()
        val igracPrezime = noviIgracPrezime.text.toString()
        val igracBroj = noviIgracBroj.text.toString()
        val igracSlika = R.drawable.face

        val igrac = Igraci(0,igracIme,igracPrezime,igracBroj,igracSlika)
        mMomcadViewModel.addMomcad(igrac)
    }

    /*
    override fun onResume() {
        super.onResume()
        checkCameraPermission()
    }
     */

    /*
    private fun checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(requireContext(),android.Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(requireActivity(),arrayOf(android.Manifest.permission.CAMERA),
            REQUEST_PERMISSION)
        }
    }
     */


    /*
    private fun openCamera() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { intent ->
            activity?.let {
                intent.resolveActivity(it.packageManager)?.also {
                    startActivityForResult(intent,REQUEST_IMAGE_CAPTURE)
                }
            }
        }
    }
     */

    private fun openGallery() {
        Intent(Intent.ACTION_GET_CONTENT).also { intent ->
            intent.type = "image/*"
            activity?.let {
                intent.resolveActivity(it.packageManager)?.also {
                    startActivityForResult(intent,REQUEST_PICK_IMAGE)
                }
            }
        }
    }

/*
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == RESULT_OK){
            if (requestCode == REQUEST_IMAGE_CAPTURE) {
                val bitmap = data?.extras?.get("data") as Bitmap
                imageViewIgrac.setImageBitmap(bitmap)
            }else if (requestCode == REQUEST_PICK_IMAGE) {
                val uri = data?.getData()
                imageViewIgrac.setImageURI(uri)
            }
        }
    }
*/
}