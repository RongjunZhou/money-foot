package cn.edu.njupt.moneyfoot.ui.gallery

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import cn.edu.njupt.moneyfoot.adapter.BillDOAdapter
import cn.edu.njupt.moneyfoot.databinding.FragmentGalleryBinding
import java.math.BigDecimal

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    private val binding get() = _binding!!

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this)[GalleryViewModel::class.java]

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        galleryViewModel.all.observe(viewLifecycleOwner) {
            var income = BigDecimal(0)
            var outcome = BigDecimal(0)
            it.stream().map { o -> BillDOAdapter.bill2BillDO(o) }.forEach{ o -> run{
                when(o.tag){
                    true -> income = income.add(o.amount)
                    else -> outcome = outcome.add(o.amount)
                }
            }}
            if(income.add(outcome).equals(0)){
                binding.progressBar.progress = 100
            }else{
                binding.progressBar.progress = (income.toDouble()/(outcome.toDouble() + income.toDouble()) * 100).toInt()
                if (income.toDouble() > outcome.toDouble()){
                    binding.amount.setTextColor(Color.BLUE)
                }else if(income.toDouble() > outcome.toDouble()){
                    binding.amount.setTextColor(Color.RED)
                }
            }

            binding.amount.text = income.toEngineeringString() + "/" + outcome.toEngineeringString()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}