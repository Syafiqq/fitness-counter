package com.github.syafiqq.fitnesscounter.core.db.external.poko.tester

import com.google.firebase.database.PropertyName
import java.io.Serializable

/**
 * This fitness-counter project created by :
 * Name         : syafiq
 * Date / Time  : 03 March 2018, 7:39 PM.
 * Email        : id.muhammad.syafiq@gmail.com
 * Github       : Syafiqq
 */
data class Illinois(
        // @formatter:off
        @get:PropertyName("start")        @set:PropertyName("start")        var start: Long? = null,
        @get:PropertyName("end")          @set:PropertyName("end")          var end: Long? = null,
        @get:PropertyName("elapsed")      @set:PropertyName("elapsed")      var elapsed: Long? = null
        // @formatter:on
): Serializable
{
    fun set(illinois: Illinois)
    {
        this.start = illinois.start
        this.end = illinois.end
        this.elapsed = illinois.elapsed
    }
}