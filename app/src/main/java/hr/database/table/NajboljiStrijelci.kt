package hr.database.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "najbolji_strijelci")
data class NajboljiStrijelci (

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "pozicija_po_golovima")
    val pozicijaPoGolovima: Int,

    @ColumnInfo(name = "ime_igraca")
    val imeIgraca: String,

    @ColumnInfo(name = "broj_golova")
    val brojGolova: String
        )