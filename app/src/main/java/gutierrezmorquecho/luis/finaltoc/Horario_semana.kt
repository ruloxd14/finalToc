package gutierrezmorquecho.luis.finaltoc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_horario_semana.*
import kotlinx.android.synthetic.main.fragment_home.*

class Horario_semana : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horario_semana)

        veractividad.setOnClickListener {
            var intent: Intent = Intent(this, Horario_dia::class.java)
            startActivity(intent)
        }
    }
}