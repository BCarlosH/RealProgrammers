package com.example.carlos.realprogrammersnew.platform.views

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.carlos.realprogrammersnew.presentation.ProgrammerItemView
import kotlinx.android.synthetic.main.view_programmer_item.view.*

class ProgrammerListViewHolder(itemView: View, private val itemClick: (String) -> Unit) :
    RecyclerView.ViewHolder(itemView),
    ProgrammerItemView {


    override fun onItemClickListener(id: String) {
        itemView.setOnClickListener { itemClick(id) }
    }

    override fun displayName(name: String) {
        itemView.item_programmer_name_text_view.text = name
    }

    override fun displayDate(date: String) {
        itemView.item_programmer_date_text_view.text = date
    }

    override fun displayFavourite(isFavourite: Boolean) {
        itemView.item_programmer_favorite_toggle_button.visibility = if (isFavourite) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

}