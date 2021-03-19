package hr.database.table

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
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

    @ColumnInfo(name = "nedostaju")
    val nedostaju: String,

    @ColumnInfo(name = "clanak")
    val clanak: String
        ): Parcelable