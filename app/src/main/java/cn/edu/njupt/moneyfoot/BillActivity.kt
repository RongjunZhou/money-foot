package cn.edu.njupt.moneyfoot

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cn.edu.njupt.moneyfoot.databinding.ActivityBillBinding
import cn.edu.njupt.moneyfoot.entity.Bill
import cn.edu.njupt.moneyfoot.repo.BillRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.ZoneId

class BillActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBillBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val scope = CoroutineScope(Dispatchers.Default)


        binding = ActivityBillBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarBill.toolbar)

        binding.appBarBill.fab.setOnClickListener{
            val amount = binding.appBarBill.content.decimal.text.toString()
            if(amount.isEmpty()){
                Toast.makeText(this ,"金额不能为空",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            scope.launch {
                val type = binding.appBarBill.content.typeSpinner.selectedItem.toString()
                val access = binding.appBarBill.content.accessSpinner.selectedItem.toString()
                val comment = binding.appBarBill.content.comment.text.toString()
                val timePicker = binding.appBarBill.content.editTextTime
                val time = LocalDate.now().atTime(timePicker.hour, timePicker.minute)
                    .atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
                val bill = Bill(null, amount, type, access, time, comment)
                BillRepository.getDatabase(applicationContext).billDao().insertBill(bill)
            }
            onBackPressed()
            finish()
        }

        binding.appBarBill.toolbar.setNavigationOnClickListener{
            onBackPressed()
            finish()
        }

        val typeSpinner = binding.appBarBill.content.typeSpinner
        val accessSpinner = binding.appBarBill.content.accessSpinner

        typeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (parent.getItemAtPosition(position).toString()) {
                    "收入" -> {
                        accessSpinner.adapter =
                            ArrayAdapter(this@BillActivity,
                                android.R.layout.simple_spinner_dropdown_item,
                                resources.getStringArray(R.array.tags_in))
                    }
                    "支出" -> {
                        accessSpinner.adapter =
                            ArrayAdapter(this@BillActivity,
                                android.R.layout.simple_spinner_dropdown_item,
                                resources.getStringArray(R.array.tags_out))
                    }
                    else -> {
                        accessSpinner.adapter =
                            ArrayAdapter<String>(this@BillActivity,
                                android.R.layout.simple_spinner_dropdown_item,
                                emptyArray())
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                accessSpinner.adapter =
                    ArrayAdapter<String>(this@BillActivity,
                        android.R.layout.simple_spinner_dropdown_item,
                        emptyArray())
            }

        }

    }


}