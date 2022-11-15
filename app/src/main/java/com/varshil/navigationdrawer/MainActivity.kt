package com.varshil.navigationdrawer

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.varshil.navigationdrawer.Fragment.Adapter.AdapterTabPager
import com.varshil.navigationdrawer.Fragment.CallFragment
import com.varshil.navigationdrawer.Fragment.HomeFragment
import com.varshil.navigationdrawer.Fragment.StatusFragment

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var view_Pager: ViewPager2
    lateinit var tabs: TabLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        var navView: NavigationView = findViewById(R.id.nav_view)
        var view_Pager: ViewPager2 = findViewById(R.id.viewPager2)
        var tabs: TabLayout = findViewById(R.id.tabs)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.nav_home -> Toast.makeText(
                    applicationContext,
                    "Clicked Home",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_message -> Toast.makeText(
                    applicationContext,
                    "Clicked Message",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_sync -> Toast.makeText(
                    applicationContext,
                    "Clicked Sync",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_trash -> Toast.makeText(
                    applicationContext,
                    "Clicked Trash",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_setting -> Toast.makeText(
                    applicationContext,
                    "Clicked Setting",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_login -> Toast.makeText(
                    applicationContext,
                    "Clicked Login",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_share -> Toast.makeText(
                    applicationContext,
                    "Clicked Share",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_rate -> Toast.makeText(
                    applicationContext,
                    "Clicked Rate Us",
                    Toast.LENGTH_SHORT
                ).show()
            }
            true
        }

        val adapter = AdapterTabPager(this)

        adapter.addFragment(HomeFragment(), "Home")
        adapter.addFragment(StatusFragment(), "Status")
        adapter.addFragment(CallFragment(), "Call")

        view_Pager.adapter = adapter

        TabLayoutMediator(tabs, view_Pager) { tab, position ->
        }.attach()

        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_home_24)
        tabs.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_status)
        tabs.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_call_24)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}