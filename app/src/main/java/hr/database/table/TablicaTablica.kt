package hr.database.table

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "tablica_tablica")
data class TablicaTablica (

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "pozicija")
    val pozicija: String,

    @ColumnInfo(name = "ime_tima")
    val imeTima: String,

    @ColumnInfo(name = "odigrani_susreti")
    val odigraniSusreti: String,

    @ColumnInfo(name = "gol_razlika")
    val golRazlika: String,

    @ColumnInfo(name = "bodovi")
    val bodovi: String,
        ):Parcelable