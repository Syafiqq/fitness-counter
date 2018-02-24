package com.github.syafiqq.fitnesscounter.core.db.external.poko

import com.google.firebase.database.IgnoreExtraProperties
import com.google.firebase.database.PropertyName

/**
 * This fitness-counter project created by :
 * Name         : syafiq
 * Date / Time  : 24 February 2018, 12:37 PM.
 * Email        : id.muhammad.syafiq@gmail.com
 * Github       : Syafiqq
 */
@IgnoreExtraProperties
data class EventCategory(@get:PropertyName("category") @set:PropertyName("category") var category: String? = null)