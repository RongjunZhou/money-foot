package cn.edu.njupt.moneyfoot.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import cn.edu.njupt.moneyfoot.entity.Bill

@Dao
interface BillDao {
    @Query("SELECT * FROM bill")
    fun getAll() : List<Bill>
    @Insert
    fun insertBill(vararg bills : Bill) : Int
}