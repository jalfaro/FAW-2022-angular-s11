package gt.edu.galileo.segundoparcial.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import gt.edu.galileo.segundoparcial.model.Informacion

@Dao
interface InformacionDao {
    @Insert
    suspend fun insertInfo(vararg info: Informacion) : List<Long>
    @Query("SELECT id, descripcion, uri, tipo From Informacion")
    suspend fun selectAll(): List<Informacion>
}
