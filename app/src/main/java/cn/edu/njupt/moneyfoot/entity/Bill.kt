package cn.edu.njupt.moneyfoot.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity
data class Bill (
    @PrimaryKey val id : Int,
    @ColumnInfo(name = "amount") val amount : Int,
    @ColumnInfo(name = "tag") val tag : Int,
    @ColumnInfo(name = "date") val date : LocalDate,
    @ColumnInfo(name = "comment") val comment : String?
)