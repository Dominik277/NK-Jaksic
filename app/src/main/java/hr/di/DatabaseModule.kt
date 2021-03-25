package hr.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import hr.database.NKJaksicDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        NKJaksicDatabase::class.java,
    "nk_jaksic_baza"
    ).fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideRasporedDao(nkJaksicDatabase: NKJaksicDatabase) = nkJaksicDatabase.rasporedDao()

    @Provides
    @Singleton
    fun provideRezultatiDao(nkJaksicDatabase: NKJaksicDatabase) = nkJaksicDatabase.rezultatiDao()

    @Provides
    @Singleton
    fun provideVijestiDao(nkJaksicDatabase: NKJaksicDatabase) = nkJaksicDatabase.vijestiDao()

}