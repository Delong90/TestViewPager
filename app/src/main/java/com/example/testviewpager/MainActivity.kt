package com.example.testviewpager

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.testviewpager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//создание простого ViewPager

        val tableLayout = binding.tabLayout
        val viewPager: ViewPager = binding.viewPager

        viewPager.adapter = ViewPagerAdapter(supportFragmentManager)
        tableLayout.setupWithViewPager(viewPager)
//добавляем обработчик событий (номер текущей страницы, текущее значение позиции скрола или пролистывания, состояние в котором находится скроллер(ничего, тащит, долистывает)

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }
            @SuppressLint("ShowToast")
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int,
            ) {
//                var toast = Toast.makeText(this@MainActivity, "$position", Toast.LENGTH_SHORT)
//                toast.setGravity(Gravity.TOP,0,0)
//                toast.show()
            }

            override fun onPageSelected(position: Int) {
                Toast.makeText(this@MainActivity, "$position ${viewPager.currentItem}", Toast.LENGTH_SHORT).show()
            }




        })

    }

    inner class ViewPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm){

        override fun getCount(): Int {
            return 3
        }

        override fun getItem(position: Int): Fragment {
            return when(position){
                0->FirstFragment()
                1->SecondFragment()
                else->ThirdFragment()
            }
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return when(position){
                0->"One"
                1->"Two"
                else->"Three"
            }
        }

    }
}