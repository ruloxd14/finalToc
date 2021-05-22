package gutierrezmorquecho.luis.finaltoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_restablecer_contrasena.*

class Restablecer_contrasena : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restablecer_contrasena)

        auth = Firebase.auth

        btn_restablecer.setOnClickListener {
            var correo: String = txtCorreo.text.toString()

            if(!correo.isNullOrBlank()){
                auth.sendPasswordResetEmail(correo)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful){
                            Toast.makeText(this, "Se envio un correo a $correo",
                                Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this, "Error al enviar correo",
                                Toast.LENGTH_SHORT).show()
                        }
                    }
            }else{
                Toast.makeText(this,"Ingresar correo",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}