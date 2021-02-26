package hr.database.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "novi_rezultati")
data class TablicaRezultati (

    @PrimaryKey(autoGenerate = true)
    val novi_id: Int,

    @ColumnInfo(name = "novi_broj_kola")
    val novi_brojKola: String,

    @ColumnInfo(name = "novi_prva_utakmica_datum")
    val novi_prvaUtakmicaDatum: String,
    @ColumnInfo(name = "novi_prva_utakmica_domacin")
    val novi_prvaUtakmicaDomacin: String,
    @ColumnInfo(name = "novi_prva_utakmica_gost")
    val novi_prvaUtakmicaGost: String,
    @ColumnInfo(name = "novi_prva_utakmica_rezultat")
    val novi_prvaUtakmicaRezultat: String,


    @ColumnInfo(name = "novi_druga_utakmica_datum")
    val novi_drugaUtakmicaDatum: String,
    @ColumnInfo(name = "novi_druga_utakmica_domacin")
    val novi_drugaUtakmicaDomacin: String,
    @ColumnInfo(name = "novi_druga_utakmica_gost")
    val novi_drugaUtakmicaGost: String,
    @ColumnInfo(name = "novi_druga_utakmica_rezultat")
    val novi_drugaUtakmicaRezultat: String,


    @ColumnInfo(name = "novi_treca_utakmica_datum")
    val novi_trecaUtakmicaDatum: String,
    @ColumnInfo(name = "novi_treca_utakmica_domacin")
    val novi_trecaUtakmicaDomacin: String,
    @ColumnInfo(name = "novi_treca_utakmica_gost")
    val novi_trecaUtakmicaGost: String,
    @ColumnInfo(name = "novi_treca_utakmica_rezultat")
    val novi_trecaUtakmicaRezultat: String,


    @ColumnInfo(name = "novi_cetvrta_utakmica_datum")
    val novi_cetvrtaUtakmicaDatum: String,
    @ColumnInfo(name = "novi_cetvrta_utakmica_domacin")
    val novi_cetvrtaUtakmicaDomacin: String,
    @ColumnInfo(name = "novi_cetvrta_utakmica_gost")
    val novi_cetvrtaUtakmicaGost: String,
    @ColumnInfo(name = "novi_cetvrta_utakmica_rezultat")
    val novi_cetvrtaUtakmicaRezultat: String,


    @ColumnInfo(name = "novi_peta_utakmica_datum")
    val novi_petaUtakmicaDatum: String,
    @ColumnInfo(name = "novi_peta_utakmica_domacin")
    val novi_petaUtakmicaDomacin: String,
    @ColumnInfo(name = "novi_peta_utakmica_gost")
    val novi_petaUtakmicaGost: String,
    @ColumnInfo(name = "novi_peta_utakmica_rezultat")
    val novi_petaUtakmicaRezultat: String,


    @ColumnInfo(name = "novi_sesta_utakmica_datum")
    val novi_sestaUtakmicaDatum: String,
    @ColumnInfo(name = "novi_sesta_utakmica_domacin")
    val novi_sestaUtakmicaDomacin: String,
    @ColumnInfo(name = "novi_sesta_utakmica_gost")
    val novi_sestaUtakmicaGost: String,
    @ColumnInfo(name = "novi_sesta_utakmica_rezultat")
    val novi_sestaUtakmicaRezultat: String,


    @ColumnInfo(name = "novi_sedma_utakmica_datum")
    val novi_sedmaUtakmicaDatum: String,
    @ColumnInfo(name = "novi_sedma_utakmica_domacin")
    val novi_sedmaUtakmicaDomacin: String,
    @ColumnInfo(name = "novi_sedma_utakmica_gost")
    val novi_sedmaUtakmicaGost: String,
    @ColumnInfo(name = "novi_sedma_utakmica_rezultat")
    val novi_sedmaUtakmicaRezultat: String

        )