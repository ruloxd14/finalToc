package gutierrezmorquecho.luis.finaltoc

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_material_extra_arte_actividad.*

class Material_extra_fisico_actividad : AppCompatActivity() {

    var url_video = "https://www.youtube.com/watch?v=HRs7Dfxl2-c"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material_extra_fisico_actividad)

        descargarMaterial.setOnClickListener {
            var intent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse(url_video))
            startActivity(intent)
        }
    }
}