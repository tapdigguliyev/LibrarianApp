package com.raywenderlich.android.librarian.database.dao

import androidx.room.*
import com.raywenderlich.android.librarian.model.ReadingList


@Dao
interface ReadingListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addReadingList(readingList: ReadingList)

    @Query("SELECT * FROM readingList")
    suspend fun getReadingLists(): List<ReadingList>

    @Delete
    suspend fun removeReadingList(readingList: ReadingList)
}