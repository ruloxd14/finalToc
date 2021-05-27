package gutierrezmorquecho.luis.finaltoc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_material_extra_fisico_actividades.*

class Material_extra_fisico_actividades : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material_extra_fisico_actividades)

        verMasExtraBaile.setOnClickListener {
            var intent: Intent = Intent(this, Material_extra_fisico_actividad::class.java)
            startActivity(intent)
        }
    }
}