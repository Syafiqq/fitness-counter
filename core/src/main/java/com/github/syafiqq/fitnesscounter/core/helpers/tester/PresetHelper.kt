package com.github.syafiqq.fitnesscounter.core.helpers.tester

import com.github.syafiqq.fitnesscounter.core.custom.com.google.firebase.database.DatabaseReference
import com.github.syafiqq.fitnesscounter.core.db.external.DataMapper
import com.github.syafiqq.fitnesscounter.core.db.external.poko.tester.*
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
        Timber.d("saveBranch [$preset, $stamp $queue, $branch, $data, $callback]")
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
        Timber.d("saveMedicalCheckUp [$preset, $stamp $queue, $data, $callback]")
        saveBranch(preset, stamp, queue, "medical", data, callback)
    }

    //@formatter:off
    fun saveIllinois(preset:String, stamp:String, queue:Int, data:Illinois, callback: BaseDatabaseReference.CompletionListener = object :DatabaseReference.CompletionListener{})
    { //@formatter:on
        Timber.d("saveIllinois [$preset, $stamp $queue, $data, $callback]")
        saveBranch(preset, stamp, queue, "illinois", data, callback)
    }

    //@formatter:off
    fun saveVerticalJump(preset:String, stamp:String, queue:Int, data:VerticalJump, callback: BaseDatabaseReference.CompletionListener = object :DatabaseReference.CompletionListener{})
    { //@formatter:on
        Timber.d("saveVerticalJump [$preset, $stamp $queue, $data, $callback]")
        saveBranch(preset, stamp, queue, "vertical", data, callback)
    }

    //@formatter:off
    fun saveThrowingBall(preset:String, stamp:String, queue:Int, data:ThrowingBall, callback: BaseDatabaseReference.CompletionListener = object :DatabaseReference.CompletionListener{})
    { //@formatter:on
        Timber.d("saveThrowingBall [$preset, $stamp $queue, $data, $callback]")
        saveBranch(preset, stamp, queue, "throwing", data, callback)
    }

    //@formatter:off
    fun savePushUp(preset:String, stamp:String, queue:Int, data:PushUp, callback: BaseDatabaseReference.CompletionListener = object :DatabaseReference.CompletionListener{})
    { //@formatter:on
        Timber.d("savePushUp [$preset, $stamp $queue, $data, $callback]")
        saveBranch(preset, stamp, queue, "push", data, callback)
    }

    //@formatter:off
    fun saveSitUp(preset:String, stamp:String, queue:Int, data:SitUp, callback: BaseDatabaseReference.CompletionListener = object :DatabaseReference.CompletionListener{})
    { //@formatter:on
        Timber.d("saveSitUp [$preset, $stamp $queue, $data, $callback]")
        saveBranch(preset, stamp, queue, "sit", data, callback)
    }

    //@formatter:off
    fun saveRun1600m(preset:String, stamp:String, queue:Int, data:Run1600m, callback: BaseDatabaseReference.CompletionListener = object :DatabaseReference.CompletionListener{})
    { //@formatter:on
        Timber.d("saveRun1600m [$preset, $stamp $queue, $data, $callback]")
        saveBranch(preset, stamp, queue, "run", data, callback)
    }

    //@formatter:off
    fun savesRun1600m(preset:String, stamp:String, runs:Map<Int, Run1600m>, callback: BaseDatabaseReference.CompletionListener = object :DatabaseReference.CompletionListener{})
    { //@formatter:on
        Timber.d("savesRun1600m [$preset, $stamp $runs, $callback]")
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

    object Bulk {
        //@formatter:off
        private fun saveBranch(preset: String, branch:String, bulks:List<Triple<Int, String, Any>>, callback: BaseDatabaseReference.CompletionListener = object :DatabaseReference.CompletionListener{})
        { //@formatter:on
            Timber.d("saveBranch [$preset, $branch, $bulks, $callback]")
            val dbRef = FirebaseDatabase.getInstance().getReference("/")
            val query = HashMap<String, Any>()
            for ((queue, stamp, bulk) in bulks) {
                query[DataMapper.presetTester(preset, stamp, queue, branch)["presets"]!!] = bulk
            }

            dbRef.updateChildren(query, callback)
        }

        fun saveMedicalCheckUp(preset: String, medical: List<Triple<Int, String, MedicalCheckup>>, callback: BaseDatabaseReference.CompletionListener = object : DatabaseReference.CompletionListener {}) { //@formatter:on
            Timber.d("saveMedicalCheckUp [$preset, $medical, $callback]")
            saveBranch(preset, "medical", medical, callback)
        }

        fun saveIllinois(preset: String, illinois: List<Triple<Int, String, Illinois>>, callback: BaseDatabaseReference.CompletionListener = object : DatabaseReference.CompletionListener {}) {
            Timber.d("saveIllinois [$preset, $illinois, $callback]")
            saveBranch(preset, "illinois", illinois, callback)
        }

        fun saveVerticalJump(preset: String, vertical: List<Triple<Int, String, VerticalJump>>, callback: BaseDatabaseReference.CompletionListener = object : DatabaseReference.CompletionListener {}) {
            Timber.d("saveVerticalJump [$preset, $vertical, $callback]")
            saveBranch(preset, "vertical", vertical, callback)
        }

        fun saveThrowingBall(preset: String, throwing: List<Triple<Int, String, ThrowingBall>>, callback: BaseDatabaseReference.CompletionListener = object : DatabaseReference.CompletionListener {}) {
            Timber.d("saveThrowingBall [$preset, $throwing, $callback]")
            saveBranch(preset, "throwing", throwing, callback)
        }

        fun savePushUp(preset: String, push: List<Triple<Int, String, PushUp>>, callback: BaseDatabaseReference.CompletionListener = object : DatabaseReference.CompletionListener {}) {
            Timber.d("savePushUp [$preset, $push, $callback]")
            saveBranch(preset, "push", push, callback)
        }

        fun saveSitUp(preset: String, sit: List<Triple<Int, String, SitUp>>, callback: BaseDatabaseReference.CompletionListener = object : DatabaseReference.CompletionListener {}) {
            Timber.d("saveSitUp [$preset, $sit, $callback]")
            saveBranch(preset, "sit", sit, callback)
        }

        fun saveRun1600m(preset: String, run: List<Triple<Int, String, Run1600m>>, callback: BaseDatabaseReference.CompletionListener = object : DatabaseReference.CompletionListener {}) {
            Timber.d("saveRun1600m [$preset, $run, $callback]")
            saveBranch(preset, "run", run, callback)
        }
    }
}