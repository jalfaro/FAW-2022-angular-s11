package gt.edu.galileo.segundoparcial.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import gt.edu.galileo.segundoparcial.database.InformacionDataBase
import gt.edu.galileo.segundoparcial.model.Informacion
import kotlinx.coroutines.launch

class ListadoViewModel(val app: Application): BaseViewModel(app) {
    val listadoInfo: MutableLiveData<List<Informacion>> = MutableLiveData(arrayListOf())
    fun getInfo() {
        launch {
            listadoInfo.value = InformacionDataBase(app).infoDao().selectAll()
        }
    }
}