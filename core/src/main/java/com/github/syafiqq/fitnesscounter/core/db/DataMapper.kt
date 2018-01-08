package com.github.syafiqq.fitnesscounter.core.db

import com.google.firebase.auth.FirebaseUser

/**
 * This fitness-counter project created by :
 * Name         : syafiq
 * Date / Time  : 07 January 2018, 1:31 PM.
 * Email        : id.muhammad.syafiq@gmail.com
 * Github       : Syafiqq
 */

object DataMapper
{
    fun userRole(user: FirebaseUser, role: String): Array<String>
    {
        return arrayOf(
                "${Path.USERS}/${user.uid}/roles/${role}",
                "${Path.USERS_GROUPS}/${user.uid}/${role}"
        )
    }
}