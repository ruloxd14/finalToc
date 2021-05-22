package gutierrezmorquecho.luis.finaltoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_log_in.*
import kotlinx.android.synthetic.main.activity_log_in.txtCorreo
import kotlinx.android.synthetic.main.activity_registro.*

class Registro : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        auth = Firebase.auth



        btnRegistrarse.setOnClickListener {
            valida_registro()
        }

    }

    private fun valida_registro(){
        //var nombre: String = txtNombre.text.toString()
        var correo: String = txtCorreo.text.toString()
        var contra1: String = txtContraReg.text.toString()
        var contra2: String = txtVerificarContra.text.toString()

        //!nombre.isNullOrBlank() &&
        if(!correo.isNullOrBlank() && !contra1.isNullOrBlank() &&
            !contra2.isNullOrBlank()){



            if(contra1 == contra2){
                registrarFirebase(correo, contra1)

            }else{
                Toast.makeText(this, "Las contraseña no coinciden",
                    Toast.LENGTH_SHORT).show()
            }

        }else{
            Toast.makeText(this, "Ingresar datos",
                Toast.LENGTH_SHORT).show()
        }
    }

    private fun registrarFirebase(email: String, password: String){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    //Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser

                    Toast.makeText(baseContext, "${user?.email} Se ha creado correctamente",
                        Toast.LENGTH_SHORT).show()
                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    //Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Ocurrió un error al registrar.",
                        Toast.LENGTH_SHORT).show()
                    //updateUI(null)
                }
            }
    }


}