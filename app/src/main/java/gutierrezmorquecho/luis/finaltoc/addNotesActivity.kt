package gutierrezmorquecho.luis.finaltoc

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_add_notes.*
import java.io.File
import java.io.FileOutputStream

class addNotesActivity : AppCompatActivity() {
    private final var REQUEST_CODE=235
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes)

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
                fos.close()
                Toast.makeText(this, "Se guardó correctamente", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(this, "Error, no se ha podido guardar el archiso", Toast.LENGTH_SHORT).show()
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