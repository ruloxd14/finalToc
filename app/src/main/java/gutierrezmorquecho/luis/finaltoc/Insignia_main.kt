package gutierrezmorquecho.luis.finaltoc

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_insignia_main.*

class Insignia_main : AppCompatActivity() {
    private var insignias= ArrayList<Insignia>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insignia_main)

        agregarProducto()
        var adapterInsignias: Adaptador_Insignias= Adaptador_Insignias(this, insignias)
        listVItems.adapter=adapterInsignias
    }

    fun agregarProducto(){
        insignias.add(Insignia( "Numero #1", R.drawable.insignia1, "Esta insignia se gana por instalar la aplicación, Felicidades!"))
        insignias.add(Insignia("Bloqueado", R.drawable.insignia_defecto, "Conseguiste realizar la actividad 7, Felicidades!"))
        insignias.add(Insignia("Bloqueado", R.drawable.insignia_defecto, "Realizasté 5 actividades sin equivocarte,. eres increible!"))
        insignias.add(Insignia("Bloqueado", R.drawable.insignia_defecto, "Realiza 3 actividades"))
        insignias.add(Insignia("Bloqueado", R.drawable.insignia_defecto, "Realiza 10 actividades"))

}
    private class Adaptador_Insignias : BaseAdapter{
        var insignia= ArrayList<Insignia>()
        var context: Context?=null

        constructor(context: Context, insignia: ArrayList<Insignia>) {
            this.insignia= insignia
            this.context=context
        }


        override fun getCount(): Int {
            return insignia.size
        }

        override fun getItem(position: Int): Any {
            return this.insignia[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var prod= this.insignia[position]
            var inflator= LayoutInflater.from(this.context)
            var vista=inflator.inflate(R.layout.insignia_view,null)

            var img= vista.findViewById(R.id.insignia_img) as ImageView
            var nombre= vista.findViewById(R.id.insignia_tittle)  as TextView
            var description= vista.findViewById(R.id.insignia_description) as TextView

            img.setImageResource(prod.image)
            nombre.setText(prod.name)
            description.setText(prod.description)
            return vista
        }
    }

}