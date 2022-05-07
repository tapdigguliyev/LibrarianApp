package com.raywenderlich.android.librarian.librarian

import android.content.Context
import androidx.room.*
import androidx.room.RoomDatabase
import com.raywenderlich.android.librarian.model.Book
import com.raywenderlich.android.librarian.model.Genre

const val DATABASE_VERSION = 1

@Database(
    entities = [Book::class, Genre::class],
    version = DATABASE_VERSION
)

abstract class LibrarianDatabase : RoomDatabase() {

    companion object{
        private const val DATABASE_NAME = "Librarian"

        fun buildDatabase(context: Context): LibrarianDatabase {
            return Room.databaseBuilder(
                context,
                LibrarianDatabase::class.java,
                DATABASE_NAME
            )
                .allowMainThreadQueries()
                .build()
        }
    }
}