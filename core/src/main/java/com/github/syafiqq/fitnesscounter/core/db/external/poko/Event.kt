package com.github.syafiqq.fitnesscounter.core.db.external.poko

import com.google.firebase.database.IgnoreExtraProperties
import com.google.firebase.database.PropertyName

/**
 * This fitness-counter project created by :
 * Name         : syafiq
 * Date / Time  : 24 February 2018, 10:36 AM.
 * Email        : id.muhammad.syafiq@gmail.com
 * Github       : Syafiqq
 */
@IgnoreExtraProperties
data class Event(
        @PropertyName("admin") var admin: String,
        @PropertyName("createdAt") var createdAt: String,
        @PropertyName("event") var event: String,
        @PropertyName("preset_active") var presetActive: String,
        @PropertyName("presets") var presets: Map<String, Boolean>,
        @PropertyName("slug") var slug: String
)
