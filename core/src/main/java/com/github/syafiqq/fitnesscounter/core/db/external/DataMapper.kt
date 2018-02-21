package com.github.syafiqq.fitnesscounter.core.db.external

import com.google.firebase.auth.FirebaseUser
import timber.log.Timber

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
        Timber.d("userRole [$user, $role]")

        return arrayOf(
                "${Path.USERS}/${user.uid}/roles/$role",
                "${Path.USERS_GROUPS}/${user.uid}/$role"
        )
    }
}