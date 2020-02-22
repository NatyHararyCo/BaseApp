package com.nutworks.baseapp.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.nutworks.baseapp.R
import com.nutworks.baseapp.ui.fragment.BaseFragment
import com.nutworks.baseapp.ui.fragment.DashboardFragment
import com.nutworks.baseapp.ui.fragment.HomeFragment
import com.nutworks.baseapp.ui.fragment.NotificationsFragment
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : BaseActivity() {

    private lateinit var fragmentManager: FragmentManager
    private lateinit var dashboardFragment: DashboardFragment
    private lateinit var homeFragment: HomeFragment
    private lateinit var notificationsFragment: NotificationsFragment
    private lateinit var activeFragment: BaseFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        initFragments()
        setListeners()
    }

    private fun initFragments() {
        fragmentManager = supportFragmentManager
        dashboardFragment = DashboardFragment()
        homeFragment = HomeFragment()
        notificationsFragment = NotificationsFragment()

        fragmentManager.beginTransaction().add(R.id.frameLayout, dashboardFragment, "3")
            .hide(dashboardFragment).commit()
        fragmentManager.beginTransaction().add(R.id.frameLayout, notificationsFragment, "2")
            .hide(notificationsFragment).commit()
        fragmentManager.beginTransaction().add(R.id.frameLayout, homeFragment, "1").commit()

        activeFragment = homeFragment

    }

    private fun setListeners() {
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> return@setOnNavigationItemSelectedListener replaceFragment(
                    homeFragment
                )
                R.id.navigation_notifications -> return@setOnNavigationItemSelectedListener replaceFragment(
                    notificationsFragment
                )
                R.id.navigation_dashboard -> return@setOnNavigationItemSelectedListener replaceFragment(
                    dashboardFragment
                )
                else -> return@setOnNavigationItemSelectedListener false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment): Boolean {
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment).commit()
        return true
    }
}