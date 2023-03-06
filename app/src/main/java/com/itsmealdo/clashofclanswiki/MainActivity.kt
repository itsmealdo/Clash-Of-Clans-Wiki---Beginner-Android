package com.itsmealdo.clashofclanswiki

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.itsmealdo.clashofclanswiki.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var list = ArrayList<Characters>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list.addAll(getCharactersList())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_action -> {
                startActivity(Intent(this@MainActivity, AboutmeActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getCharactersList(): ArrayList<Characters> {
        val characterTitleData = resources.getStringArray(R.array.characters_titleName)
        val characterDescData = resources.getStringArray(R.array.characters_Desc)
        val characterPhotoData = resources.obtainTypedArray(R.array.characters_Picture)

        val characterList = ArrayList<Characters>()
        for (i in characterTitleData.indices) {
            val character = Characters(
                nameCharacter = characterTitleData[i],
                descCharacter = characterDescData[i],
                photoCharacter = characterPhotoData.getResourceId(i, -1)
            )
            characterList.add(character)
        }
        characterPhotoData.recycle()
        return characterList
    }

    private fun showRecyclerList() {
        binding.rvCharacter.layoutManager = LinearLayoutManager(this)
        val charactersAdapter = CharactersAdapter(list)
        binding.rvCharacter.adapter = charactersAdapter

        charactersAdapter.setOnItemClickCallback(object : CharactersAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Characters) {
                showCharacter(data)
            }
        })
    }

    private fun showCharacter(characters: Characters) {
        val intent = Intent(this@MainActivity, CharactersDetail::class.java)
        intent.putExtra(CharactersDetail.EXTRA_CHARACTER,characters)
        startActivity(intent)
    }
}



