package gutierrezmorquecho.luis.finaltoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_restablecer_contrasena.*

class Restablecer_contrasena : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restablecer_contrasena)

        btn_restablecer.setOnClickListener {
            var correo: String = txtCorreo.text.toString()

            if(!correo.isNullOrBlank()){
                Toast.makeText(this, "Se envio el correo, tdbn",
                    Toast.LENGTH_SHORT).show()
                /*auth.sendPasswordResetEmail(correo)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful){
                            Toast.makeText(this, "Se envio un correo a $correo",
                                Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this, "Error al enviar correo",
                                Toast.LENGTH_SHORT).show()
                        }
                    }*/
            }else{
                Toast.makeText(this,"Ingresar correo",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}