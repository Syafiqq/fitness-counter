package com.github.syafiqq.fitnesscounter.core.db.external.poko.tester

import com.google.firebase.database.PropertyName
import java.io.Serializable

/**
 * This fitness-counter project created by :
 * Name         : syafiq
 * Date / Time  : 10 March 2018, 10:20 AM.
 * Email        : id.muhammad.syafiq@gmail.com
 * Github       : Syafiqq
 */
data class Run1600m(
        // @formatter:off
        @get:PropertyName("start")        @set:PropertyName("start")        var start: Long? = null,
        @get:PropertyName("lap1")         @set:PropertyName("lap1")         var lap1: Long? = null,
        @get:PropertyName("lap2")         @set:PropertyName("lap2")         var lap2: Long? = null,
        @get:PropertyName("lap3")         @set:PropertyName("lap3")         var lap3: Long? = null,
        @get:PropertyName("end")          @set:PropertyName("end")          var end: Long? = null,
        @get:PropertyName("elapsed")      @set:PropertyName("elapsed")      var elapsed: Long? = null
        // @formatter:on
): Serializable
{
    fun set(run: Run1600m)
    {
        this.start = run.start
        this.lap1 = run.lap1
        this.lap2 = run.lap2
        this.lap3 = run.lap3
        this.end = run.end
        this.elapsed = run.elapsed
    }

    companion object {
        val EMPTY_DATA = Run1600m()
    }
}