package hr.database.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "igraci")
data class Igraci (
        @PrimaryKey(autoGenerate = true)
        val id: Int,

        @ColumnInfo(name = "ime")
        val ime: String,

        @ColumnInfo(name = "prezime")
        val prezime: String,

        @ColumnInfo(name = "broj")
        val broj: Int,

        @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
        val slika: ByteArray? = null
        )