package cn.edu.njupt.moneyfoot.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cn.edu.njupt.moneyfoot.entity.Bill
import cn.edu.njupt.moneyfoot.repo.BillRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private lateinit var _bill: LiveData<List<Bill>>
    init {
        viewModelScope.launch {
            _bill = BillRepository.getAll()
        }
    }

    val bill = _bill

}