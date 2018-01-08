package com.github.syafiqq.fitnesscounter.core.custom.com.google.firebase.database

import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import timber.log.Timber

/**
 * This fitness-counter project created by :
 * Name         : syafiq
 * Date / Time  : 07 January 2018, 3:49 PM.
 * Email        : id.muhammad.syafiq@gmail.com
 * Github       : Syafiqq
 */
interface DefaultErrorValueEventListener: ValueEventListener
{
    override fun onCancelled(error: DatabaseError?)
    {
        Timber.d("onCancelled [${error}]")

        error?.let { Timber.d(it.message) }
    }
}