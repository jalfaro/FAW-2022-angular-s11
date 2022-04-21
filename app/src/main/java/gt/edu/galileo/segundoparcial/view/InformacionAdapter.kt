package gt.edu.galileo.segundoparcial.view

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import gt.edu.galileo.segundoparcial.R
import gt.edu.galileo.segundoparcial.model.Informacion

class InformacionAdapter(val array: ArrayList<Informacion>) :
    RecyclerView.Adapter<InformacionAdapter.InformacionViewHolder>() {
    class InformacionViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val imagen = view.findViewById<ImageView>(R.id.icono)
        val texto = view.findViewById<TextView>(R.id.descripcion)
        fun bind(dato: Informacion) {
            imagen.setImageResource(if (dato.tipo == 0) R.drawable.ic_web else R.drawable.ic_llamada)
            texto.text = dato.descripcion
            view.setOnClickListener {
                var intent =
                if (dato.tipo == 0)
                    Intent(Intent.ACTION_VIEW, Uri.parse(dato.uri))
                else
                    Intent(Intent.ACTION_VIEW, Uri.parse("tel://" + dato.uri))
                if (intent != null) view.context.startActivity(intent);
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        InformacionViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_dato,
            parent, false))


    override fun onBindViewHolder(holder: InformacionViewHolder, position: Int) {
        holder.bind(array[position])
    }

    override fun getItemCount() = array.size

    fun loadNewData(newArray : List<Informacion>) {
        array.clear()
        array.addAll(newArray)
        notifyDataSetChanged()
    }
}