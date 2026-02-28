## Running the Android Version of "Power & Responsibility"

This repo contains the core Android Jetpack Compose implementation in `PowerResponsibilityAndroid.kt`.

To run it on Windows with Android Studio:

1. **Install Android Studio**
   - Download and install Android Studio from the official Android developer site.

2. **Create a new Android project**
   - Open Android Studio → **New Project**.
   - Choose **Empty Activity** (Jetpack Compose enabled).
   - Name it e.g. `PowerResponsibilityAndroid`.
   - Make sure **Language** is **Kotlin** and **Use Compose** is checked.

3. **Add the game code**
   - In this repo, open `PowerResponsibilityAndroid.kt`.
   - In your Android Studio project, open the `app/src/main/java/.../MainActivity.kt` file.
   - Replace the entire contents of `MainActivity.kt` with the contents of `PowerResponsibilityAndroid.kt`.
   - Adjust the `package` line at the top of the file if needed to match your app’s package name.

4. **Sync and run**
   - Click **Sync Project with Gradle Files** in Android Studio (or it will auto-sync).
   - Choose an Android emulator or a physical Android device.
   - Press **Run**.

You should see the same game loop as the iOS SwiftUI version:

- 24 turns (months)
- 3 stats: Power, Trust, Stability
- One dramatic event per turn with 3 choices
- Game over on any stat reaching 0, or a 24‑month summary screen if you survive.

