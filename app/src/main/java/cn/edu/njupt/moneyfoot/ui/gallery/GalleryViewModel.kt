package cn.edu.njupt.moneyfoot.ui.gallery

import androidx.lifecycle.ViewModel
import cn.edu.njupt.moneyfoot.repo.BillRepository
import java.sql.Date
import java.time.LocalDate
import java.util.Calendar

class GalleryViewModel : ViewModel() {

    private val calendar: Calendar = Calendar.getInstance()


    val all = BillRepository.getBillsByDateAndAccess(
        Date.valueOf(LocalDate.now().withDayOfMonth(1).toString()),
        Date.valueOf(LocalDate.now().withDayOfMonth(1).plusMonths(1).toString()),
        null )


}