package cn.edu.njupt.moneyfoot.entity

import java.math.BigDecimal

data class BillDO(
    var id: Int,
    val amount: BigDecimal,
    val tag: Boolean,
    val access: String,
    val time: String,
    val comment: String?
)
