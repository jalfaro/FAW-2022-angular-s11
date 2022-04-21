package gt.edu.galileo.segundoparcial.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import gt.edu.galileo.segundoparcial.R
import gt.edu.galileo.segundoparcial.databinding.FragmentFormularioBinding
import gt.edu.galileo.segundoparcial.model.Informacion
import gt.edu.galileo.segundoparcial.viewmodel.FormularioViewModel


class FormularioFragment : Fragment() {
    lateinit var binding: FragmentFormularioBinding
    lateinit var viewmodel: FormularioViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFormularioBinding.inflate(layoutInflater, container, false)
        viewmodel = ViewModelProvider(this).get(FormularioViewModel::class.java)
        binding.btnGuardar.setOnClickListener {
            val info = Informacion(0, binding.txtDescripcion.text.toString(),
                binding.txtValor.text.toString(),
                binding.spTipoLink.selectedItemPosition
            )
            viewmodel.saveInfo(info);
            binding.txtDescripcion.text.clear()
            binding.txtValor.text.clear()
            binding.spTipoLink.setSelection(0)

        }
        binding.btnListado.setOnClickListener {
            binding.root.findNavController().navigate(R.id.action_formularioFragment_to_listadoFragment)
        }
        return binding.root
    }
}