package gutierrezmorquecho.luis.finaltoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_log_in.*
import kotlinx.android.synthetic.main.activity_log_in.txtCorreo
import kotlinx.android.synthetic.main.activity_registro.*

class Registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)


        btnRegistrarse.setOnClickListener {
            valida_registro()
        }

    }

    private fun valida_registro(){
        var nombre: String = txtNombre.text.toString()
        var correo: String = txtCorreo.text.toString()
        var contra1: String = txtContra.text.toString()
        var contra2: String = txtVerificarContra.text.toString()


        if(!nombre.isNullOrBlank() && !correo.isNullOrBlank() && !contra1.isNullOrBlank() &&
            !contra2.isNullOrBlank()){



            if(contra1 == contra2){
                Toast.makeText(this, "Se ah registrado! wuuuyyyy",
                    Toast.LENGTH_SHORT).show()
                //registrarFirebase(correo, contra1)

            }else{
                Toast.makeText(this, "Las contraseña no coinciden",
                    Toast.LENGTH_SHORT).show()
            }

        }else{
            Toast.makeText(this, "Ingresar datos",
                Toast.LENGTH_SHORT).show()
        }
    }
}