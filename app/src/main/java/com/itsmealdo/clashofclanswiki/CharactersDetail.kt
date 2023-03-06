package com.itsmealdo.clashofclanswiki

import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.itsmealdo.clashofclanswiki.databinding.ActivityDetailBinding

class CharactersDetail : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var characters: Characters

    companion object {
        const val EXTRA_CHARACTER = "extra_character"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        characters = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_CHARACTER, Characters::class.java)!!
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_CHARACTER)!!
        }

        if(characters != null) {
            binding.ivCharacterLogo.load(characters.photoCharacter)
            binding.tvCharacterTitle.text = characters.nameCharacter
            binding.tvCharacterDesc.text = characters.descCharacter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.share_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_share -> {
                Toast.makeText(this, "Share ${characters.nameCharacter}, yuk :)", Toast.LENGTH_SHORT).show();
            }
        }
        return super.onOptionsItemSelected(item)
    }
}