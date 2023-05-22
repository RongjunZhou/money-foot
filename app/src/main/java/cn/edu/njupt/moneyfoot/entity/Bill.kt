package cn.edu.njupt.moneyfoot.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Bill (
    @PrimaryKey(autoGenerate = true) var id : Int?,
    @ColumnInfo(name = "amount") val amount : String,
    @ColumnInfo(name = "tag") val tag : String,
    @ColumnInfo(name = "access") val access : String,
    @ColumnInfo(name = "time") val time : Long,
    @ColumnInfo(name = "comment") val comment : String?
)