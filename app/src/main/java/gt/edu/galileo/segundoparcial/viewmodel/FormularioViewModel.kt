package gt.edu.galileo.segundoparcial.viewmodel

import android.app.Application
import gt.edu.galileo.segundoparcial.database.InformacionDataBase
import gt.edu.galileo.segundoparcial.model.Informacion
import kotlinx.coroutines.launch

class FormularioViewModel(val app: Application): BaseViewModel(app) {
    fun saveInfo(info: Informacion) {
        launch {
            InformacionDataBase(app).infoDao().insertInfo(info);
        }

    }
}