package cn.edu.njupt.moneyfoot.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cn.edu.njupt.moneyfoot.entity.Bill
import cn.edu.njupt.moneyfoot.repo.BillRepository
import kotlinx.coroutines.launch
import java.sql.Date
import java.time.LocalDate

class GalleryViewModel : ViewModel() {

    private lateinit var _all: LiveData<List<Bill>>
    private lateinit var _all_1: LiveData<List<Bill>>
    private lateinit var _all_2: LiveData<List<Bill>>
    private lateinit var _all_3: LiveData<List<Bill>>
    private lateinit var _all_4: LiveData<List<Bill>>
    private lateinit var _all_5: LiveData<List<Bill>>
    private lateinit var _all_6: LiveData<List<Bill>>
    private lateinit var _all_7: LiveData<List<Bill>>
    private lateinit var _all_8: LiveData<List<Bill>>
    private lateinit var _all_9: LiveData<List<Bill>>
    private lateinit var _all_10: LiveData<List<Bill>>
    private lateinit var _all_11: LiveData<List<Bill>>
    private lateinit var _all_12: LiveData<List<Bill>>

    init {
        viewModelScope.launch {
            _all = BillRepository.getBillsByDateAndAccess(
                Date.valueOf(LocalDate.now().withDayOfMonth(1).toString()),
                Date.valueOf(LocalDate.now().withDayOfMonth(1).plusMonths(1).toString()),
                null )
            _all_1 = BillRepository.getBillsByDateAndAccess(
                Date.valueOf(LocalDate.now().withDayOfMonth(1).toString()),
                Date.valueOf(LocalDate.now().withDayOfMonth(1).plusMonths(1).toString()),
                "工资收入" )
            _all_2 = BillRepository.getBillsByDateAndAccess(
                Date.valueOf(LocalDate.now().withDayOfMonth(1).toString()),
                Date.valueOf(LocalDate.now().withDayOfMonth(1).plusMonths(1).toString()),
                "奖励奖金" )
            _all_3 = BillRepository.getBillsByDateAndAccess(
                Date.valueOf(LocalDate.now().withDayOfMonth(1).toString()),
                Date.valueOf(LocalDate.now().withDayOfMonth(1).plusMonths(1).toString()),
                "理财收入" )
            _all_4 = BillRepository.getBillsByDateAndAccess(
                Date.valueOf(LocalDate.now().withDayOfMonth(1).toString()),
                Date.valueOf(LocalDate.now().withDayOfMonth(1).plusMonths(1).toString()),
                "闲置交易" )
            _all_5 = BillRepository.getBillsByDateAndAccess(
                Date.valueOf(LocalDate.now().withDayOfMonth(1).toString()),
                Date.valueOf(LocalDate.now().withDayOfMonth(1).plusMonths(1).toString()),
                "其他收入" )
            _all_6 = BillRepository.getBillsByDateAndAccess(
                Date.valueOf(LocalDate.now().withDayOfMonth(1).toString()),
                Date.valueOf(LocalDate.now().withDayOfMonth(1).plusMonths(1).toString()),
                "学习办公" )
            _all_7 = BillRepository.getBillsByDateAndAccess(
                Date.valueOf(LocalDate.now().withDayOfMonth(1).toString()),
                Date.valueOf(LocalDate.now().withDayOfMonth(1).plusMonths(1).toString()),
                "生活服务" )
            _all_8 = BillRepository.getBillsByDateAndAccess(
                Date.valueOf(LocalDate.now().withDayOfMonth(1).toString()),
                Date.valueOf(LocalDate.now().withDayOfMonth(1).plusMonths(1).toString()),
                "餐饮零食" )
            _all_9 = BillRepository.getBillsByDateAndAccess(
                Date.valueOf(LocalDate.now().withDayOfMonth(1).toString()),
                Date.valueOf(LocalDate.now().withDayOfMonth(1).plusMonths(1).toString()),
                "交通出行" )
            _all_10 = BillRepository.getBillsByDateAndAccess(
                Date.valueOf(LocalDate.now().withDayOfMonth(1).toString()),
                Date.valueOf(LocalDate.now().withDayOfMonth(1).plusMonths(1).toString()),
                "聚会活动" )
            _all_11 = BillRepository.getBillsByDateAndAccess(
                Date.valueOf(LocalDate.now().withDayOfMonth(1).toString()),
                Date.valueOf(LocalDate.now().withDayOfMonth(1).plusMonths(1).toString()),
                "家电购置" )
            _all_12 = BillRepository.getBillsByDateAndAccess(
                Date.valueOf(LocalDate.now().withDayOfMonth(1).toString()),
                Date.valueOf(LocalDate.now().withDayOfMonth(1).plusMonths(1).toString()),
                "其他支出" )
        }
    }

    val all = _all
    val all_1 = _all_1
    val all_2 = _all_2
    val all_3 = _all_3
    val all_4 = _all_4
    val all_5 = _all_5
    val all_6 = _all_6
    val all_7 = _all_7
    val all_8 = _all_8
    val all_9 = _all_9
    val all_10 = _all_10
    val all_11 = _all_11
    val all_12 = _all_12

}