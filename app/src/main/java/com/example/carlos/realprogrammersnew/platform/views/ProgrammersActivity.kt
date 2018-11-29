package com.example.carlos.realprogrammersnew.platform.views

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.carlos.realprogrammersnew.R
import com.example.carlos.realprogrammersnew.helpers.Cancelable
import com.example.carlos.realprogrammersnew.helpers.Confirmable

class ProgrammersActivity : AppCompatActivity(), Confirmable {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(ProgrammersListFragment())

    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().add(R.id.main_container, fragment).commit()
    }

    override fun onBackPressed() {
        val currentFragment = getCurrentFragment(R.id.main_container)
        if (currentFragment != null && currentFragment is Cancelable) {
            currentFragment.onCancel()
        } else {
            super.onBackPressed()
        }
    }

    override fun confirm() {
        super.onBackPressed()
    }

    private fun getCurrentFragment(layoutContainerId: Int): Fragment? =
        supportFragmentManager.findFragmentById(layoutContainerId)

}
