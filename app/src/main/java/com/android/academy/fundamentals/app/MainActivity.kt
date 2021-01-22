package com.android.academy.fundamentals.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.academy.fundamentals.app.workshop02.solution.Ws02Fragment
import com.android.academy.fundamentals.app.workshop03.WS03Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, Ws02Fragment.create())
                .commit()
        }
    }
}
