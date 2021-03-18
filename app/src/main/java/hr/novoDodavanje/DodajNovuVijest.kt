package hr.novoDodavanje

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
import android.widget.Button
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import hr.database.table.Vijesti
import hr.dominik.nkjaki.R
import hr.viewModel.VijestiViewModel
import kotlinx.android.synthetic.main.fragment_nova_vijest.*
import kotlinx.android.synthetic.main.fragment_nova_vijest.view.*
import kotlinx.android.synthetic.main.fragment_novi_igrac.*
import kotlinx.coroutines.InternalCoroutinesApi
import java.text.SimpleDateFormat
import java.util.*

class DodajNovuVijest: Fragment() {

    @InternalCoroutinesApi
    private lateinit var mVijestiViewModel: VijestiViewModel

    private val REQUEST_PERMISSION = 100
    private val REQUEST_IMAGE_CAPTURE = 1
    private val REQUEST_PICK_IMAGE = 2

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_nova_vijest, container, false)

        mVijestiViewModel = ViewModelProvider(this).get(VijestiViewModel::class.java)

        view.novaVijestGumbSpremi.setOnClickListener {
            val action = DodajNovuVijestDirections.actionDodajNovuVijest2ToVijestiFragment()
            findNavController().navigate(action)
            insertDataToDatabase()
        }

/*
        view.gumbVijestGalerija.setOnClickListener {
            openGallery()
        }

        view.gumbVijestUslikaj.setOnClickListener {
            openCamera()
        }
 */

        return view
    }

    @InternalCoroutinesApi
    private fun insertDataToDatabase() {
        val sdf = SimpleDateFormat("dd.MM.yyyy. HH:mm")
        val currentDate = sdf.format(Date())

        val noviNaslov = novaVijestNaslov.text.toString()
        val novoVrijeme = currentDate
        val noviClanak = novaVijestClanak.text.toString()
        val novaSlika = R.drawable.jaksic

        val vijest = Vijesti(0,noviNaslov,noviClanak,novoVrijeme,novaSlika)
        mVijestiViewModel.addVijesti(vijest)
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
                imageViewVijesti.setImageBitmap(bitmap)
            }else if (requestCode == REQUEST_PICK_IMAGE) {
                val uri = data?.getData()
                imageViewVijesti.setImageURI(uri)
            }
        }
    }
     */
}