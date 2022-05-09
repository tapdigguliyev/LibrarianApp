package com.raywenderlich.android.librarian.database.converters

import androidx.room.TypeConverter
import java.util.*

class DateConverter {

    @TypeConverter
    fun fromTimeStamp(value: Long?): Date? {
        return Date(value ?: 0)
    }

    @TypeConverter
    fun dateToTimeStamp(date: Date?): Long? = date?.time ?: 0
}