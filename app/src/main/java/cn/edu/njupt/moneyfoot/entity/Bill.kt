package cn.edu.njupt.moneyfoot.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Bill (
    @PrimaryKey val id : Int,
    @ColumnInfo(name = "amount") val amount : Int,
    @ColumnInfo(name = "tag") val tag : Int,
    @ColumnInfo(name = "date") val date : String,
    @ColumnInfo(name = "comment") val comment : String?
)