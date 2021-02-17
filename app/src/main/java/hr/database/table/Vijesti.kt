package hr.database.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vijesti")
data class Vijesti (

    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "naslov")
    val naslov: String,

    @ColumnInfo(name = "slika")
    val slika: Int

        )