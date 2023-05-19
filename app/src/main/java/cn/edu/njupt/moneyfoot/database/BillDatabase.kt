package cn.edu.njupt.moneyfoot.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cn.edu.njupt.moneyfoot.dao.BillDao
import cn.edu.njupt.moneyfoot.entity.Bill

@Database(entities = [Bill::class], version = 1)
abstract class BillDatabase : RoomDatabase(){
    abstract fun billDao() : BillDao

    companion object {
        private const val DB_NAME = "money-foot.db"

        @Volatile
        private var INSTANCE: BillDatabase? = null

        fun getDatabase(context: Context): BillDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BillDatabase::class.java, "bill"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}