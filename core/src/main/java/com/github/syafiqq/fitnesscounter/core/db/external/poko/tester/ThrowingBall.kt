package com.github.syafiqq.fitnesscounter.core.db.external.poko.tester

import com.google.firebase.database.PropertyName
import java.io.Serializable

/**
 * This fitness-counter project created by :
 * Name         : syafiq
 * Date / Time  : 06 March 2018, 12:27 AM.
 * Email        : id.muhammad.syafiq@gmail.com
 * Github       : Syafiqq
 */
data class ThrowingBall(
        // @formatter:off
        @get:PropertyName("start")        @set:PropertyName("start")        var start: Long? = null,
        @get:PropertyName("counter")      @set:PropertyName("counter")      var counter: Long? = null
        // @formatter:on
): Serializable
{
    fun set(throwing: ThrowingBall)
    {
        this.start = throwing.start
        this.counter = throwing.counter
    }

    companion object {
        val EMPTY_DATA = ThrowingBall()
    }
}