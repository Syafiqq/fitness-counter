package com.github.syafiqq.fitnesscounter.core.helpers

import com.github.syafiqq.fitnesscounter.core.custom.com.google.firebase.database.DatabaseReference
import com.github.syafiqq.fitnesscounter.core.db.external.DataMapper
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import timber.log.Timber
import com.google.firebase.database.DatabaseReference as BaseDatabaseReference

/**
 * This fitness-counter project created by :
 * Name         : syafiq
 * Date / Time  : 07 January 2018, 12:19 PM.
 * Email        : id.muhammad.syafiq@gmail.com
 * Github       : Syafiqq
 */
object AuthHelper
{
    //@formatter:off
    fun grantTo(user: FirebaseUser, role: String, callback: BaseDatabaseReference.CompletionListener = object :DatabaseReference.CompletionListener{})
    { //@formatter:on
        Timber.d("grantTo [$user, $role, $callback]")

        val dbRef = FirebaseDatabase.getInstance().getReference("/")
        val query = HashMap<String, Any>()
        for ((key, value) in DataMapper.userRole(user.uid, role))
        {
            when (key)
            { // @formatter:off
                "users" -> {query[value] = true}
                "users_groups" -> {query[value] = true}
            }// @formatter:on
        }

        dbRef.updateChildren(query, callback)
    }

    //@formatter:off
    fun checkAuthorities(user: FirebaseUser, role: String, listener: AuthorizationListener = object:AuthorizationListener{})
    { //@formatter:on
        Timber.d("checkAuthorities [$user, $role, $listener]")

        val path = DataMapper.userRole(user.uid, role)["users"]
        val dbRef = FirebaseDatabase.getInstance().getReference("/$path")
        dbRef.addListenerForSingleValueEvent(object: ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot?)
            {
                if ((snapshot?.exists()!!) && (snapshot.value as Boolean))
                {
                    listener.onAuthorized(snapshot)
                    listener.onCompleted()
                }
                else
                {
                    listener.onUnauthorized()
                    listener.onCompleted()
                }
            }

            override fun onCancelled(error: DatabaseError?)
            {
                listener.onCancelled(error)
                listener.onCompleted()
            }
        })

    }

    interface AuthorizationListener
    {
        //@formatter:off
        fun onAuthorized(snapshot:DataSnapshot) { Timber.d("Authorized [$snapshot")}
        fun onUnauthorized() { Timber.d("Unauthorized") }
        fun onCancelled (error: DatabaseError?) { Timber.d("Cancelled [$error]") }
        fun onCompleted () { Timber.d("Completed") }
        //@formatter:on
    }
}