package com.raywenderlich.android.librarian.repository

import com.raywenderlich.android.librarian.database.dao.BookDao
import com.raywenderlich.android.librarian.database.dao.GenreDao
import com.raywenderlich.android.librarian.database.dao.ReadingListDao
import com.raywenderlich.android.librarian.database.dao.ReviewDao
import com.raywenderlich.android.librarian.model.Book
import com.raywenderlich.android.librarian.model.Genre
import com.raywenderlich.android.librarian.model.ReadingList
import com.raywenderlich.android.librarian.model.Review
import com.raywenderlich.android.librarian.model.relations.BookAndGenre
import com.raywenderlich.android.librarian.model.relations.BookReview
import com.raywenderlich.android.librarian.model.relations.ReadingListsWithBooks

class LibrarianRepositoryImpl(
    private val bookDao: BookDao,
    private val genreDao: GenreDao,
    private val readingListDao: ReadingListDao,
    private val reviewDao: ReviewDao
) : LibrarianRepository {
    override fun getBooks(): List<BookAndGenre> = bookDao.getBooks()

    override fun getBookById(bookId: String): Book = bookDao.getBookById(bookId)

    override fun addBook(book: Book) = bookDao.addBook(book)

    override fun removeBook(book: Book) = bookDao.removeBook(book)

    override fun getGenres(): List<Genre> = genreDao.getGenres()

    override fun getGenreById(genreId: String): Genre = genreDao.getGenreById(genreId)

    override fun addGenres(genres: List<Genre>) = genreDao.addGenres(genres)

    override fun addReview(review: Review) = reviewDao.addReview(review)

    override fun updateReview(review: Review) = reviewDao.updateReview(review)

    override fun getReviews(): List<BookReview> = reviewDao.getReviews().map {
        BookReview(it, bookDao.getBookById(it.bookId))
    }

    override fun getReviewById(reviewId: String): BookReview {
        val review = reviewDao.getReviewById(reviewId)

        return BookReview(review, bookDao.getBookById(review.bookId))
    }

    override fun removeReview(review: Review) = reviewDao.removeReview(review)

    override fun addReadingList(readingList: ReadingList) = readingListDao.addReadingList(readingList)

    override fun getReadingLists(): List<ReadingListsWithBooks> =
        readingListDao.getReadingLists().map {
            ReadingListsWithBooks(it.id, it.name, emptyList())
        }

    override fun removeReadingList(readingList: ReadingList) = readingListDao.removeReadingList(readingList)
}