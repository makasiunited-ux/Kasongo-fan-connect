# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# signingConfig files list in build.gradle.kts

-keepattributes *Annotation*
-keepattributes InnerClasses
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends androidx.preference.Preference

# Retrofit
-keepattributes Signature
-keepattributes *Annotation*
-keep class com.google.gson.** { *; }
-keep interface com.google.gson.** { *; }
-keep class com.squareup.retrofit2.** { *; }

# Firebase
-keep class com.firebase.** { *; }
-keep class com.google.firebase.** { *; }
-keep class com.google.** { *; }

# Hilt
-keep class * extends dagger.hilt.android.lifecycle.HiltViewModel { *; }

# Kotlin
-keepclassmembers class ** {
    @kotlin.Metadata public <methods>;
}

# WebRTC
-keep class org.webrtc.** { *; }

# Jitsi
-keep class org.jitsi.** { *; }
-keep class com.jitsi.** { *; }

# Remove logging
-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** v(...);
}