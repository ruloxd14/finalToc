package gutierrezmorquecho.luis.finaltoc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.nota_layout.view.*
import java.io.File

class AdapterNotes : BaseAdapter {
    private var context: Context
    private var notes = ArrayList<Nota>()

    constructor(context: Context, notas: ArrayList<Nota>) {
        this.context = context;
        this.notes = notas;
    }

    override fun getCount(): Int {
        return notes.size;
    }

    override fun getItem(position: Int): Any {
        return notes[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }



    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var inflator = LayoutInflater.from(context)
        var view = inflator.inflate(R.layout.nota_layout,null)
        var note= notes[position]

        view.btnNoteDelete.setOnClickListener {
            eliminar(note.title)
            notes.remove(note)
            this.notifyDataSetChanged()
        }
        view.tvNoteTitle.text= note.title
        view.tvNoteContent.text= note.contenido

        return view
    }
    private fun eliminar(titulo: String) {
        if(titulo.isEmpty()){
            Toast.makeText(context, "Error: título vacío", Toast.LENGTH_SHORT).show()
        }else{
            try {
                val archivo= File(ubicacion(), titulo+".txt")
                archivo.delete()
                Toast.makeText(context, "Se eliminó la nota", Toast.LENGTH_SHORT).show()
            }catch (e:Exception){
                Toast.makeText(context,  "Error: no se pudo eliminar la nota", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun ubicacion(): File? {
        val carpeta = File(context?.getExternalFilesDir(null), "notas")
        if(!carpeta.exists()){
            carpeta.mkdir()
        }
        return carpeta
    }
}