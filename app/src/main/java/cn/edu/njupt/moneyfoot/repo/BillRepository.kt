package cn.edu.njupt.moneyfoot.repo

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import cn.edu.njupt.moneyfoot.database.BillDatabase
import cn.edu.njupt.moneyfoot.entity.Bill
import java.util.Date

/**
 * 为了好调用一点，拿单例写了
 * 有性能损失，不建议大数量查询使用
 */
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
    suspend fun insert(bill: Bill) {
        instance!!.billDao().insertBill(bill)
    }
    fun getBillsByDateAndAccess(startDate: Date, endStart: Date, access: String?): LiveData<List<Bill>>{
        if(access == null){
            return instance!!.billDao().getBillsByTime(startDate.time, endStart.time)
        }
        return instance!!.billDao().getBillsByTimeAndAccess(startDate.time, endStart.time, access)
    }
    suspend fun deleteBill(id: Int){
        val bill = Bill(id, "", "", "", 0, null)
        instance!!.billDao().deleteBill(bill)
    }


}