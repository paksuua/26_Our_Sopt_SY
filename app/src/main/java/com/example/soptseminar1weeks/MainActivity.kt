package com.example.soptseminar1weeks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.soptseminar1weeks.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vp_main.adapter=MainPagerAdapter(supportFragmentManager)
        vp_main.offscreenPageLimit=2
        vp_main.addOnAdapterChangeListener(object : ViewPager.OnPageChangeListener,
            ViewPager.OnAdapterChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                btnv_main.menu.getItem(position).isChecked=true
            }

            override fun onAdapterChanged(
                viewPager: ViewPager,
                oldAdapter: PagerAdapter?,
                newAdapter: PagerAdapter?
            ) {
                TODO("Not yet implemented")
            }
        })

        btnv_main.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home->vp_main.currentItem=0
                R.id.menu_book->vp_main.currentItem=1
                R.id.menu_mypage->vp_main.currentItem=2
            }
            true
        }
    }
}
