package com.raywenderlich.android.librarian.repository

import com.raywenderlich.android.librarian.model.Book
import com.raywenderlich.android.librarian.model.Genre
import com.raywenderlich.android.librarian.model.ReadingList
import com.raywenderlich.android.librarian.model.Review
import com.raywenderlich.android.librarian.model.relations.BookAndGenre
import com.raywenderlich.android.librarian.model.relations.BookReview
import com.raywenderlich.android.librarian.model.relations.ReadingListsWithBooks

interface LibrarianRepository {

    suspend fun getBooks(): List<BookAndGenre>

    suspend fun getBookById(bookId: String): Book

    suspend fun addBook(book: Book)

    suspend fun removeBook(book: Book)

    fun getGenres(): List<Genre>

    fun getGenreById(genreId: String): Genre

    fun getBooksByGenre(genreId: String): List<BookAndGenre>

    fun addGenres(genres: List<Genre>)

    fun addReadingList(readingList: ReadingList)

    fun getReadingLists(): List<ReadingListsWithBooks>

    fun removeReadingList(readingList: ReadingList)

    fun addReview(review: Review)

    fun updateReview(review: Review)

    fun getReviews(): List<BookReview>

    fun getReviewById(reviewId: String): BookReview

    fun removeReview(review: Review)

    fun getBooksByRating(rating: Int): List<BookAndGenre>
}