package com.github.syafiqq.fitnesscounter.core.custom.com.google.firebase.database

import timber.log.Timber
import com.google.firebase.database.DatabaseError as BaseDatabaseError
import com.google.firebase.database.DatabaseReference as BaseDatabaseReference

/**
 * This fitness-counter project created by :
 * Name         : syafiq
 * Date / Time  : 08 January 2018, 8:44 PM.
 * Email        : id.muhammad.syafiq@gmail.com
 * Github       : Syafiqq
 */
class DatabaseReference
{
    interface CompletionListener: BaseDatabaseReference.CompletionListener
    {
        override fun onComplete(error: BaseDatabaseError?, ref: BaseDatabaseReference?) = Timber.d("onComplete [$error, $ref]")
    }
}