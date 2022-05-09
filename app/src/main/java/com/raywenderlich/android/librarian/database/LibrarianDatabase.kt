package com.raywenderlich.android.librarian.database

import android.content.Context
import androidx.room.*
import androidx.room.RoomDatabase
import com.raywenderlich.android.librarian.database.converters.DateConverter
import com.raywenderlich.android.librarian.database.dao.BookDao
import com.raywenderlich.android.librarian.database.dao.GenreDao
import com.raywenderlich.android.librarian.database.dao.ReadingListDao
import com.raywenderlich.android.librarian.database.dao.ReviewDao
import com.raywenderlich.android.librarian.database.migrations.migration_1_2
import com.raywenderlich.android.librarian.model.Book
import com.raywenderlich.android.librarian.model.Genre
import com.raywenderlich.android.librarian.model.ReadingList
import com.raywenderlich.android.librarian.model.Review

const val DATABASE_VERSION = 2

@Database(
    entities = [Book::class, Genre::class, ReadingList::class, Review::class],
    version = DATABASE_VERSION
)

@TypeConverters(DateConverter::class)
abstract class LibrarianDatabase : RoomDatabase() {

    companion object{
        private const val DATABASE_NAME = "Librarian"

        fun buildDatabase(context: Context): LibrarianDatabase {
            return Room.databaseBuilder(
                context,
                LibrarianDatabase::class.java,
                DATABASE_NAME
            )
                .addMigrations(migration_1_2)
                .build()
        }
    }

    abstract fun bookDao(): BookDao

    abstract fun genreDao(): GenreDao

    abstract fun readingListDao(): ReadingListDao

    abstract fun reviewDao(): ReviewDao
}