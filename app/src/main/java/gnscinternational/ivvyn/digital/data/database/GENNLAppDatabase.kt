package gnscinternational.ivvyn.digital.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import gnscinternational.ivvyn.digital.data.database.converter.Converters
import gnscinternational.ivvyn.digital.data.database.dao.HighScoreDao
import gnscinternational.ivvyn.digital.data.entity.HighScore

@Database(
    entities = [HighScore::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class GENNLAppDatabase : RoomDatabase() {

    abstract fun highScoreDao(): HighScoreDao
}
