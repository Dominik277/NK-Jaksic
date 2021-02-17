package hr.database.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "raspored")
data class Raspored (
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "datum")
    val datum: String,

    @ColumnInfo(name = "ogled")
    val ogled: String
        )