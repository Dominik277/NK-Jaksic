package hr.novoDodavanje

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.fragment_nova_vijest.*
import kotlinx.android.synthetic.main.fragment_novi_igrac.*
import kotlinx.android.synthetic.main.fragment_novi_igrac.view.*

class DodajNovogIgraca: Fragment() {

    private val pickImage = 100
    private var imageUri: Uri? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_novi_igrac,container, false)

        view.gumbIgracGalerija.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery,pickImage)
        }
        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            imageViewIgrac.setImageURI(imageUri)
        }
    }
}