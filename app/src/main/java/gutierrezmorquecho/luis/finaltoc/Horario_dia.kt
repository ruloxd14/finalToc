package gutierrezmorquecho.luis.finaltoc

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_material_extra_arte_actividad.*

class Horario_dia : AppCompatActivity() {

    var url_objetos = "https://drive.google.com/file/d/1Jn4dl2g8ORgTUKchtVAJhpakoU8kSgMF/view?usp=sharing";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horario_dia)

        descargarMaterial.setOnClickListener {
            var intent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse(url_objetos))
            startActivity(intent)
        }


    }
}