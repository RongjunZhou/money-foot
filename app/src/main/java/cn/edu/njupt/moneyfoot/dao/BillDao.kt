package cn.edu.njupt.moneyfoot.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import cn.edu.njupt.moneyfoot.entity.Bill

@Dao
interface BillDao {
    @Query("SELECT * FROM bill")
    fun getAll() : LiveData<List<Bill>>
    @Insert
    fun insertBill(vararg bills: Bill)
    @Delete
    suspend fun deleteBill(vararg bills: Bill)
    @Query("SELECT * FROM bill WHERE time >= :startTime AND time <= :endTime AND access = :access")
    fun getBillsByTimeAndAccess(startTime: Long, endTime: Long, access: String): LiveData<List<Bill>>
    @Query("SELECT * FROM bill WHERE time >= :startTime AND time <= :endTime ORDER BY time DESC")
    fun getBillsByTime(startTime: Long, endTime: Long): LiveData<List<Bill>>
}