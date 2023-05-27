package cn.edu.njupt.moneyfoot.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cn.edu.njupt.moneyfoot.entity.Bill
import cn.edu.njupt.moneyfoot.repo.BillRepository
import kotlinx.coroutines.launch
import java.sql.Date
import java.time.LocalDate

class HomeViewModel : ViewModel() {

    private lateinit var _bill: LiveData<List<Bill>>
    init {
        viewModelScope.launch {
            _bill = BillRepository.getBillsByDateAndAccess(
                Date.valueOf(LocalDate.now().withDayOfMonth(1).toString()),
                Date.valueOf(LocalDate.now().withDayOfMonth(1).plusMonths(1).toString()),
                null)
        }
    }

    val bill = _bill

}