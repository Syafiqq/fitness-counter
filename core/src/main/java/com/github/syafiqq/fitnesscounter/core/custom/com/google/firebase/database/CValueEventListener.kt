package com.github.syafiqq.fitnesscounter.core.custom.com.google.firebase.database

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import timber.log.Timber

/**
 * This fitness-counter project created by :
 * Name         : syafiq
 * Date / Time  : 24 February 2018, 10:18 AM.
 * Email        : id.muhammad.syafiq@gmail.com
 * Github       : Syafiqq
 */
interface CValueEventListener: ValueEventListener
{
    override fun onCancelled(error: DatabaseError?)
    {
        Timber.d("onCancelled [$error]")
    }

    override fun onDataChange(snapshot: DataSnapshot?)
    {
        Timber.d("onDataChange [$snapshot]")
    }
}