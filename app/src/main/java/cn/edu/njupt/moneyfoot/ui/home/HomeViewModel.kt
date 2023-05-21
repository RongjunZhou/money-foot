package cn.edu.njupt.moneyfoot.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cn.edu.njupt.moneyfoot.dao.BillDao
import cn.edu.njupt.moneyfoot.entity.Bill
import cn.edu.njupt.moneyfoot.repo.BillRepository

class HomeViewModel : ViewModel() {

    private lateinit var billDao : BillDao
    private val _text = MutableLiveData<String>().apply {
        value = "This is home Page"
    }
    val text : LiveData<String> = _text

    val bill : LiveData<List<Bill>> = BillRepository.getAll()



}