package com.github.syafiqq.fitnesscounter.core.custom.com.google.firebase.database

import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import timber.log.Timber

/**
 * This fitness-counter project created by :
 * Name         : syafiq
 * Date / Time  : 24 February 2018, 10:05 AM.
 * Email        : id.muhammad.syafiq@gmail.com
 * Github       : Syafiqq
 */
interface CChildEventListener: ChildEventListener
{
    override fun onCancelled(error: DatabaseError?)
    {
        Timber.d("onCancelled [$error]")
    }

    override fun onChildMoved(snapshot: DataSnapshot?, previousChildName: String?)
    {
        Timber.d("onChildMoved [$snapshot, $previousChildName]")
    }

    override fun onChildChanged(snapshot: DataSnapshot?, previousChildName: String?)
    {
        Timber.d("onChildChanged [$snapshot, $previousChildName]")
    }

    override fun onChildAdded(snapshot: DataSnapshot?, previousChildName: String?)
    {
        Timber.d("onChildAdded [$snapshot, $previousChildName]")
    }

    override fun onChildRemoved(snapshot: DataSnapshot?)
    {
        Timber.d("onChildRemoved [$snapshot]")
    }
}