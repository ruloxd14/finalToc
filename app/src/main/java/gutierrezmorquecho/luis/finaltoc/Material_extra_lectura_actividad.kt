package gutierrezmorquecho.luis.finaltoc

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_material_extra_arte_actividad.*
import kotlinx.android.synthetic.main.activity_material_extra_lectura_actividad.*
import kotlinx.android.synthetic.main.activity_material_extra_lectura_actividad.descargarMaterial

class Material_extra_lectura_actividad : AppCompatActivity() {

    var url_lecturaPaco = "https://drive.google.com/file/d/1Gb5VDKwXfmAJZUdcFJcaBJXM8-OpKpAw/view"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material_extra_lectura_actividad)

        descargarMaterial.setOnClickListener {
            var intent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse(url_lecturaPaco))
            startActivity(intent)
        }
    }
}