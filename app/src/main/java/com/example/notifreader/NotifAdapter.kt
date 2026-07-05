package com.example.notifreader

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotifAdapter(private var items: List<NotifItem>) :
    RecyclerView.Adapter<NotifAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvApp: TextView = view.findViewById(R.id.tvApp)
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvText: TextView = view.findViewById(R.id.tvText)
        val tvTime: TextView = view.findViewById(R.id.tvTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_notification, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.tvApp.text = item.appName
        holder.tvTitle.text = item.title
        holder.tvText.text = item.text
        holder.tvTime.text = item.time
    }

    override fun getItemCount(): Int = items.size

    fun updateData(newItems: List<NotifItem>) {
        items = newItems
        notifyDataSetChanged()
    }
}
