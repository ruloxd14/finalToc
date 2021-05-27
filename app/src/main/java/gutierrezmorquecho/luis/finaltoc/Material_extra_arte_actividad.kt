package gutierrezmorquecho.luis.finaltoc

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_material_extra_arte_actividad.*
import java.net.URI

class Material_extra_arte_actividad : AppCompatActivity() {

    var url_casa = "https://drive.google.com/file/d/1k_1TTKphb0fe5BsL63AzcYP3UAnb2YKx/view?usp=sharing";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material_extra_arte_actividad)

        descargarMaterial.setOnClickListener {
            var intent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse(url_casa))
            startActivity(intent)
        }
    }
}