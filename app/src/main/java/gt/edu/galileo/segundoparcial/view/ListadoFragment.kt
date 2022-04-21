package gt.edu.galileo.segundoparcial.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import gt.edu.galileo.segundoparcial.R
import gt.edu.galileo.segundoparcial.databinding.FragmentListadoBinding
import gt.edu.galileo.segundoparcial.model.Informacion
import gt.edu.galileo.segundoparcial.viewmodel.ListadoViewModel


class ListadoFragment : Fragment() {
    lateinit var binding: FragmentListadoBinding
    lateinit var viewmodel : ListadoViewModel
    val adapter = InformacionAdapter(arrayListOf())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentListadoBinding.inflate(layoutInflater, container, false)
        viewmodel = ViewModelProvider(this).get(ListadoViewModel::class.java)
        binding.lista.layoutManager = LinearLayoutManager(context)
        binding.lista.adapter = adapter
        viewmodel.listadoInfo.observe(viewLifecycleOwner, { lista ->
            adapter.loadNewData(lista)
        });
        viewmodel.getInfo()
        return binding.root
    }
}