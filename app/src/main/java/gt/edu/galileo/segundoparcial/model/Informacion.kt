package gt.edu.galileo.segundoparcial.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class Informacion(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo()
    val descripcion: String,
    @ColumnInfo()
    val uri: String,
    @ColumnInfo()
    val tipo: Int  //0 - WEB y 1 - TELEFONO
)
