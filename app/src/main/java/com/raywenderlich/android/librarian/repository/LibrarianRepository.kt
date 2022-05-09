package com.raywenderlich.android.librarian.repository

import com.raywenderlich.android.librarian.model.Book
import com.raywenderlich.android.librarian.model.Genre
import com.raywenderlich.android.librarian.model.ReadingList
import com.raywenderlich.android.librarian.model.Review
import com.raywenderlich.android.librarian.model.relations.BookAndGenre
import com.raywenderlich.android.librarian.model.relations.BookReview
import com.raywenderlich.android.librarian.model.relations.ReadingListsWithBooks
import kotlinx.coroutines.flow.Flow

interface LibrarianRepository {

    suspend fun getBooks(): List<BookAndGenre>

    suspend fun getBookById(bookId: String): BookAndGenre

    suspend fun addBook(book: Book)

    suspend fun removeBook(book: Book)

    suspend fun getGenres(): List<Genre>

    suspend fun getGenreById(genreId: String): Genre

    suspend fun getBooksByGenre(genreId: String): List<BookAndGenre>

    suspend fun addGenres(genres: List<Genre>)

    suspend fun addReadingList(readingList: ReadingList)

    suspend fun getReadingLists(): List<ReadingListsWithBooks>

    fun getReadingListsFlow(): Flow<List<ReadingListsWithBooks>>

    suspend fun getReadingListById(readingListId: String): ReadingListsWithBooks

    suspend fun updateReadingList(readingList: ReadingList)

    suspend fun removeReadingList(readingList: ReadingList)

    suspend fun addReview(review: Review)

    suspend fun updateReview(review: Review)

    suspend fun getReviews(): List<BookReview>

    fun getReviewsFlow(): Flow<List<BookReview>>

    suspend fun getReviewById(reviewId: String): BookReview

    suspend fun removeReview(review: Review)

    suspend fun getBooksByRating(rating: Int): List<BookAndGenre>
}