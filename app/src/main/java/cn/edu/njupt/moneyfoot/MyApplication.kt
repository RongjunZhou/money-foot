package cn.edu.njupt.moneyfoot

import android.app.Application
import cn.edu.njupt.moneyfoot.repo.BillRepository

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        BillRepository.getDatabase(applicationContext).billDao().getAll()
    }
}