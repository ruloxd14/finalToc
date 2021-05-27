package gutierrezmorquecho.luis.finaltoc

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_material_extra_lectura_actividad.*

class Material_extra_ocio_actividad : AppCompatActivity() {

    var url_rompecabeza = "https://drive.google.com/file/d/1mvOySLoFjDC1YJFf0YWxe28GgBw1LR9N/view"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material_extra_ocio_actividad)

        descargarMaterial.setOnClickListener {
            var intent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse(url_rompecabeza))
            startActivity(intent)
        }
    }
}