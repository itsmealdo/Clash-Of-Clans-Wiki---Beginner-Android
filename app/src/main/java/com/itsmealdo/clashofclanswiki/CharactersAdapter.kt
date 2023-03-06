package com.itsmealdo.clashofclanswiki

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itsmealdo.clashofclanswiki.databinding.CharacterListBinding

    class CharactersAdapter(private val listCharacters: ArrayList<Characters>) :
    RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {
        private lateinit var onItemClickCallback: OnItemClickCallback

        fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
            this.onItemClickCallback = onItemClickCallback
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding =
                CharacterListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val (nameCharacter, descCharacter, photoCharacter) = listCharacters[position]
            holder.binding.tvCharacterTitle.text = nameCharacter
            holder.binding.tvCharacterDesc.text = descCharacter
            holder.binding.ivCharacterLogo.setImageResource(photoCharacter)
            holder.itemView.setOnClickListener {
                onItemClickCallback.onItemClicked(listCharacters[holder.adapterPosition])
            }
        }

        override fun getItemCount(): Int = listCharacters.size

        class ViewHolder(var binding: CharacterListBinding) : RecyclerView.ViewHolder(binding.root)

        interface OnItemClickCallback {
            fun onItemClicked(data: Characters)
        }
    }
