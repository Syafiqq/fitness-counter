package com.github.syafiqq.fitnesscounter.core.db.external.poko

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties
import com.google.firebase.database.PropertyName
import java.io.Serializable

/**
 * This fitness-counter project created by :
 * Name         : syafiq
 * Date / Time  : 24 February 2018, 10:36 AM.
 * Email        : id.muhammad.syafiq@gmail.com
 * Github       : Syafiqq
 */
@IgnoreExtraProperties
data class Event(
        @get:PropertyName("admin") @set:PropertyName("admin") var admin: String? = null,
        @get:PropertyName("createdAt") @set:PropertyName("createdAt") var createdAt: Long? = 0,
        @get:PropertyName("event") @set:PropertyName("event") var event: String? = null,
        @get:PropertyName("preset_active") @set:PropertyName("preset_active") var presetActive: String? = null,
        @get:PropertyName("presets") @set:PropertyName("presets") var presets: Map<String, Boolean> = mapOf(),
        @get:PropertyName("slug") @set:PropertyName("slug") var slug: String? = null,
        @get:Exclude @set:Exclude var id: String? = null
): Serializable
