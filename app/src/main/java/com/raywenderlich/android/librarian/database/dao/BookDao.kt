package com.raywenderlich.android.librarian.database.dao

import androidx.room.*
import com.raywenderlich.android.librarian.model.Book
import com.raywenderlich.android.librarian.model.relations.BookAndGenre


@Dao
interface BookDao {

    @Query("SELECT * FROM books")
    fun getBooks(): List<BookAndGenre>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addBook(book: Book)

    @Delete
    fun removeBook(book: Book)

    @Query("SELECT * FROM books WHERE id = :bookId")
    fun getBookById(bookId: String): Book
}