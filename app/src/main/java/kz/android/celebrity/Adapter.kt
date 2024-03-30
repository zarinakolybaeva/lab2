package kz.android.celebrity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kz.android.celebrity.databinding.ItemCelebrityBinding

class Adapter : ListAdapter<Celebrity, Adapter.CelebrityViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CelebrityViewHolder {
        return CelebrityViewHolder(
            ItemCelebrityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CelebrityViewHolder, position: Int) {
        val celebrity = getItem(position)
        holder.bind(celebrity)
    }

    class CelebrityViewHolder(private val binding: ItemCelebrityBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(celebrity: Celebrity) {
            binding.tvName.text = celebrity.name
            binding.tvNetWorth.text = "Net Worth: \$${celebrity.net_worth}"
            binding.tvGender.text = "Gender: ${celebrity.gender}"
            binding.tvNationality.text = "Nationality: ${celebrity.nationality}"
            binding.tvOccupation.text = "Occupation: ${celebrity.occupation?.joinToString(", ")}"
            binding.tvHeight.text = "Height: ${celebrity.height}m"
            binding.tvBirthday.text = "Birthday: ${celebrity.birthday}"
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Celebrity>() {
            override fun areItemsTheSame(oldItem: Celebrity, newItem: Celebrity): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Celebrity, newItem: Celebrity): Boolean {
                return oldItem == newItem
            }
        }
    }
}