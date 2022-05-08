package com.raywenderlich.android.librarian.database.dao

import androidx.room.*
import com.raywenderlich.android.librarian.model.Review
import com.raywenderlich.android.librarian.model.relations.BookReview


@Dao
interface ReviewDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addReview(review: Review)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateReview(review: Review)

    @Query("SELECT * FROM review")
    suspend fun getReviews(): List<BookReview>

    @Query("SELECT * FROM review WHERE id = :reviewId")
    suspend fun getReviewById(reviewId: String): BookReview

    @Delete
    suspend fun removeReview(review: Review)

    @Query("SELECT * FROM review WHERE rating >= :rating")
    suspend fun getReviewsByRating(rating: Int): List<BookReview>
}