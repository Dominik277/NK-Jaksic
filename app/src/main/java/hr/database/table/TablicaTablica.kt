package hr.database.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

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

        )