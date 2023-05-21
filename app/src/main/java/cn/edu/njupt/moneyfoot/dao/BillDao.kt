package cn.edu.njupt.moneyfoot.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import cn.edu.njupt.moneyfoot.entity.Bill

@Dao
interface BillDao {
    @Query("SELECT * FROM bill")
    fun getAll() : LiveData<List<Bill>>
    @Insert
    fun insertBill(vararg bills : Bill)
}