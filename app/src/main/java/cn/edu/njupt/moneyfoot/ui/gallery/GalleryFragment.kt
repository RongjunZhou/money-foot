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
                }else if(income.toDouble() < outcome.toDouble()){
                    binding.amount.setTextColor(Color.RED)
                }else{
                    binding.amount.setTextColor(Color.BLACK)
                }
            }

            var textSize = 36
            val amountText = income.toEngineeringString() + "/" + outcome.toEngineeringString()
            while(binding.amount.paint.measureText(amountText) > 190 && textSize > 0){
                textSize -= 1
                binding.amount.paint.textSize = textSize.toFloat()
            }

            binding.amount.textSize = textSize.toFloat()
            binding.amount.text = amountText
        }

        galleryViewModel.all_1.observe(viewLifecycleOwner){
            var amount = BigDecimal(0)
            it.stream().map { o -> BillDOAdapter.bill2BillDO(o) }.forEach{ o -> amount = amount.add(o.amount) }
            binding.amount1.text = "￥" + amount.toPlainString()
            binding.amount1.setTextColor(Color.GREEN)
        }
        galleryViewModel.all_2.observe(viewLifecycleOwner){
            var amount = BigDecimal(0)
            it.stream().map { o -> BillDOAdapter.bill2BillDO(o) }.forEach{ o -> amount = amount.add(o.amount) }
            binding.amount2.text = "￥" + amount.toPlainString()
            binding.amount2.setTextColor(Color.GREEN)
        }
        galleryViewModel.all_3.observe(viewLifecycleOwner){
            var amount = BigDecimal(0)
            it.stream().map { o -> BillDOAdapter.bill2BillDO(o) }.forEach{ o -> amount = amount.add(o.amount) }
            binding.amount3.text = "￥" + amount.toPlainString()
            binding.amount3.setTextColor(Color.GREEN)
        }
        galleryViewModel.all_4.observe(viewLifecycleOwner){
            var amount = BigDecimal(0)
            it.stream().map { o -> BillDOAdapter.bill2BillDO(o) }.forEach{ o -> amount = amount.add(o.amount) }
            binding.amount4.text = "￥" + amount.toPlainString()
            binding.amount4.setTextColor(Color.GREEN)
        }
        galleryViewModel.all_5.observe(viewLifecycleOwner){
            var amount = BigDecimal(0)
            it.stream().map { o -> BillDOAdapter.bill2BillDO(o) }.forEach{ o -> amount = amount.add(o.amount) }
            binding.amount5.text = "￥" + amount.toPlainString()
            binding.amount5.setTextColor(Color.GREEN)
        }
        galleryViewModel.all_6.observe(viewLifecycleOwner){
            var amount = BigDecimal(0)
            it.stream().map { o -> BillDOAdapter.bill2BillDO(o) }.forEach{ o -> amount = amount.add(o.amount) }
            binding.amount6.text = "￥" + amount.toPlainString()
            binding.amount6.setTextColor(Color.RED)
        }
        galleryViewModel.all_7.observe(viewLifecycleOwner){
            var amount = BigDecimal(0)
            it.stream().map { o -> BillDOAdapter.bill2BillDO(o) }.forEach{ o -> amount = amount.add(o.amount) }
            binding.amount7.text = "￥" + amount.toPlainString()
            binding.amount7.setTextColor(Color.RED)
        }
        galleryViewModel.all_8.observe(viewLifecycleOwner){
            var amount = BigDecimal(0)
            it.stream().map { o -> BillDOAdapter.bill2BillDO(o) }.forEach{ o -> amount = amount.add(o.amount) }
            binding.amount8.text = "￥" + amount.toPlainString()
            binding.amount8.setTextColor(Color.RED)
        }
        galleryViewModel.all_9.observe(viewLifecycleOwner){
            var amount = BigDecimal(0)
            it.stream().map { o -> BillDOAdapter.bill2BillDO(o) }.forEach{ o -> amount = amount.add(o.amount) }
            binding.amount9.text = "￥" + amount.toPlainString()
            binding.amount9.setTextColor(Color.RED)
        }
        galleryViewModel.all_10.observe(viewLifecycleOwner){
            var amount = BigDecimal(0)
            it.stream().map { o -> BillDOAdapter.bill2BillDO(o) }.forEach{ o -> amount = amount.add(o.amount) }
            binding.amount10.text = "￥" + amount.toPlainString()
            binding.amount10.setTextColor(Color.RED)
        }
        galleryViewModel.all_11.observe(viewLifecycleOwner){
            var amount = BigDecimal(0)
            it.stream().map { o -> BillDOAdapter.bill2BillDO(o) }.forEach{ o -> amount = amount.add(o.amount) }
            binding.amount11.text = "￥" + amount.toPlainString()
            binding.amount11.setTextColor(Color.RED)
        }
        galleryViewModel.all_12.observe(viewLifecycleOwner){
            var amount = BigDecimal(0)
            it.stream().map { o -> BillDOAdapter.bill2BillDO(o) }.forEach{ o -> amount = amount.add(o.amount) }
            binding.amount12.text = "￥" + amount.toPlainString()
            binding.amount12.setTextColor(Color.RED)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}