package com.example.soptseminar1weeks

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
import com.example.soptseminar1weeks.HomeFragment

class MainPagerAdapter(fm:FragmentManager):
   FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
        override fun getItem(position:Int): Fragment{
            return when(position){
                0-> HomeFragment()
                1-> BookFragment()
                else -> MyPageFragment()
            }
        }

    override fun getCount() =3
}