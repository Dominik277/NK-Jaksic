package hr.database.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rezultat_rezultat")
data class Rezultat (

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "datum_rezultat")
    val datumRezultat: String,

    @ColumnInfo(name = "ogled_rezultat")
    val ogledRezultat: String,

    @ColumnInfo(name = "rezultat_utakmice")
    val rezultatUtakmice: String,

    @ColumnInfo(name = "ishod_rezultat")
    val ishodRezultat: String

        )