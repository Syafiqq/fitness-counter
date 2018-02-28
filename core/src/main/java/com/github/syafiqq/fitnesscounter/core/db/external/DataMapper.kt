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

        return mapOf(
                "users" to "${Path.USERS}$uid/roles$role",
                "users_groups" to "${Path.USERS_GROUPS}$role$uid"
        )
    }

    fun user(uid: String? = null): Map<String, String>
    {
        Timber.d("user [$uid]")

        val uid = if (uid == null) "" else "/$uid"

        return mapOf(
                "users" to "${Path.USERS}$uid"
        )
    }

    fun event(uid: String? = null, role: String? = null, id: String? = null): Map<String, String>
    {
        val uid = if (uid == null) "" else "/$uid"
        val role = if (role == null) "" else "/$role"
        val id = if (id == null) "" else "/$id"

        return mapOf(
                "events" to "${Path.EVENTS}$id",
                "users" to "${Path.USERS}$uid$role/${Path.EVENTS}$id"
        )
    }

    fun presetTester(preset: String? = null, queue: Int? = null, branch: String? = null): Map<String, String>
    {
        val preset = if (preset == null) "" else "/$preset"
        val queue = if (queue == null) "" else "/$queue"
        val branch = if (branch == null) "" else "/$branch"

        return mapOf(
                "presets" to "${Path.PRESETS}$preset/queues$queue$branch"
        )
    }
}