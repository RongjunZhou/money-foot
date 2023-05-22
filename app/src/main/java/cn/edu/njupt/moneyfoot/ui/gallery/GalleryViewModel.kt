package cn.edu.njupt.moneyfoot.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cn.edu.njupt.moneyfoot.repo.BillRepository
import java.util.Calendar
import java.util.Date

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
    }
    val text: LiveData<String> = _text

    private val calendar: Calendar = Calendar.getInstance()

    val all = BillRepository.getBillsByDateAndAccess(
        Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)+1,0),
        Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)+1,0),
        null )


}