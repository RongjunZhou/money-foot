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
    private lateinit var _all1: LiveData<List<Bill>>
    private lateinit var _all2: LiveData<List<Bill>>
    private lateinit var _all3: LiveData<List<Bill>>
    private lateinit var _all4: LiveData<List<Bill>>
    private lateinit var _all5: LiveData<List<Bill>>
    private lateinit var _all6: LiveData<List<Bill>>
    private lateinit var _all7: LiveData<List<Bill>>
    private lateinit var _all8: LiveData<List<Bill>>
    private lateinit var _all9: LiveData<List<Bill>>
    private lateinit var _all10: LiveData<List<Bill>>
    private lateinit var _all11: LiveData<List<Bill>>
    private lateinit var _all12: LiveData<List<Bill>>

    init {
        viewModelScope.launch {
            _all = BillRepository.getBillsByDateAndAccess(
                Date.valueOf(LocalDate.now().withDayOfMonth(1).toString()),
                Date.valueOf(LocalDate.now().withDayOfMonth(1).plusMonths(1).toString()),
                null )
            _all1 = BillRepository.getBillsByDateAndAccess(
                Date.valueOf(LocalDate.now().withDayOfMonth(1).toString()),
                Date.valueOf(LocalDate.now().withDayOfMonth(1).plusMonths(1).toString()),
                "工资收入" )
            _all2 = BillRepository.getBillsByDateAndAccess(
                Date.valueOf(LocalDate.now().withDayOfMonth(1).toString()),
                Date.valueOf(LocalDate.now().withDayOfMonth(1).plusMonths(1).toString()),
                "奖励奖金" )
            _all3 = BillRepository.getBillsByDateAndAccess(
                Date.valueOf(LocalDate.now().withDayOfMonth(1).toString()),
                Date.valueOf(LocalDate.now().withDayOfMonth(1).plusMonths(1).toString()),
                "理财收入" )
            _all4 = BillRepository.getBillsByDateAndAccess(
                Date.valueOf(LocalDate.now().withDayOfMonth(1).toString()),
                Date.valueOf(LocalDate.now().withDayOfMonth(1).plusMonths(1).toString()),
                "闲置交易" )
            _all5 = BillRepository.getBillsByDateAndAccess(
                Date.valueOf(LocalDate.now().withDayOfMonth(1).toString()),
                Date.valueOf(LocalDate.now().withDayOfMonth(1).plusMonths(1).toString()),
                "其他收入" )
            _all6 = BillRepository.getBillsByDateAndAccess(
                Date.valueOf(LocalDate.now().withDayOfMonth(1).toString()),
                Date.valueOf(LocalDate.now().withDayOfMonth(1).plusMonths(1).toString()),
                "学习办公" )
            _all7 = BillRepository.getBillsByDateAndAccess(
                Date.valueOf(LocalDate.now().withDayOfMonth(1).toString()),
                Date.valueOf(LocalDate.now().withDayOfMonth(1).plusMonths(1).toString()),
                "生活服务" )
            _all8 = BillRepository.getBillsByDateAndAccess(
                Date.valueOf(LocalDate.now().withDayOfMonth(1).toString()),
                Date.valueOf(LocalDate.now().withDayOfMonth(1).plusMonths(1).toString()),
                "餐饮零食" )
            _all9 = BillRepository.getBillsByDateAndAccess(
                Date.valueOf(LocalDate.now().withDayOfMonth(1).toString()),
                Date.valueOf(LocalDate.now().withDayOfMonth(1).plusMonths(1).toString()),
                "交通出行" )
            _all10 = BillRepository.getBillsByDateAndAccess(
                Date.valueOf(LocalDate.now().withDayOfMonth(1).toString()),
                Date.valueOf(LocalDate.now().withDayOfMonth(1).plusMonths(1).toString()),
                "聚会活动" )
            _all11 = BillRepository.getBillsByDateAndAccess(
                Date.valueOf(LocalDate.now().withDayOfMonth(1).toString()),
                Date.valueOf(LocalDate.now().withDayOfMonth(1).plusMonths(1).toString()),
                "家电购置" )
            _all12 = BillRepository.getBillsByDateAndAccess(
                Date.valueOf(LocalDate.now().withDayOfMonth(1).toString()),
                Date.valueOf(LocalDate.now().withDayOfMonth(1).plusMonths(1).toString()),
                "其他支出" )
        }
    }

    val all = _all
    val all1 = _all1
    val all2 = _all2
    val all3 = _all3
    val all4 = _all4
    val all5 = _all5
    val all6 = _all6
    val all7 = _all7
    val all8 = _all8
    val all9 = _all9
    val all10 = _all10
    val all11 = _all11
    val all12 = _all12

}