package com.wzm.sample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * <pre>
 *   @author : wenzhiming
 *   @time   : 2022/02/20
 *   @desc   : SideBar List Demo
 * </pre>
 */
class SampleAdapter(private val textList: MutableList<String>) : RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder = let {
        var root = LayoutInflater.from(parent.context).inflate(R.layout.item_text, parent, false)
        ItemViewHolder(root)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBindText(textList[position])
    }

    override fun getItemCount(): Int = let {
        textList.size
    }

}

/**
 * Text ItemViewHolder
 * @constructor
 */
class ItemViewHolder(root: View) : RecyclerView.ViewHolder(root) {

    fun onBindText(text: String) {
        itemView.findViewById<TextView>(R.id.tv_text).text = text
    }
}