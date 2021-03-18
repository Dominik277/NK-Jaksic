package hr.database.table

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "vijesti")
data class Vijesti (

    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "naslov")
    val naslov: String,

    @ColumnInfo(name = "clanak")
    val clanak: String,

    @ColumnInfo(name = "vrijeme")
    val vrijeme: String,

    @ColumnInfo(name = "slika")
    val slika: Int
        ):Parcelable