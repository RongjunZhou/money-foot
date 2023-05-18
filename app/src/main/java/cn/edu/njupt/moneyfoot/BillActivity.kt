package cn.edu.njupt.moneyfoot

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.edu.njupt.moneyfoot.databinding.ActivityBillBinding

class BillActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBillBinding

    override fun onCreate(savedInstanceState: Bundle?) : Unit {
        super.onCreate(savedInstanceState)

        binding = ActivityBillBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarBill.toolbar)

        binding.appBarBill.fab.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding.appBarBill.toolbar.setNavigationOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }

}