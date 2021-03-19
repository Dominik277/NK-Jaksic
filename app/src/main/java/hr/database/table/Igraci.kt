package hr.database.table

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "igraci")
data class Igraci(
        @PrimaryKey(autoGenerate = true)
        val id: Int,

        @ColumnInfo(name = "ime")
        val ime: String,

        @ColumnInfo(name = "prezime")
        val prezime: String,

        @ColumnInfo(name = "pozicija")
        val pozicija: String,

        @ColumnInfo(name = "odigranih_susreta")
        val odigranihSusreta: String,

        @ColumnInfo(name = "golova")
        val golova: String,

        @ColumnInfo(name = "asistencija")
        val asistencija: String,

        @ColumnInfo(name = "odigranih_minuta")
        val odigranihMinuta: String,

        @ColumnInfo(name = "zuti_kartoni")
        val zutiKartoni: String,

        @ColumnInfo(name = "crveni_kartoni")
        val crveniKartoni: String,

        @ColumnInfo(name = "broj")
        val broj: String,

        @ColumnInfo(name = "slika")
        val slika: Int
): Parcelable