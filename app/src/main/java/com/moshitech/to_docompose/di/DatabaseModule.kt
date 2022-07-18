package com.moshitech.to_docompose.di

import android.content.Context
import androidx.room.Room
import com.moshitech.to_docompose.data.database.DatabaseConnection
import com.moshitech.to_docompose.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    )= Room.databaseBuilder(context,DatabaseConnection::class.java,DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideDao(database: DatabaseConnection) = database.todoDao()
}