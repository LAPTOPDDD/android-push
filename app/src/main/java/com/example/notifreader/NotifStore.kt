package com.example.notifreader

import android.content.Context
import android.content.Intent
import androidx.localbroadcastmanager.content.LocalBroadcastManager

object NotifStore {
    const val ACTION_NEW_NOTIF = "com.example.notifreader.NEW_NOTIF"

    private val items = mutableListOf<NotifItem>()

    fun add(context: Context, item: NotifItem) {
        items.add(0, item)
        // ограничим память последними 200 уведомлениями
        if (items.size > 200) items.removeAt(items.size - 1)
        LocalBroadcastManager.getInstance(context).sendBroadcast(Intent(ACTION_NEW_NOTIF))
    }

    fun getAll(): List<NotifItem> = items.toList()
}
