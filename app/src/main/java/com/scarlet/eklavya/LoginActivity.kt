package com.scarlet.eklavya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {

    private lateinit var fbBtn : Button
    private lateinit var googleBtn : Button
    private lateinit var emailBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
    }

    private fun initView(){
        fbBtn = findViewById(R.id.facebookBtn)
        googleBtn = findViewById(R.id.googleBtn)
        emailBtn = findViewById(R.id.emailBtn)

        fbBtn.setOnClickListener { movetoOnboard() }
        googleBtn.setOnClickListener { movetoOnboard() }
        emailBtn.setOnClickListener { movetoOnboard() }

    }

    private fun movetoOnboard(){
        startActivity(Intent(this,OnboardingActivity::class.java))
    }

}