package gnscinternational.ivvyn.digital.data.database.converter

import androidx.room.TypeConverter
import gnscinternational.ivvyn.digital.data.model.Difficulty
import java.time.LocalDateTime

class Converters {

    @TypeConverter
    fun stringToLocalDateTime(value: String?): LocalDateTime? {
        return value?.let { LocalDateTime.parse(it) }
    }

    @TypeConverter
    fun localDateTimeToString(localDateTime: LocalDateTime?): String? {
        return localDateTime?.toString()
    }

    @TypeConverter
    fun stringToDifficulty(value: String): Difficulty {
        return Difficulty.valueOf(value)
    }

    @TypeConverter
    fun difficultyToString(difficulty: Difficulty): String {
        return difficulty.name
    }
}
