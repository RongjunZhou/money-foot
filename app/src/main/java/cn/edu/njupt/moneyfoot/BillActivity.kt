package cn.edu.njupt.moneyfoot

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.SurfaceControl.Transaction
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import cn.edu.njupt.moneyfoot.databinding.ActivityBillBinding
import com.google.android.material.navigation.NavigationView

class BillActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBillBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
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