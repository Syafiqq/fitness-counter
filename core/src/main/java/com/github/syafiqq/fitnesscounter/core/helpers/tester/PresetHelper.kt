package com.github.syafiqq.fitnesscounter.core.helpers.tester

import com.github.syafiqq.fitnesscounter.core.custom.com.google.firebase.database.DatabaseReference
import com.github.syafiqq.fitnesscounter.core.db.external.DataMapper
import com.github.syafiqq.fitnesscounter.core.db.external.poko.tester.Illinois
import com.github.syafiqq.fitnesscounter.core.db.external.poko.tester.MedicalCheckup
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
    private fun saveBranch(preset: String, queue: Int, branch:String, data:Any, callback: BaseDatabaseReference.CompletionListener = object :DatabaseReference.CompletionListener{})
    { //@formatter:on
        Timber.d("saveBranch [$preset, $queue, $branch, $data, $callback]")
        val dbRef = FirebaseDatabase.getInstance().getReference("/")
        val query = HashMap<String, Any>()
        for ((key, value) in DataMapper.presetTester(preset, queue, branch))
        {
            when (key)
            { // @formatter:off
                "presets" -> {query[value] = data}
            }// @formatter:on
        }

        dbRef.updateChildren(query, callback)

    }

    //@formatter:off
    fun saveMedicalCheckUp(preset:String, queue:Int, data:MedicalCheckup, callback: BaseDatabaseReference.CompletionListener = object :DatabaseReference.CompletionListener{})
    { //@formatter:on
        Timber.d("saveMedicalCheckUp [$preset, $queue, $data, $callback]")
        saveBranch(preset, queue, "medical", data, callback)
    }

    //@formatter:off
    fun saveIllinois(preset:String, queue:Int, data:Illinois, callback: BaseDatabaseReference.CompletionListener = object :DatabaseReference.CompletionListener{})
    { //@formatter:on
        Timber.d("saveIllinois [$preset, $queue, $data, $callback]")
        saveBranch(preset, queue, "illinois", data, callback)
    }

    //@formatter:off
    fun saveVerticalJump(preset:String, queue:Int, data:VerticalJump, callback: BaseDatabaseReference.CompletionListener = object :DatabaseReference.CompletionListener{})
    { //@formatter:on
        Timber.d("saveVerticalJump [$preset, $queue, $data, $callback]")
        saveBranch(preset, queue, "vertical", data, callback)
    }
}