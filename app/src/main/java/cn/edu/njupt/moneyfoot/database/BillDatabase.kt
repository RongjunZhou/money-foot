package cn.edu.njupt.moneyfoot.database

import androidx.room.Database
import androidx.room.RoomDatabase
import cn.edu.njupt.moneyfoot.dao.BillDao
import cn.edu.njupt.moneyfoot.entity.Bill

@Database(entities = [Bill::class], version = 1)
abstract class BillDatabase : RoomDatabase(){
    abstract fun billDao() : BillDao

}