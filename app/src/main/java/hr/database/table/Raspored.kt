package hr.database.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "raspored")
data class Raspored (
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "natjecanje")
    val natjecanje: String,

    @ColumnInfo(name = "datum")
    val datum: String,

    @ColumnInfo(name = "domacin")
    val domacin: String,

    @ColumnInfo(name = "gost")
    val gost: String,

    @ColumnInfo(name = "vrijeme")
    val vrijeme: String,
        )