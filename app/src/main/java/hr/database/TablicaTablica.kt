package hr.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tablica_tablica")
data class TablicaTablica (

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "pozicija")
    val pozicija: Int,

    @ColumnInfo(name = "ime_tima")
    val imeTima: String,

    @ColumnInfo(name = "odigrani_susreti")
    val odigraniSusreti: Int,

    @ColumnInfo(name = "gol_razlika")
    val golRazlika: Int,

    @ColumnInfo(name = "bodovi")
    val bodovi: Int,

        )