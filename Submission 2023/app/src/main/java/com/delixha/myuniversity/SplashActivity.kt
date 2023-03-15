package com.delixha.myuniversity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.delixha.myuniversity.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.SplashScreenImage.alpha = 0f
        binding.SplashScreenImage.animate().setDuration(2000).alpha(1f).withEndAction {
            val mainActivityIntent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(mainActivityIntent)
            finish()
        }
    }
}