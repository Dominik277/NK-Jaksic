package hr.database.table

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "rezultat_rezultat")
data class Rezultat (

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "natjecanje_rezultat")
    val natjecanjeRezultat: String,

    @ColumnInfo(name = "datum_rezultat")
    val datumRezultat: String,

    @ColumnInfo(name = "domacin_rezultat")
    val domacinRezultat: String,

    @ColumnInfo(name = "gost_rezultat")
    val gostRezultat: String,

    @ColumnInfo(name = "rezultat_utakmice")
    val rezultatUtakmice: String,

    @ColumnInfo(name = "ishod_rezultat")
    val ishodRezultat: String,

    @ColumnInfo(name = "clanak_rezultat")
    val clanakRezultat: String

        ): Parcelable