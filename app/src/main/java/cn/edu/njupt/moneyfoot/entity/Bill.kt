package cn.edu.njupt.moneyfoot.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Bill (
    @PrimaryKey var id : Int,
    @ColumnInfo(name = "amount") val amount : Int,
    @ColumnInfo(name = "tag") val tag : Int,
    @ColumnInfo(name = "date") val date : Long,
    @ColumnInfo(name = "comment") val comment : String?
)