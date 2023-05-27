package cn.edu.njupt.moneyfoot.ui.home

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import cn.edu.njupt.moneyfoot.R
import cn.edu.njupt.moneyfoot.entity.BillDO
import cn.edu.njupt.moneyfoot.repo.BillRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewAdapter(context: Context, bills: List<BillDO>) :
    ArrayAdapter<BillDO>(context, 0, bills) {

    val susScope = CoroutineScope(Dispatchers.Default)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        }

        val bill = getItem(position)

        view?.findViewById<TextView>(R.id.textView_amount)?.text = bill?.amount.toString()
        if(bill?.tag == true){
            view?.findViewById<TextView>(R.id.textView_amount)?.setTextColor(Color.GREEN)
        }else{
            view?.findViewById<TextView>(R.id.textView_amount)?.setTextColor(Color.RED)
        }
        view?.findViewById<TextView>(R.id.textView_time)?.text = bill?.time
        view?.findViewById<TextView>(R.id.textView_comment)?.text = bill?.comment
        view?.findViewById<TextView>(R.id.textView_access)?.text = bill?.access

        view?.findViewById<Button>(R.id.deleteButton)?.setOnClickListener{
            if (bill != null) {
                susScope.launch { BillRepository.deleteBill(bill.id) }
            }
        }

        return view!!


    }
}
