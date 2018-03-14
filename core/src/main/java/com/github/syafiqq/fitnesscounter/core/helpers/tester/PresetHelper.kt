package com.github.syafiqq.fitnesscounter.core.helpers.tester

import com.github.syafiqq.fitnesscounter.core.custom.com.google.firebase.database.DatabaseReference
import com.github.syafiqq.fitnesscounter.core.db.external.DataMapper
import com.github.syafiqq.fitnesscounter.core.db.external.poko.tester.Illinois
import com.github.syafiqq.fitnesscounter.core.db.external.poko.tester.MedicalCheckup
import com.github.syafiqq.fitnesscounter.core.db.external.poko.tester.PushUp
import com.github.syafiqq.fitnesscounter.core.db.external.poko.tester.Run1600m
import com.github.syafiqq.fitnesscounter.core.db.external.poko.tester.SitUp
import com.github.syafiqq.fitnesscounter.core.db.external.poko.tester.ThrowingBall
import com.github.syafiqq.fitnesscounter.core.db.external.poko.tester.VerticalJump
import com.google.firebase.database.FirebaseDatabase
import timber.log.Timber
import com.google.firebase.database.DatabaseReference as BaseDatabaseReference

/**
 * This fitness-counter project created by :
 * Name         : syafiq
 * Date / Time  : 01 March 2018, 6:28 AM.
 * Email        : id.muhammad.syafiq@gmail.com
 * Github       : Syafiqq
 */

object PresetHelper
{
    //@formatter:off
    private fun saveBranch(preset: String, stamp:String, queue: Int, branch:String, data:Any, callback: BaseDatabaseReference.CompletionListener = object :DatabaseReference.CompletionListener{})
    { //@formatter:on
        var stamp = "20180313"
        Timber.d("saveBranch [$preset, $queue, $branch, $data, $callback]")
        val dbRef = FirebaseDatabase.getInstance().getReference("/")
        val query = HashMap<String, Any>()
        for ((key, value) in DataMapper.presetTester(preset, stamp, queue, branch))
        {
            when (key)
            { // @formatter:off
                "presets" -> {query[value] = data}
            }// @formatter:on
        }

        dbRef.updateChildren(query, callback)

    }

    //@formatter:off
    fun saveMedicalCheckUp(preset:String, stamp:String, queue:Int, data:MedicalCheckup, callback: BaseDatabaseReference.CompletionListener = object :DatabaseReference.CompletionListener{})
    { //@formatter:on
        Timber.d("saveMedicalCheckUp [$preset, $queue, $data, $callback]")
        saveBranch(preset, stamp, queue, "medical", data, callback)
    }

    //@formatter:off
    fun saveIllinois(preset:String, stamp:String, queue:Int, data:Illinois, callback: BaseDatabaseReference.CompletionListener = object :DatabaseReference.CompletionListener{})
    { //@formatter:on
        Timber.d("saveIllinois [$preset, $queue, $data, $callback]")
        saveBranch(preset, stamp, queue, "illinois", data, callback)
    }

    //@formatter:off
    fun saveVerticalJump(preset:String, stamp:String, queue:Int, data:VerticalJump, callback: BaseDatabaseReference.CompletionListener = object :DatabaseReference.CompletionListener{})
    { //@formatter:on
        Timber.d("saveVerticalJump [$preset, $queue, $data, $callback]")
        saveBranch(preset, stamp, queue, "vertical", data, callback)
    }

    //@formatter:off
    fun saveThrowingBall(preset:String, stamp:String, queue:Int, data:ThrowingBall, callback: BaseDatabaseReference.CompletionListener = object :DatabaseReference.CompletionListener{})
    { //@formatter:on
        Timber.d("saveThrowingBall [$preset, $queue, $data, $callback]")
        saveBranch(preset, stamp, queue, "throwing", data, callback)
    }

    //@formatter:off
    fun savePushUp(preset:String, stamp:String, queue:Int, data:PushUp, callback: BaseDatabaseReference.CompletionListener = object :DatabaseReference.CompletionListener{})
    { //@formatter:on
        Timber.d("savePushUp [$preset, $queue, $data, $callback]")
        saveBranch(preset, stamp, queue, "push", data, callback)
    }

    //@formatter:off
    fun saveSitUp(preset:String, stamp:String, queue:Int, data:SitUp, callback: BaseDatabaseReference.CompletionListener = object :DatabaseReference.CompletionListener{})
    { //@formatter:on
        Timber.d("saveSitUp [$preset, $queue, $data, $callback]")
        saveBranch(preset, stamp, queue, "sit", data, callback)
    }

    //@formatter:off
    fun saveRun1600m(preset:String, stamp:String, queue:Int, data:Run1600m, callback: BaseDatabaseReference.CompletionListener = object :DatabaseReference.CompletionListener{})
    { //@formatter:on
        Timber.d("saveRun1600m [$preset, $queue, $data, $callback]")
        saveBranch(preset, stamp, queue, "run", data, callback)
    }

    //@formatter:off
    fun savesRun1600m(preset:String, stamp:String, runs:Map<Int, Run1600m>, callback: BaseDatabaseReference.CompletionListener = object :DatabaseReference.CompletionListener{})
    { //@formatter:on
        Timber.d("savesRun1600m [$preset, $runs, $callback]")
        val dbRef = FirebaseDatabase.getInstance().getReference("/")
        val query = HashMap<String, Any>()
        for ((queue, data) in runs)
        {
            for ((key, value) in DataMapper.presetTester(preset, stamp, queue, "run"))
            {
                when (key)
                {   // @formatter:off
                    "presets" -> {query[value] = data}
                }   // @formatter:on
            }
        }

        dbRef.updateChildren(query, callback)
    }
}