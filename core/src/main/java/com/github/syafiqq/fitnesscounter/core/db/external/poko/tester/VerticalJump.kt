package com.github.syafiqq.fitnesscounter.core.db.external.poko.tester

import com.google.firebase.database.PropertyName
import java.io.Serializable

/**
 * This fitness-counter project created by :
 * Name         : syafiq
 * Date / Time  : 04 March 2018, 9:25 PM.
 * Email        : id.muhammad.syafiq@gmail.com
 * Github       : Syafiqq
 */
data class VerticalJump(
        // @formatter:off
        @get:PropertyName("initial")        @set:PropertyName("initial")        var initial: Float? = null,
        @get:PropertyName("try1")           @set:PropertyName("try1")           var try1: Float? = null,
        @get:PropertyName("try2")           @set:PropertyName("try2")           var try2: Float? = null,
        @get:PropertyName("try3")           @set:PropertyName("try3")           var try3: Float? = null,
        @get:PropertyName("deviation")      @set:PropertyName("deviation")      var deviation: Float? = null
        // @formatter:on
): Serializable
{
    fun set(vertical: VerticalJump)
    {
        this.initial = vertical.initial
        this.try1 = vertical.try1
        this.try2 = vertical.try2
        this.try3 = vertical.try3
        this.deviation = vertical.deviation
    }
}