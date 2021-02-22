package hr.database.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tablica_raspored")
data class TablicaRaspored (

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "broj_kola")
    val brojKola: Int,

    @ColumnInfo(name = "prva_utakmica_datum")
    val prvaUtakmicaDatum: String,
    @ColumnInfo(name = "prva_utakmica_domacin")
    val prvaUtakmicaDomacin: String,
    @ColumnInfo(name = "prva_utakmica_gost")
    val prvaUtakmicaGost: String,
    @ColumnInfo(name = "prva_utakmica_vrijeme")
    val prvaUtakmicaVrijeme: String,


    @ColumnInfo(name = "druga_utakmica_datum")
    val drugaUtakmicaDatum: String,
    @ColumnInfo(name = "druga_utakmica_domacin")
    val drugaUtakmicaDomacin: String,
    @ColumnInfo(name = "druga_utakmica_gost")
    val drugaUtakmicaGost: String,
    @ColumnInfo(name = "druga_utakmica_vrijeme")
    val drugaUtakmicaVrijeme: String,


    @ColumnInfo(name = "treca_utakmica_datum")
    val trecaUtakmicaDatum: String,
    @ColumnInfo(name = "treca_utakmica_domacin")
    val trecaUtakmicaDomacin: String,
    @ColumnInfo(name = "treca_utakmica_gost")
    val trecaUtakmicaGost: String,
    @ColumnInfo(name = "treca_utakmica_vrijeme")
    val trecaUtakmicaVrijeme: String,


    @ColumnInfo(name = "cetvrta_utakmica_datum")
    val cetvrtaUtakmicaDatum: String,
    @ColumnInfo(name = "cetvrta_utakmica_domacin")
    val cetvrtaUtakmicaDomacin: String,
    @ColumnInfo(name = "cetvrta_utakmica_gost")
    val cetvrtaUtakmicaGost: String,
    @ColumnInfo(name = "cetvrta_utakmica_vrijeme")
    val cetvrtaUtakmicaVrijeme: String,


    @ColumnInfo(name = "peta_utakmica_datum")
    val petaUtakmicaDatum: String,
    @ColumnInfo(name = "peta_utakmica_domacin")
    val petaUtakmicaDomacin: String,
    @ColumnInfo(name = "peta_utakmica_gost")
    val petaUtakmicaGost: String,
    @ColumnInfo(name = "peta_utakmica_vrijeme")
    val petaUtakmicaVrijeme: String,


    @ColumnInfo(name = "sesta_utakmica_datum")
    val sestaUtakmicaDatum: String,
    @ColumnInfo(name = "sesta_utakmica_domacin")
    val sestaUtakmicaDomacin: String,
    @ColumnInfo(name = "sesta_utakmica_gost")
    val sestaUtakmicaGost: String,
    @ColumnInfo(name = "sesta_utakmica_vrijeme")
    val sestaUtakmicaVrijeme: String,


    @ColumnInfo(name = "sedma_utakmica_datum")
    val sedmaUtakmicaDatum: String,
    @ColumnInfo(name = "sedma_utakmica_domacin")
    val sedmaUtakmicaDomacin: String,
    @ColumnInfo(name = "sedma_utakmica_gost")
    val sedmaUtakmicaGost: String,
    @ColumnInfo(name = "sedma_utakmica_vrijeme")
    val sedmaUtakmicaVrijeme: String
        )