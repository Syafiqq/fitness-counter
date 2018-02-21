package com.github.syafiqq.fitnesscounter.core.db.external

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
    fun userRole(uid: String? = null, role: String? = null): Map<String, String>
    {
        Timber.d("userRole [$uid, $role]")

        val uid = if (uid == null) "" else "/$uid"
        val role = if (role == null) "" else "/$role"

        return mapOf<String, String>(
                "users" to "${Path.USERS}$uid/roles$role",
                "users_groups" to "${Path.USERS_GROUPS}$role$uid"
        )
    }
}