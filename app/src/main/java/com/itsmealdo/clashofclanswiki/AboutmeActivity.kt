package com.itsmealdo.clashofclanswiki

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.itsmealdo.clashofclanswiki.databinding.ActivityAboutmeBinding

class AboutmeActivity : AppCompatActivity(){
    private lateinit var binding: ActivityAboutmeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutmeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivMe.load(getString(R.string.photo_me))
        binding.tvMeName.text = getString(R.string.name_me)
        binding.tvMeBngkt.text = getString(R.string.bngkt_me)
        binding.tvMeEmail.text = getString(R.string.email_me)

        supportActionBar?.title = "About Me - ${binding.tvMeName.text}"
    }
}