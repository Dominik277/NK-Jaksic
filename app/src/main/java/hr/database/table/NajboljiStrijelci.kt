package hr.database.table

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "najbolji_strijelci")
data class NajboljiStrijelci (

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "pozicija_po_golovima")
    val pozicijaPoGolovima: String,

    @ColumnInfo(name = "ime_igraca")
    val imeIgraca: String,

    @ColumnInfo(name = "broj_golova")
    val brojGolova: String
        ): Parcelable