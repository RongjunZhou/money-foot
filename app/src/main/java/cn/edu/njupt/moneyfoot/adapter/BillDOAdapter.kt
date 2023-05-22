package cn.edu.njupt.moneyfoot.adapter

import android.annotation.SuppressLint
import cn.edu.njupt.moneyfoot.entity.Bill
import cn.edu.njupt.moneyfoot.entity.BillDO
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.Date

object BillDOAdapter {

    @SuppressLint("SimpleDateFormat")
    fun bill2BillDO(bill: Bill): BillDO{
        val amount: BigDecimal = bill.amount.toBigDecimal()
        val tag: Boolean = when(bill.tag){
            "收入"->{
                true
            }
            "支出"->{
                false
            }
            else->{
                false
            }
        }
        val date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date(bill.time))
        return BillDO(bill.id!!, amount, tag, bill.access, date, bill.comment)
    }

}