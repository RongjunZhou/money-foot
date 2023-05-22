package cn.edu.njupt.moneyfoot

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import cn.edu.njupt.moneyfoot.databinding.ActivityBillBinding

class BillActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBillBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBillBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarBill.toolbar)

        binding.appBarBill.fab.setOnClickListener{
            onBackPressed()
            finish()
        }

        binding.appBarBill.toolbar.setNavigationOnClickListener{
            onBackPressed()
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