package gutierrezmorquecho.luis.finaltoc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_nota_main.*
import java.io.*

class Nota_main : AppCompatActivity() {

    private var notes = ArrayList<Nota>()
    private lateinit var notesAdapter: AdapterNotes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nota_main)

        leerNotas()

        notesAdapter = AdapterNotes(this, notes)
        listview_notas.adapter = notesAdapter

        add.setOnClickListener {
            var intent: Intent = Intent(this, addNotesActivity::class.java)
            startActivity(intent)
        }
    }

    private fun leerNotas() {
        notes.clear()
        var carpeta = File(ubicacion().absolutePath)
        if (carpeta.exists()) {
            var archivos = carpeta.listFiles()
            if (archivos != null) {
                for (file in archivos) {
                    leerArchivo(file)
                }
            }
        }
    }

    private fun leerArchivo(file: File) {
        val fileIS = FileInputStream(file)
        val dataIS = DataInputStream(fileIS)
        val bufferR = BufferedReader(InputStreamReader(dataIS))
        var strLine: String? = bufferR.readLine()
        var myData = ""
        while (strLine != null) {
            myData += strLine
            strLine = bufferR.readLine()
        }
        bufferR.close()
        dataIS.close()
        fileIS.close()

        //elimina el .txt
        var nombre = file.name.substring(0, file.name.length - 4)
        var nota = Nota(nombre, myData)
        notes.add(nota)
    }

    private fun ubicacion(): File {
        val folder = File(getExternalFilesDir(null), "notas")
        if (!folder.exists()) {
            folder.mkdir()
        }
        return folder
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Toast.makeText(this,"cosa regresa", Toast.LENGTH_LONG).show()
        if(requestCode == 235){
            leerNotas()
            notesAdapter.notifyDataSetChanged()
        }
    }
}