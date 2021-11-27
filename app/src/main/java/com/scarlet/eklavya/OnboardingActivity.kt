package com.scarlet.eklavya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class OnboardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container,OnboardingFragment())
            .commit()
    }

}