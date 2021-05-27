package gutierrezmorquecho.luis.finaltoc

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_add_notes.*
import java.io.File
import java.io.FileOutputStream

class addNotesActivity : AppCompatActivity() {

    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario : FirebaseAuth

    private final var REQUEST_CODE=235
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes)

        //conexion a la BD
        storage = FirebaseFirestore.getInstance()
        //Conexión al usuario
        usuario= FirebaseAuth.getInstance()

        btnGuardar_addNotes.setOnClickListener {
            save_note()
        }
    }

    private fun save_note() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), REQUEST_CODE)
        } else {
            save()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            235 -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    save()
                } else {
                    Toast.makeText(this, "Error en los permisos", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun save() {
        var titulo = etTittleNote_addNotes.text.toString()
        var cuerpo = etContenidoNote_addNotes.text.toString()

        if (titulo == "" || cuerpo == "") {
            Toast.makeText(this, "Campos vacíos", Toast.LENGTH_SHORT).show()
        } else {
            try {
                var archivo = File(ubicacion(), titulo + ".txt")
                val fos = FileOutputStream(archivo)
                fos.write(cuerpo.toByteArray())

                val nota = hashMapOf(
                    "title" to titulo,
                    //"contenido" to cuerpo.toString(),
                    "contenido" to cuerpo,
                    //"email" to usuario.currentUser.email.toString())
                    "email" to usuario.currentUser!!.email.toString())


                Toast.makeText(baseContext, nota.toString(), Toast.LENGTH_SHORT).show()
                //conexión al catalogo de firebase
                storage.collection("notas")
                    .add(nota.toString())
                    .addOnSuccessListener {
                        Toast.makeText(this, "Nota Agregada", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Error: intente de nuevo", Toast.LENGTH_SHORT).show()
                    }

                //Toast.makeText(this, "Se guardó correctamente", Toast.LENGTH_SHORT).show()
                fos.close()

            } catch (e: Exception) {
                Toast.makeText(this, "Error, no se ha podido guardar la nota", Toast.LENGTH_SHORT).show()
            }
        }
        onBackPressed()
    }

    private fun ubicacion(): String {
        val carpeta = File(getExternalFilesDir(null), "notas")
        if (!carpeta.exists()) {
            carpeta.mkdir()
        }
        return carpeta.absolutePath
    }

    override fun onBackPressed() {
        super.onBackPressed()
        var intent= Intent(this,Nota_main::class.java)
        startActivityForResult( intent,REQUEST_CODE)
        finish()
    }


}