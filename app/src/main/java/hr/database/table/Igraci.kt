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

        @ColumnInfo(name = "broj")
        val broj: Int,

        @ColumnInfo(name = "slika")
        val slika: Int
): Parcelable