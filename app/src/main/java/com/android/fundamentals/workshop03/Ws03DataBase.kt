package com.android.fundamentals.workshop03

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Ws03LocationEntity::class], version = 1)
abstract class Ws03DataBase : RoomDatabase() {

    abstract val locationsDao: Ws03LocationsDao

    companion object {
        fun create(application: Context): Ws03DataBase =
            Room.databaseBuilder(
                application,
                Ws03DataBase::class.java,
                Ws03DbContract.DATABASE_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
    }
}