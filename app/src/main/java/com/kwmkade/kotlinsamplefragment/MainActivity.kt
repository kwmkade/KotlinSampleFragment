package com.kwmkade.kotlinsamplefragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun replaceFragment(bCard: Boolean) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.mainFragmentContainerView, if (bCard) CardFragment() else ItemFragment())
            .setReorderingAllowed(true)
            .addToBackStack("name")
            .commit()
    }
}