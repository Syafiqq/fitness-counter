package com.github.syafiqq.fitnesscounter.core.db.external.poko.tester

import com.google.firebase.database.PropertyName

/**
 * This fitness-counter project created by :
 * Name         : syafiq
 * Date / Time  : 28 February 2018, 8:45 PM.
 * Email        : id.muhammad.syafiq@gmail.com
 * Github       : Syafiqq
 */
data class MedicalCheckup(
        // @formatter:off
        // Anthropometric
        @get:PropertyName("tbb")          @set:PropertyName("tbb")          var tbb: Float? = null,
        @get:PropertyName("tbd")          @set:PropertyName("tbd")          var tbd: Float? = null,
        @get:PropertyName("ratio")        @set:PropertyName("ratio")        var ratio: Float? = null,
        @get:PropertyName("weight")       @set:PropertyName("weight")       var weight: Float? = null,
        @get:PropertyName("bmi")          @set:PropertyName("bmi")          var bmi: Float? = null,
        // Posture and Gait
        @get:PropertyName("posture")      @set:PropertyName("posture")      var posture: String? = null,
        @get:PropertyName("gait")         @set:PropertyName("gait")         var gait: String? = null,
        // Cardiovascular
        @get:PropertyName("pulse")        @set:PropertyName("pulse")        var pulse: Float? = null,
        @get:PropertyName("pressure")     @set:PropertyName("pressure")     var pressure: String? = null,
        @get:PropertyName("ictus")        @set:PropertyName("ictus")        var ictus: String? = null,
        @get:PropertyName("heart")        @set:PropertyName("heart")        var heart: String? = null,
        // Respiratory
        @get:PropertyName("frequency")    @set:PropertyName("frequency")    var frequency: Float? = null,
        @get:PropertyName("retraction")   @set:PropertyName("retraction")   var retraction: String? = null,
        @get:PropertyName("r_location")   @set:PropertyName("r_location")   var rLocation: String? = null,
        @get:PropertyName("breath")       @set:PropertyName("breath")       var breath: String? = null,
        @get:PropertyName("b_pipeline")   @set:PropertyName("b_pipeline")   var bPipeline: String? = null,
        // Verbal
        @get:PropertyName("vision")       @set:PropertyName("vision")       var vision: String? = null,
        @get:PropertyName("hearing")      @set:PropertyName("hearing")      var hearing: String? = null,
        @get:PropertyName("verbal")       @set:PropertyName("verbal")       var verbal: String? = null,
        // Conclusion
        @get:PropertyName("conclusion")   @set:PropertyName("conclusion")   var conclusion: Boolean = false
        // @formatter:on
)