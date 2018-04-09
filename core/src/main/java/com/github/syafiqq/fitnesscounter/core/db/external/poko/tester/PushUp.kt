package com.github.syafiqq.fitnesscounter.core.db.external.poko.tester

import com.google.firebase.database.PropertyName
import java.io.Serializable

/**
 * This fitness-counter project created by :
 * Name         : syafiq
 * Date / Time  : 07 March 2018, 12:16 AM.
 * Email        : id.muhammad.syafiq@gmail.com
 * Github       : Syafiqq
 */
data class PushUp(
        // @formatter:off
        @get:PropertyName("start")        @set:PropertyName("start")        var start: Long? = null,
        @get:PropertyName("counter")      @set:PropertyName("counter")      var counter: Long? = null
        // @formatter:on
): Serializable
{
    fun set(pushUp: PushUp)
    {
        this.start = pushUp.start
        this.counter = pushUp.counter
    }

    companion object {
        val EMPTY_DATA = PushUp()
    }
}