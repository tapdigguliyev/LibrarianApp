package com.raywenderlich.android.librarian.database.dao

import androidx.room.*
import com.raywenderlich.android.librarian.model.ReadingList
import kotlinx.coroutines.flow.Flow


@Dao
interface ReadingListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addReadingList(readingList: ReadingList)

    @Query("SELECT * FROM readingList")
    suspend fun getReadingLists(): List<ReadingList>

    @Query("SELECT * FROM readingList")
    fun getReadingListsFlow(): Flow<List<ReadingList>>

    @Query("SELECT * FROM readingList WHERE id = :readingListId")
    suspend fun getReadingListById(readingListId: String): ReadingList

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateReadingList(readingList: ReadingList)

    @Delete
    suspend fun removeReadingList(readingList: ReadingList)
}