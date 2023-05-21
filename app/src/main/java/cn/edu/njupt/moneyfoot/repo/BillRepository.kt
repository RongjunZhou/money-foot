package cn.edu.njupt.moneyfoot.repo

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import cn.edu.njupt.moneyfoot.database.BillDatabase
import cn.edu.njupt.moneyfoot.entity.Bill

object BillRepository {
    private var instance: BillDatabase? = null

    @Synchronized
    fun getDatabase(context: Context): BillDatabase {
        instance?.let {
            return it
        }
        return Room.databaseBuilder(
            context.applicationContext,
            BillDatabase::class.java, "app_database"
        ).build().apply { instance = this }
    }

    fun getAll() : LiveData<List<Bill>> = instance!!.billDao().getAll()
    //fun getAll(date : Date) : LiveData<List<Bill>> = instance!!.billDao().getAllOfMonth(date)




}