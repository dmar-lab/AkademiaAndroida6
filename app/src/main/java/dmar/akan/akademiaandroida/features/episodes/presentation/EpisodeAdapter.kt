package dmar.akan.akademiaandroida.features.episodes.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dmar.akan.akademiaandroida.R
import dmar.akan.akademiaandroida.TextItemViewHolder
import dmar.akan.akademiaandroida.features.episodes.presentation.model.EpisodeDisplayable

//first one string per item
class EpisodeAdapter : RecyclerView.Adapter<TextItemViewHolder>() {

    //temporary solution
    var data = listOf<EpisodeDisplayable>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val item = data[position]
        holder.textView.text = item.name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.episode_item_view, parent, false) as TextView
        return TextItemViewHolder(view)
    }
}
